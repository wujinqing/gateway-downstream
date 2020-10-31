package com.jin.gateway.downstream.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * @author wu.jinqing
 * @date 2020年07月29日
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String name = context.getEnvironment().getProperty("myconditional.name");
        MultiValueMap<String, Object> map =  metadata.getAllAnnotationAttributes(MyConditional.class.getName());

        String n = (String) map.getFirst("name");

        if("zhangsan".equals(name))
        {
            return true;
        }

        return false;
    }
}
