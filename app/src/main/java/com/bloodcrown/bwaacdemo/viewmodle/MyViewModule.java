package com.bloodcrown.bwaacdemo.viewmodle;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.bloodcrown.bwaacdemo.bean.Book;
import com.bloodcrown.bwaacdemo.respositroy.BookRespositroy;
import com.bloodcrown.bwaacdemo.respositroy.Response;
import com.bloodcrown.bwaacdemo.view.SecondActivity;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/20 上午6:59
 * 描述 ：
 */

public class MyViewModule extends AndroidViewModel {

    public String name;
    private BookRespositroy mBookRespositroy;

    public MyViewModule(@NonNull Application application, String name) {
        super(application);
        this.name = name;
        mBookRespositroy = new BookRespositroy();
    }

    public MutableLiveData<Response<Book>> getPrivateBookLiveData() {
        return mBookRespositroy.getPrivateLiveData();
    }

    public void getPrivateBookData() {
        mBookRespositroy.refreshPrivateData();
    }

    public void startSecondActvity() {
        Intent intent = new Intent(getApplication(), SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);
    }

    public static class Factroy extends ViewModelProvider.NewInstanceFactory {

        public Application application;
        public String name;

        public Factroy(Application application, String name) {
            this.application = application;
            this.name = name;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MyViewModule(application, name);
        }
    }

}
