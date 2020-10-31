package com.jin.gateway.downstream.config;

import com.jin.gateway.downstream.endpoint.MyEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wu.jinqing
 * @date 2020年05月28日
 */
@Configuration
public class MyConfig {
    @Bean
    public MyConfigBean myConfigBean()
    {
        return new MyConfigBean();
    }

    @Bean
    public MyEndpoint myEndpoint()
    {
        return new MyEndpoint();
    }
}
