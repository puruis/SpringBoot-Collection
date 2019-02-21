package com.aop.conf;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: purui_zhang
 * Date: 2019-02-20
 * Time: 17:55
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    /**
     *  切点
     */
    @Pointcut("execution(* com.aop.controller.*.*())")
    public void aspect(){}

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        String method = request.getMethod();
        log.info("{}", "前置增强");
        log.info("{}",requestURL.toString());
        log.info("{}",method);
    }

    @AfterReturning(returning = "ret",pointcut="aspect()")
    public void doAfterReturning(Object ret){
        // ret 最终返回的结果
        log.info("{}", "doAfterReturning..."+ret);
    }

    /**
     * 后置异常增强
     * @param joinPoint
     */
    @AfterThrowing(pointcut = "aspect()")
    public void throwsException(JoinPoint joinPoint){
        log.info("{}","出现异常");
    }

    /**
     * 环绕增强
     */
    @Around("aspect()")
    public Object around(ProceedingJoinPoint pjp){
        try {
            log.info("{}","环绕增强-前");
            //当使用环绕通知时，这个方法必须调用，否则拦截到的方法就不会再执行了
            Object proceed = pjp.proceed();
            log.info("{}","环绕增强-后");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        log.info("{}","后置增强");
    }

}
