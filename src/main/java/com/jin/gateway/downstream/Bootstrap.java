package com.jin.gateway.downstream;

import com.jin.gateway.downstream.bean.Student;
import com.jin.gateway.downstream.config.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author wu.jinqing
 * @date 2019年11月26日
 */
@SpringBootApplication
@RestController
@Slf4j
public class Bootstrap {
    @Value("${user.name1}")
    private String name;
    @Value("${secret.property}")
    private String secret;
    @Autowired
    private StringEncryptor stringEncryptor;
    public static final String id = "id_9090";

    private final String  LOG_DEBUG_PROFILE_KEY = "log.debug";
    private final String  LOG_DEBUG_PROFILE_VALUE = "ON";

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Bootstrap.class);

//        springApplication.setAdditionalProfiles("LOGDEBUG", "DEV211");

        ConfigurableApplicationContext context = springApplication.run(args);

//        for (String s : context.getBeanDefinitionNames()) {
//            System.out.println(s);
//        }
    }

    @RequestMapping(value = "/student", produces = "application/json", consumes = "application/json")
    public Student student(@RequestBody Student s)
    {
        Student student = new Student();

        student.setName("zhang san");
        student.setAge(10);

        return student;
    }

    @RequestMapping(value = "/student2", produces = "application/json", consumes = "application/json")
    public Student student2(@RequestBody Student s)
    {
        Student student = new Student();

        student.setName("zhang san");
        student.setAge(11);

        return student;
    }

    @RequestMapping(value = "/student3", produces = "application/json", consumes = "application/json")
    public Student student3(@RequestBody Student s)
    {
        Student student = new Student();

        student.setName("zhang san");
        student.setAge(12);

        return student;
    }

    @RequestMapping("/log")
    @MyAnnotation
    public String log()
    {
        log.info("info log");
        return "hello log.";
    }

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello from downstream." + id;
    }

    @RequestMapping("/after")
    public String after()
    {
        return "after from downstream." + id;
    }

    @RequestMapping("/before")
    public String before()
    {
        return "before from downstream." + id;
    }

    @RequestMapping("/between")
    public String between()
    {
        return "between from downstream." + id;
    }

    @RequestMapping("/header")
    public String header()
    {
        return "header from downstream." + id;
    }

    @RequestMapping("/addHeader")
    public String addHeader(HttpServletRequest req)
    {
        String v = req.getHeader("name");
        System.out.println(v);
        return "addHeader from downstream." + id;
    }

    @RequestMapping("/addRequestParameter")
    public String addRequestParameter(HttpServletRequest req)
    {
        String[] v = req.getParameterValues("name");
        System.out.println(v[0]);
        return "addRequestParameter from downstream." + id;
    }

    @RequestMapping("/hystrix")
    public String hystrix()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix from downstream." + id;
    }

    @RequestMapping("/sale/shopping")
    public String shopping()
    {
        System.out.println("enter");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "shopping from downstream." + id;
    }

    @RequestMapping("/sale/pricing")
    public String pricing()
    {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "pricing from downstream." + id;
    }

    @RequestMapping("/sale/booking")
    public String booking()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "booking from downstream." + id;
    }

    @RequestMapping("/sale/other")
    public String other()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "other from downstream." + id;
    }

    @RequestMapping("/sale/something")
    public String something()
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "something from downstream." + id;
    }

    @RequestMapping("shopping")
    public String shopping1()
    {
        System.out.println("enter");

//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("end");
        return "shopping1 from downstream." + id;
    }

    @RequestMapping("pricing")
    public String pricing1()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "pricing1 from downstream." + id;
    }

    @RequestMapping("booking")
    public String booking1()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "booking1 from downstream." + id;
    }

    @RequestMapping("other")
    public String other1()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "other1 from downstream." + id;
    }

    @RequestMapping("something")
    public String something1()
    {
        return "something1 from downstream." + id;
    }

    @RequestMapping("shopping2")
    public String shopping2()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "shopping2 from downstream." + id;
    }

    @RequestMapping("/test/shopping")
    public String shopping3()
    {

        return "test shopping from downstream." + id;
    }

    @RequestMapping("/enc")
    public String enc()
    {

        String s = stringEncryptor.encrypt("testa");
        String s1 = stringEncryptor.decrypt(s);
        String s2 = stringEncryptor.decrypt("PDSQ5JMHMuHJZW8HYszcTTuO+mxZrNelLPoBEPizz4OHsFAlTPaA3LdqlzIZFpJ4");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s);
        return "this is enc:" + s;
    }
}
