package com.gmail.bishoybasily.issr.proj.screen;

import com.gmail.bishoybasily.issr.proj.di.ComponentMain;
import com.gmail.bishoybasily.issr.proj.model.entity.User;
import com.gmail.bishoybasily.issr.proj.model.service.ServiceUsers;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    @Override
    public String getResource() {
        return "/home.fxml";
    }

    public void initialize(URL location, ResourceBundle resources) {

        ComponentMain.Initializer.get().inject(this);

        tableUsers.setItems(FXCollections.observableArrayList(serviceUsers.getAll()));


        buttonSave.setOnAction(event -> {

        });

    }

}
