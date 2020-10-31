package com.jin.gateway.downstream.service;

import com.jin.gateway.downstream.bean.Student;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wu.jinqing
 * @date 2020年09月11日
 */
public interface MyInterface {
    public Student student4(@RequestBody Student s);
}
