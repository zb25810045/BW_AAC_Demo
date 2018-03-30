package com.bloodcrown.bwaacdemo.bean;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/27 下午12:48
 * 描述 ：
 */

public class Book {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
}
