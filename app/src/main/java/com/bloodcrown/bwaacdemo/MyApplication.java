package com.bloodcrown.bwaacdemo;

import android.app.Application;

import com.bloodcrown.bwaacdemo.view.MyLiveData;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/19 上午7:49
 * 描述 ：
 */

public class MyApplication extends Application {

    private static MyApplication INSTANCE;

    public static MyApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
