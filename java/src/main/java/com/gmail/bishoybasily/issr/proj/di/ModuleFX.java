package com.gmail.bishoybasily.issr.proj.di;

import com.gmail.bishoybasily.issr.proj.ScreenManager;
import dagger.Module;
import dagger.Provides;
import javafx.scene.Scene;

import javax.inject.Singleton;

@Module
public class ModuleFX {

    @Singleton
    @Provides
    public ScreenManager screenManager() {
        return new ScreenManager();
    }

    @Singleton
    @Provides
    public Scene scene(ScreenManager screenManager) {
        return new Scene(screenManager, 800, 600);
    }

}
