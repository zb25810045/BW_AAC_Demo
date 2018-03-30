package com.bloodcrown.bwaacdemo.view;

import android.arch.lifecycle.LiveData;
import android.util.Log;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/19 上午12:22
 * 描述 ：
 */

public class MyLiveData extends LiveData<String> {

    @Override
    protected void setValue(String value) {
        super.setValue(value);
        Log.d("BBB", "setValue..." + value);
    }

    @Override
    protected void onActive() {
        super.onActive();
        Log.d("BBB", "onActive...");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.d("BBB", "onInactive...");
    }
}
