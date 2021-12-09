package com.lexue.study.spring.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {

    @Pointcut("execution(public * com.lexue.study.spring.bean.*.*(..))")
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

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知进入");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知退出");
        return proceed;
    }
}
