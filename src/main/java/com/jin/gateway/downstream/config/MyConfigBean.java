package com.jin.gateway.downstream.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author wu.jinqing
 * @date 2020年05月28日
 */
public class MyConfigBean {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
