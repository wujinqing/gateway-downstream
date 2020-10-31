package com.jin.gateway.downstream.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

/**
 * @author wu.jinqing
 * @date 2020年07月29日
 */
@Endpoint(id = "myEndpoint")
public class MyEndpoint {

    @ReadOperation
    public MyEndpointBean myEndpointBean()
    {
        MyEndpointBean bean = new MyEndpointBean();

        bean.setName("张三");
        bean.setAge(20);

        return bean;
    }
}
