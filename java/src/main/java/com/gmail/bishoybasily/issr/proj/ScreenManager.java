package com.gmail.bishoybasily.issr.proj;

import com.gmail.bishoybasily.issr.proj.screen.ScreenBase;
import javafx.scene.layout.StackPane;

public class ScreenManager extends StackPane {

    private Class<? extends ScreenBase> activeScreenClass;

    public void show(Class<? extends ScreenBase> c) throws Exception {
        getChildren().setAll(c.getConstructor().newInstance().load());
        activeScreenClass = c;
    }

    public Class<? extends ScreenBase> getActiveScreenClass() {
        return activeScreenClass;
    }

    public boolean isActive(Class<? extends ScreenBase> screenClass) {
        return activeScreenClass != null && activeScreenClass.equals(screenClass);
    }

}
