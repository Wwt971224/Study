package com.lexue.study.spring.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspectV2 {

    @Pointcut("execution(* com.lexue.study.spring.*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void beforeV2(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("V2方法执行前，参数： " + JSON.toJSONString(args));
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningV2(JoinPoint joinPoint, Object result) {
        System.out.println("V2方法正常返回，返回值： " + result);
    }

    @After("pointCut()")
    public void afterV2(JoinPoint joinPoint) {
        System.out.println("V2方法结束");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowingV2(JoinPoint joinPoint, Exception exception) {
        System.out.println("V2方法执行异常，异常：" + exception);
    }
}
