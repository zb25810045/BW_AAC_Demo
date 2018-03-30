package com.bloodcrown.bwaacdemo.view;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bloodcrown.bwaacdemo.R;
import com.bloodcrown.bwaacdemo.bean.Book;
import com.bloodcrown.bwaacdemo.respositroy.BookRespositroy;
import com.bloodcrown.bwaacdemo.respositroy.Response;

public class SecondActivity extends AppCompatActivity {

    private Button btn_send;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("BBB", "second:creat");
        setContentView(R.layout.activity_second);

        dialog = new ProgressDialog(this);
        dialog.setTitle("测试");
        dialog.setMessage("加载中......");

        BookRespositroy.getPublicLiveData().observe(this, new Observer<Response<Book>>() {
            @Override
            public void onChanged(@Nullable Response<Book> response) {
                if (response.code == Response.CODE_LOADING) {
                    dialog.show();
                    return;
                }
                if (response.code == Response.CODE_SUCCESS) {
                    dialog.dismiss();
                    Toast.makeText(SecondActivity.this, "数据同步成功,请返回主界面查看", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookRespositroy.refreshPublicData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("BBB", "second:resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("BBB", "second:start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("BBB", "second:stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("BBB", "second:pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("BBB", "second:restart");
    }

}
