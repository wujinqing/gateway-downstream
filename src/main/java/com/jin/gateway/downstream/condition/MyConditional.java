package com.jin.gateway.downstream.condition;

import org.springframework.context.annotation.Conditional;

/**
 * @author wu.jinqing
 * @date 2020年07月29日
 */
@Conditional(MyCondition.class)
public @interface MyConditional {
    String name();
}
