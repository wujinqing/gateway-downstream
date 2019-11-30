package com.jin.gateway.downstream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wu.jinqing
 * @date 2019年11月26日
 */
@SpringBootApplication
@EnableAutoConfiguration
@RestController
@Slf4j
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello from downstream.";
    }

    @RequestMapping("/after")
    public String after()
    {
        return "after from downstream.";
    }

    @RequestMapping("/before")
    public String before()
    {
        return "before from downstream.";
    }

    @RequestMapping("/between")
    public String between()
    {
        return "between from downstream.";
    }

    @RequestMapping("/header")
    public String header()
    {
        return "header from downstream.";
    }

    @RequestMapping("/addHeader")
    public String addHeader(HttpServletRequest req)
    {
        String v = req.getHeader("name");
        System.out.println(v);
        return "addHeader from downstream.";
    }

    @RequestMapping("/addRequestParameter")
    public String addRequestParameter(HttpServletRequest req)
    {
        String[] v = req.getParameterValues("name");
        System.out.println(v[0]);
        return "addRequestParameter from downstream.";
    }
}
