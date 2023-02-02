package com.bee.sample.chl.exercises.annotionexercise;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
//交给spring管理
public class PrintLogAspect {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintLogAspect.class);
 
    @Autowired
    HttpServletRequest request;
    
    //如果aroundMethod需要注入@PrintLog注解，则@annotation的值指向aroundMethod注解参数的形式参数
    //如果不需要注入@PrintLog对象，则@annotation的值为@PrintLog注解的全限定名
    @Around(value = "@annotation(printLog)")
    public Object aroundMethod(ProceedingJoinPoint point, PrintLog printLog) {
        try {
            String ip = request.getRemoteAddr();
            LOGGER.info(String.format("请求ip=%s,请求接口=%s,用户行为=%s", ip, printLog.value(), printLog.handle().getDesc()));
            //执行对象方法
            Object proceed = point.proceed();
            LOGGER.info(String.format("执行结果为=%s", proceed));
            //必须将原来方法的结果返回，除非你需要改变返回结果
            return proceed;
        } catch (Throwable throwable) {
            LOGGER.error("发生异常，异常=" + throwable.getMessage());
        }
        return "1";
    }
}