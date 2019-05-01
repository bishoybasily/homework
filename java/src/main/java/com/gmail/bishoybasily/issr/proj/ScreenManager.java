package com.gmail.bishoybasily.issr.proj;

import com.gmail.bishoybasily.issr.proj.screen.Screen;
import javafx.scene.layout.StackPane;

public class ScreenManager extends StackPane {

    private String visibleFormClassName;

    public void show(Class<? extends Screen> c) throws Exception {
        getChildren().setAll(c.getConstructor().newInstance().load());
        visibleFormClassName = c.getName();
    }

    public String getVisibleScreenClassName() {
        return visibleFormClassName;
    }

}
