package com.bloodcrown.bwaacdemo.respositroy;

import android.arch.lifecycle.MutableLiveData;

import com.bloodcrown.bwaacdemo.bean.Book;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/28 上午11:44
 * 描述 ：
 */

public class BookRespositroy {

    public static MutableLiveData<Response<Book>> PUBLIC_LIVEDATA;

    private MutableLiveData<Response<Book>> mBookLiveData;
    private BookNetDataSource mBookNetDataSource;

    static {
        PUBLIC_LIVEDATA = new MutableLiveData<>();
    }

    public static MutableLiveData<Response<Book>> getPublicLiveData() {
        return PUBLIC_LIVEDATA;
    }

    public static void refreshPublicData() {
        PUBLIC_LIVEDATA.setValue(new Response<Book>(Response.CODE_LOADING, null));
        new BookNetDataSource().getPublicBook()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Book>() {
                    @Override
                    public void accept(Book book) throws Exception {
                        PUBLIC_LIVEDATA.setValue(new Response<Book>(Response.CODE_SUCCESS, book));
                    }
                });
    }

    public BookRespositroy() {
        mBookNetDataSource = new BookNetDataSource();
        mBookLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Response<Book>> getPrivateLiveData() {
        return mBookLiveData;
    }

    public void refreshPrivateData() {
        mBookLiveData.setValue(new Response<Book>(Response.CODE_LOADING, null));
        mBookNetDataSource.getPrivateBook()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Book>() {
                    @Override
                    public void accept(Book book) throws Exception {
                        mBookLiveData.setValue(new Response<Book>(Response.CODE_SUCCESS, book));
                    }
                });
    }


}
