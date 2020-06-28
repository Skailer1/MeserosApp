package com.example.meserosapp;

import android.app.Application;
import android.content.Context;

import com.example.meserosapp.data.preferences.SharedPreferencesManager;

public class MesappApplication extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        setAppContext(this);
    }

    public static SharedPreferencesManager obtenerSharedPreferencesManager() {
        return new SharedPreferencesManager(appContext);
    }

    public static Context getAppContext() {
        return appContext;
    }

    private static void setAppContext(Context appContext) {
        MesappApplication.appContext = appContext;
    }
}
