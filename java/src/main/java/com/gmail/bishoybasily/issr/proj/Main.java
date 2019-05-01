package com.gmail.bishoybasily.issr.proj;

import com.gmail.bishoybasily.issr.proj.screen.Home;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private final static ScreenManager SCREEN_MANAGER = new ScreenManager();

    public static ScreenManager getScreenManager() {
        return SCREEN_MANAGER;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(SCREEN_MANAGER, 800, 600));
        primaryStage.show();

        SCREEN_MANAGER.show(Home.class);

    }

}
