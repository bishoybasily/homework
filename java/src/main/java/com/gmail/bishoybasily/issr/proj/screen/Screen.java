package com.gmail.bishoybasily.issr.proj.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public interface Screen {

    default Parent load() throws Exception {
        return FXMLLoader.load(getClass().getResource(getResource()));
    }

    String getResource();

}
