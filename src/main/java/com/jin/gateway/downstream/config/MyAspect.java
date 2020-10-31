package com.jin.gateway.downstream.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Aspect的六个注解：
 *
 * Pointcut.class
 * Around.class
 * Before.class
 * After.class
 * AfterReturning.class
 * AfterThrowing.class
 *
 *
 * org.aspectj.weaver.tools.PointcutPrimitive
 *
 * public static final PointcutPrimitive CALL = new PointcutPrimitive("call",1);
 public static final PointcutPrimitive EXECUTION = new PointcutPrimitive("execution",2);
 public static final PointcutPrimitive GET = new PointcutPrimitive("get",3);
 public static final PointcutPrimitive SET = new PointcutPrimitive("set",4);
 public static final PointcutPrimitive INITIALIZATION = new PointcutPrimitive("initialization",5);
 public static final PointcutPrimitive PRE_INITIALIZATION = new PointcutPrimitive("preinitialization",6);
 public static final PointcutPrimitive STATIC_INITIALIZATION = new PointcutPrimitive("staticinitialization",7);
 public static final PointcutPrimitive HANDLER = new PointcutPrimitive("handler",8);
 public static final PointcutPrimitive ADVICE_EXECUTION = new PointcutPrimitive("adviceexecution",9);
 public static final PointcutPrimitive WITHIN = new PointcutPrimitive("within",10);
 public static final PointcutPrimitive WITHIN_CODE = new PointcutPrimitive("withincode",11);
 public static final PointcutPrimitive CFLOW = new PointcutPrimitive("cflow",12);
 public static final PointcutPrimitive CFLOW_BELOW = new PointcutPrimitive("cflowbelow",13);
 public static final PointcutPrimitive IF = new PointcutPrimitive("if",14);
 public static final PointcutPrimitive THIS = new PointcutPrimitive("this",15);
 public static final PointcutPrimitive TARGET = new PointcutPrimitive("target",16);
 public static final PointcutPrimitive ARGS = new PointcutPrimitive("args",17);
 public static final PointcutPrimitive REFERENCE = new PointcutPrimitive("reference pointcut",18);
 public static final PointcutPrimitive AT_ANNOTATION = new PointcutPrimitive("@annotation",19);
 public static final PointcutPrimitive AT_THIS = new PointcutPrimitive("@this",20);
 public static final PointcutPrimitive AT_TARGET = new PointcutPrimitive("@target",21);
 public static final PointcutPrimitive AT_ARGS = new PointcutPrimitive("@args",22);
 public static final PointcutPrimitive AT_WITHIN = new PointcutPrimitive("@within",23);
 public static final PointcutPrimitive AT_WITHINCODE = new PointcutPrimitive("@withincode",24);
 *
 * @author wu.jinqing
 * @date 2020年09月09日
 */
@Aspect
@Component
public class MyAspect {

    /**
     * execution:
     *
     *  "execution(public com.jin.gateway.downstream.bean.Student com.jin.gateway.downstream.Bootstrap.student(com.jin.gateway.downstream.bean.Student))"
     *
     *  org.aspectj.weaver.patterns.SignaturePattern
     *
     *  modifiers(方法修饰符): public
     *  returnType(方法返回类型): com.jin.gateway.downstream.bean.Student
     *  declaringType(方法完全限定名): com.jin.gateway.downstream.Bootstrap
     *  name(方法名): student
     *  parameterTypes(方法参数类型列表):com.jin.gateway.downstream.bean.Student
     *  throwsPattern(异常):
     *  annotationPattern(注解):
     *
     * execution(modifiers returnType declaringType.name(parameterTypes)throwsPattern)
     *
     * within:
     * within表达式的粒度为类，其参数为全路径的类名（可使用通配符）
     * within(declaring-type-pattern)
     *
     *
     * args:
     * args表达式的作用是匹配指定参数类型和指定参数数量的方法，无论其类路径或者是方法名是什么。这里需要注意的是，args指定的参数必须是全路径的。如下是args表达式的语法：
     * args(param-pattern)
     *
     * @annotation:
     * @annotation的使用方式与@within的相似，表示匹配使用@annotation指定注解标注的方法将会被环绕，其使用语法如下：

     @annotation(annotation-type)
     *
     *
     *
     *
     *
     */
    @Before("execution(public com.jin.gateway.downstream.bean.Student com.jin.gateway.downstream.Bootstrap.student(com.jin.gateway.downstream.bean.Student))")
    public void before()
    {
        System.out.println("be");
    }

    @Before("@annotation(com.jin.gateway.downstream.config.MyAnnotation)")
    public void before2()
    {
        System.out.println("before2");
    }

    @Around("execution(public com.jin.gateway.downstream.bean.Student com.jin.gateway.downstream.Bootstrap.student2(com.jin.gateway.downstream.bean.Student))")
    public Object around(ProceedingJoinPoint pjp)
    {
        MethodInvocationProceedingJoinPoint pjp1 = (MethodInvocationProceedingJoinPoint)pjp;
        System.out.println("Around before");
        Object obj = null;
        try {
            Object[] args = pjp1.getArgs();
           obj =  pjp1.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("Around after");

        return obj;
    }

    @After("execution(public com.jin.gateway.downstream.bean.Student com.jin.gateway.downstream.Bootstrap.student3(com.jin.gateway.downstream.bean.Student))")
    public void After()
    {
        System.out.println("After");
    }
}
