package com.jin.gateway.downstream;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author wu.jinqing
 * @date 2020年09月04日
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.setResultCode("ETMF001");
        p.setResultMsg("测试");

        PersonCode.class.isAssignableFrom(p.getClass());
        PropertyDescriptor resultCode = new PropertyDescriptor("resultCode", PersonCode.class);

        Method resultCodeReadMethod = resultCode.getReadMethod();

        String rc = (String) resultCodeReadMethod.invoke(p, null);

        System.out.println(rc);

        PropertyDescriptor resultMsg = new PropertyDescriptor("resultMsg", PersonCode.class);

        Method resultCodeWriteMethod = resultMsg.getWriteMethod();

        Object o = resultCodeWriteMethod.invoke(p, "test");

        System.out.println(o);




        System.out.println(p.getResultMsg());

    }
}
