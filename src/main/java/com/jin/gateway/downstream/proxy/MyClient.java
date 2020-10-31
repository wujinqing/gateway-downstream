package com.jin.gateway.downstream.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wu.jinqing
 * @date 2020年07月26日
 */
public class MyClient {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();

        InvocationHandler invocationHandler = new MyInvocationHandler(myInterface);

        MyInterface proxy = (MyInterface)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), myInterface.getClass().getInterfaces(), invocationHandler);

        proxy.doSomething();
    }
}
