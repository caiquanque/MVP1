package com.example.thongdt.mvp1;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        ActiveAndroid.initialize(this);
    }
}
