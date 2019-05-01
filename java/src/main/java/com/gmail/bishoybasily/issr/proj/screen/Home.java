package com.gmail.bishoybasily.issr.proj.screen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable, Screen {

    @FXML
    private TableView tableUsers;
    @FXML
    private TableColumn columnName, columnEmail, columnTelephone;
    @FXML
    private TextField textName, textEmail, textTelephone;
    @FXML
    private Button buttonSave;

    @Override
    public String getResource() {
        return "/home.fxml";
    }

    public void initialize(URL location, ResourceBundle resources) {

        buttonSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {


            }
        });
    }

}
