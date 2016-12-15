package me.pheynix.designpattern.module;

import android.app.Application;

/**
 * Application单例
 * Created by dujigui on 12/15/16.
 */

public class App extends Application {
    static App APP;

    @Override
    public void onCreate() {
        super.onCreate();
        APP = this;
    }

    public App getApplication(){
        return APP;
    }
}
