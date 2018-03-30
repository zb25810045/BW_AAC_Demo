package com.bloodcrown.bwaacdemo.respositroy;

import com.bloodcrown.bwaacdemo.bean.Book;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/28 上午11:47
 * 描述 ：
 */

public class BookNetDataSource {

    private Book mPrivateBook = new Book("私有数据在此");
    private Book mPublicBook = new Book("共有数据在此");

    public Observable<Book> getPrivateBook() {
        return getData(new Book("私有数据如如下：private"));
    }

    public Observable<Book> getPublicBook() {
        return getData(new Book("全局数据如如下： public"));
    }

    private Observable<Book> getData(final Book book) {
        return Observable.timer(2, TimeUnit.SECONDS)
                .map(new Function<Long, Book>() {
                    @Override
                    public Book apply(Long aLong) throws Exception {
                        return book;
                    }
                }).subscribeOn(Schedulers.io());
    }

}
