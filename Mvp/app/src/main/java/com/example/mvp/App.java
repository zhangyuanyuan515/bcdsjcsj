package com.example.mvp;

import android.app.Application;

import java.util.HashMap;

public class App extends Application {
    public  App app;
    public HashMap<String,Object> map;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        map=new HashMap<String, Object>();
    }
}
