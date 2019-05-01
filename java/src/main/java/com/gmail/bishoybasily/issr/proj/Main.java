package com.gmail.bishoybasily.issr.proj;

import com.gmail.bishoybasily.issr.proj.di.ComponentMain;
import com.gmail.bishoybasily.issr.proj.screen.ScreenHome;
import com.zaxxer.hikari.HikariDataSource;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.flywaydb.core.Flyway;

import javax.inject.Inject;

public class Main extends Application {

    @Inject
    protected HikariDataSource hikariDataSource;
    @Inject
    protected Flyway flyway;
    @Inject
    protected ScreenManager screenManager;
    @Inject
    protected Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ComponentMain.Initializer.init().inject(this);

        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();

        flyway.migrate();

        screenManager.show(ScreenHome.class);

        stage.setOnCloseRequest(event -> hikariDataSource.close());

    }

}
