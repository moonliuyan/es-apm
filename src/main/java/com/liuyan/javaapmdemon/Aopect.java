package com.liuyan.javaapmdemon;

import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Span;
import com.liuyan.javaapmdemon.annotation.Esspan;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class Aopect {
    @Pointcut("execution(* com.liuyan.javaapmdemon..*.* (..))")
    public void ApmAspect(){

    }

    /**
     * @description  使用环绕通知
     */
    @Around("ApmAspect()")
    public Object  doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        try {
            //获取 method 操作方法  action 操作名称
            //首先获取ProceedingJoinPoint 签名  (方法有签名   方法名称 返回值类型 参数类型 及 参数个数)
            Signature signature = pjp.getSignature();
            Object[] args = pjp.getArgs();
            if (signature instanceof MethodSignature) {  //判断当前签名是不是方法签名
                MethodSignature methodSignature = (MethodSignature) signature; //如果是的话 就进行转换成方法签名
                Method method = methodSignature.getMethod();//获取方法
                if (method.isAnnotationPresent(Esspan.class)) {//判断当前方法是否被RequestMapping注解了 只有注解 才能获取的 方法
                    Esspan annotation = method.getAnnotation(Esspan.class);
                    String value = annotation.value();
                    Span parent = ElasticApm.currentSpan();
                    Span span=parent.startSpan();
                    try {
                        span.setName(method.getDeclaringClass().getName()+"#"+method.getName());
                        return pjp.proceed(args);
                    } catch (Exception e) {
                        span.captureException(e);
                        throw new RuntimeException(e);
                    } finally {
                        span.end();
                    }
                }
            }
            return pjp.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
