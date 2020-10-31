package com.jin.gateway.downstream.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wu.jinqing
 * @date 2020年08月07日
 */
public class MyClient {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        System.out.println("0" + Thread.currentThread().getName());
        executorService.submit(new MyRunnable("zhan"));


    }
}
