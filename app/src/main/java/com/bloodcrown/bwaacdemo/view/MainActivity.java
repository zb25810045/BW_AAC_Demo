package com.bloodcrown.bwaacdemo.view;

import android.app.ProgressDialog;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bloodcrown.bwaacdemo.R;
import com.bloodcrown.bwaacdemo.bean.Book;
import com.bloodcrown.bwaacdemo.databinding.ActivityMainBinding;
import com.bloodcrown.bwaacdemo.respositroy.BookRespositroy;
import com.bloodcrown.bwaacdemo.respositroy.Response;
import com.bloodcrown.bwaacdemo.viewmodle.MyViewModule;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MyViewModule myViewModule;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 初始化 DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 使用自定义构造器方式创建 ViewModule 对象
        MyViewModule.Factroy factroy = new MyViewModule.Factroy(getApplication(), "AAA");
        myViewModule = ViewModelProviders.of(this, factroy).get(MyViewModule.class);

        // 设置 DataBinding 相关数据
        binding.setViewModule(myViewModule);
        binding.setViewData(getResources().getString(R.string.main_tx_viewData));
        binding.setAppData(getResources().getString(R.string.main_tx_appData));

        // 新建对话框
        dialog = new ProgressDialog(this);
        dialog.setTitle("测试");
        dialog.setMessage("加载中......");

        // 注册用于测试 lifecycle 的自定义 view
        getLifecycle().addObserver(binding.txLifecley);

        // lifecycle 可以获取页面的当前显示状态，执行一些操作
        Lifecycle.State currentState = getLifecycle().getCurrentState();
        if (currentState == Lifecycle.State.STARTED) {
            // .....................
        }

        // 注册页面所有生命周期监听演示
        getLifecycle().addObserver(new LifecycleObserver() {

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public void start() {
                Log.d("AAA", "new_onstart...");
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void resume() {
                Log.d("AAA", "new_onresume...");
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public void pasue() {
                Log.d("AAA", "new_onpause...");
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void stop() {
                Log.d("AAA", "new_onstop...");
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void destroy() {
                Log.d("AAA", "new_ondestroy...");
            }

        });

        // 从 ViewModule 中获取页面私有数据源的管道，建立联系，Response 中包含请求响应状态码
        myViewModule.getPrivateBookLiveData().observe(this, new Observer<Response<Book>>() {
            @Override
            public void onChanged(@Nullable Response<Book> response) {
                if (response == null) {
                    return;
                }
                int code = response.code;
                if (code == Response.CODE_LOADING) {
                    dialog.show();
                    return;
                }
                if (code == Response.CODE_SUCCESS) {
                    dialog.dismiss();
                    binding.setViewData(response.data.getName());
                    return;
                }
            }
        });

        // 从 ViewModule 中获取全局公共数据源的管道，建立联系
        BookRespositroy.getPublicLiveData().observe(this, new Observer<Response<Book>>() {
            @Override
            public void onChanged(@Nullable Response<Book> response) {
                if (response == null) {
                    return;
                }
                int code = response.code;
                if (code == Response.CODE_LOADING) {
                    dialog.show();
                    return;
                }
                if (code == Response.CODE_SUCCESS) {
                    dialog.dismiss();
                    binding.setAppData(response.data.getName());
                    return;
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("BBB", "main:resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("BBB", "main:start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("BBB", "main:stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("BBB", "main:pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("BBB", "main:restart");
    }
}
