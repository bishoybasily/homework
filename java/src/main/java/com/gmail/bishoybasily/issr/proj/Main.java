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

    public final static ScreenManager SCREEN_MANAGER = new ScreenManager();
    @Inject
    protected HikariDataSource hikariDataSource;
    @Inject
    protected Flyway flyway;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ComponentMain.Initializer.init().inject(this);

        String title = "Hello World";
        int width = 800;
        int height = 600;

        stage.setTitle(title);
        Scene scene = new Scene(SCREEN_MANAGER, width, height);
        stage.setScene(scene);
        stage.show();

        SCREEN_MANAGER.show(ScreenHome.class);

        stage.setOnCloseRequest(event -> hikariDataSource.close());

        flyway.migrate();

    }

}
