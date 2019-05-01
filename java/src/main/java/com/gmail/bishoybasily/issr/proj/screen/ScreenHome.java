package com.gmail.bishoybasily.issr.proj.screen;

import com.gmail.bishoybasily.issr.proj.di.ComponentMain;
import com.gmail.bishoybasily.issr.proj.model.entity.User;
import com.gmail.bishoybasily.issr.proj.model.service.ServiceUsers;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class ScreenHome implements Initializable, ScreenBase {

    @Inject
    protected ServiceUsers serviceUsers;
    @FXML
    private TableView<User> tableUsers;
    @FXML
    private TextField textName, textEmail, textTelephone;
    @FXML
    private Button buttonSave;
    @FXML
    private TableColumn<User, String> columnName, columnEmail, columnTelephone;
    @FXML
    private TableColumn<User, Number> columnDelete;

    @Override
    public String getResource() {
        return "/home.fxml";
    }

    public void initialize(URL location, ResourceBundle resources) {

        ComponentMain.Initializer.get().inject(this);

        columnName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        columnEmail.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEmail()));
        columnTelephone.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getTelephone()));
        columnDelete.setCellValueFactory(param -> new SimpleLongProperty(param.getValue().getId()));

        columnDelete.setCellFactory(new Callback<TableColumn<User, Number>, TableCell<User, Number>>() {
            @Override
            public TableCell<User, Number> call(TableColumn<User, Number> param) {
                return new TableCell<User, Number>() {

                    @Override
                    protected void updateItem(Number item, boolean empty) {
                        super.updateItem(item, empty);

                        setText(null);
                        setGraphic(null);

                        if (!empty) {
                            Button buttonDelete = new Button("Delete");
                            buttonDelete.setOnAction(event -> {
                                serviceUsers.delete(item.longValue());
                                refreshTable();
                            });
                            setGraphic(buttonDelete);
                        }

                    }


                };
            }
        });


        buttonSave.setOnAction(event -> {
            serviceUsers.save(User.from(textName.getText(), textEmail.getText(), textTelephone.getText()));
            refreshTable();
        });

        refreshTable();

    }

    private void refreshTable() {
        tableUsers.setItems(FXCollections.observableArrayList(serviceUsers.getAll()));
    }

}
