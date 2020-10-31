package com.jin.gateway.downstream.config;

import com.jin.gateway.downstream.condition.MyConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author wu.jinqing
 * @date 2020年07月29日
 */
@Configuration
@MyConditional(name = "MyConditional")
public class MyConfigOnMyConditional {
    @Bean
    public MyConfigBean2 bean()
    {
        System.out.println("MyConfigBean2 init");
        return new MyConfigBean2();
    }
}
