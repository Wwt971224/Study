package com.lexue.study.spring.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.util.concurrent.Executor;

@Aspect
public class LogAspect {

    @Pointcut("execution(* com.lexue.study.spring.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("方法执行前，参数： " + JSON.toJSONString(args));
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("方法正常返回，返回值： " + result);
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("方法结束");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("方法执行异常，异常：" + exception);
    }

}
