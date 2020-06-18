package com.zhuweiwei.eureka.eurekaserver.support;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zww
 * @date 2020-06-18 15:06
 * @description
 */
public class MethodInterceptorProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("MethodInterceptorProxy:" + method.getName());
        return methodProxy.invoke(o, objects);
    }
}
