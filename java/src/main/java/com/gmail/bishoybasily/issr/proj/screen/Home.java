package com.gmail.bishoybasily.issr.proj.screen;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable, Screen {

    public Parent load() throws Exception {
        return FXMLLoader.load(getClass().getResource("/home.fxml"));
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

}
