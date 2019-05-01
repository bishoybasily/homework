package com.gmail.bishoybasily.issr.proj.di;

import com.gmail.bishoybasily.issr.proj.Main;
import com.gmail.bishoybasily.issr.proj.screen.ScreenHome;
import dagger.Component;

@Component(modules = {
        ModuleDatabase.class
})
public interface ComponentMain {

    void inject(Main main);

    void inject(ScreenHome screenHome);

    class Initializer {

        private static ComponentMain componentMain;

        public static ComponentMain init() {
            return componentMain = DaggerComponentMain.builder().build();
        }

        public static ComponentMain get() {
            return componentMain;
        }

    }

}
