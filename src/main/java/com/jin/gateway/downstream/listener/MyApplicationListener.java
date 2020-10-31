package com.jin.gateway.downstream.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 *
 class org.springframework.boot.context.event.ApplicationStartingEvent
 class org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
 class org.springframework.boot.context.event.ApplicationContextInitializedEvent
 class org.springframework.boot.context.event.ApplicationPreparedEvent
 class org.springframework.context.event.ContextRefreshedEvent
 class org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent
 class org.springframework.boot.context.event.ApplicationStartedEvent
 class org.springframework.boot.context.event.ApplicationReadyEvent
 * @author wu.jinqing
 * @date 2020年05月27日
 */
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println(event.getClass());

    }
}
