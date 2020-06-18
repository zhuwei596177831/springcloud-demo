package com.zhuweiwei.eureka.eurekaserver.support;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zww
 * @date 2020-06-18 14:44
 * @description
 */
public class FactoryBeanTest<T> implements FactoryBean<T>, InitializingBean {

    private String myScanClassName;

    public void setMyScanClassName(String myScanClassName) {
        this.myScanClassName = myScanClassName;
    }

    @Override
    public T getObject() throws Exception {
        Class<?> aClass = Class.forName(myScanClassName);
        if (aClass.isInterface()) {
            return (T) InterfaceProxy.newInstance(aClass);
        } else {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(aClass);
            enhancer.setCallback(new MethodInterceptorProxy());
            return (T) enhancer.create();
        }
    }

    @Override
    public Class<?> getObjectType() {
        if (myScanClassName == null) {
            return null;
        }
        try {
            return Class.forName(myScanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
