package com.doumuxie.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author doumuxie
 * @version 1.0
 * @date 2020/2/10 11:59
 * @description 日志切面
 **/
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.doumuxie.controller.*.*(..))")
    public void controllerLog() {
    }

    @Pointcut("execution(* com.doumuxie.service.impl.*.*(..))")
    public void serviceLog() {
    }


    @Before("controllerLog()")
    public void doControllerBefore(JoinPoint joinPoint) {
        // 获取请求method 及 参数
        logger.info("控制层controller===>方法={},参数={}",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()",
                JSON.toJSON(joinPoint.getArgs()));

    }

    @Before("serviceLog()")
    public void doServiceBefore(JoinPoint joinPoint) {
        // 获取请求method 及 参数
        logger.info("业务层service===>方法={},参数={}",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()",
                JSON.toJSON(joinPoint.getArgs()));

    }
}
