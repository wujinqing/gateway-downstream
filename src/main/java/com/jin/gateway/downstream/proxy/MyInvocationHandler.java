package com.jin.gateway.downstream.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wu.jinqing
 * @date 2020年07月26日
 */
public class MyInvocationHandler implements InvocationHandler {
    private MyInterface myInterface;

    public MyInvocationHandler(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用前");
        method.invoke(myInterface, args);

        System.out.println("调用后");
        return null;
    }
}
