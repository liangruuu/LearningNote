package com.paul.spring;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Proxy;

public class ProxyFactory<T> implements FactoryBean<T> {


    private Class<T> interfaceClass;

    private ApplicationContext ctx;


    public ProxyFactory(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }



    @Override
    public T getObject() throws Exception {
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new Handler(interfaceClass));
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }


}
