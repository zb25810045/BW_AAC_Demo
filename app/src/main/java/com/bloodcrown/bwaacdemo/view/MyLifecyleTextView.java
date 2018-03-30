package com.bloodcrown.bwaacdemo.view;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/14 下午3:54
 * 描述 ：
 */

@SuppressLint("AppCompatCustomView")
public class MyLifecyleTextView extends TextView implements LifecycleObserver {

    public MyLifecyleTextView(Context context) {
        super(context);
    }

    public MyLifecyleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLifecyleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MyLifecyleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void creat() {
        Log.d("AAA", "oncreat...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        Log.d("AAA", "onstart...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        Log.d("AAA", "onresume...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pasue() {
        Log.d("AAA", "onpause...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        Log.d("AAA", "onstop...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        Log.d("AAA", "ondestroy...");
    }

}
