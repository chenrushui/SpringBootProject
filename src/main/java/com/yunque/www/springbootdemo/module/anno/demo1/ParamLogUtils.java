package com.yunque.www.springbootdemo.module.anno.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 注解解析工具类，解析指定的注解。
 * 扫描到所有使用注解的地方。
 */

@Component
@Aspect   //切面类，用于扫描所有的注解
public class ParamLogUtils {

    private Logger logger = LoggerFactory.getLogger(ParamLogUtils.class);

    public ParamLogUtils() {
        logger.info("用于加载所有的注解");
    }


    @Pointcut("@annotation(com.yunque.www.springbootdemo.module.anno.demo1.ParamLog)")
    public void paramLogName() {

    }

    @Around("paramLogName()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        for (Object item : args) {
            printLog(item, 0);

        }
        Object object = point.proceed();
        printLog(object, 1);
        return object;
    }

    private void printLog(Object object, int i) {
        String logType = "";
        if (i == 0) {
            logType = "输入参数";
        } else {
            logType = "输出参数";
        }
        if (object == null) {
            logger.info(logType + "为null");
        } else {
            logger.info(logType + object.toString());
        }
    }
}
