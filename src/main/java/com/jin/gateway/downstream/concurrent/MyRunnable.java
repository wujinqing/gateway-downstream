package com.jin.gateway.downstream.concurrent;

/**
 * @author wu.jinqing
 * @date 2020年08月07日
 */
public class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        System.out.println("1" + Thread.currentThread().getName());
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("2" + Thread.currentThread().getName());
        System.out.println("do something.");
    }
}
