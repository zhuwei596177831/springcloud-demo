package com.zhuweiwei.eureka.eurekaserver.support;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zww
 * @date 2020-06-18 14:59
 * @description
 */
public class InterfaceProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InterfaceProxy execute:" + method.getName());
        return method.invoke(proxy, args);
    }

    public static <T> T newInstance(Class<T> innerClassName) {
        ClassLoader classLoader = innerClassName.getClassLoader();
        Class[] interfaces = new Class[]{innerClassName};
        return (T) Proxy.newProxyInstance(classLoader, interfaces, new InterfaceProxy());
    }
}
