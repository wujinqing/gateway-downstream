package com.jin.gateway.downstream.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author wu.jinqing
 * @date 2020年09月10日
 */
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotation {
}
