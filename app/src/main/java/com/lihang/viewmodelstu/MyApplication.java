package com.lihang.viewmodelstu;
import android.app.Application;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class MyApplication extends Application {
    public static MyApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static MyApplication getInstance() {
        if (context == null) {
            context = new MyApplication();
        }
        return context;
    }
}
