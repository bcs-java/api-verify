package com.bsc.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodContext {

    private Method method;

    private Object bean;

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Object invoke(Object[] arg) {
        if (method == null || bean == null) {
            throw new RuntimeException("method and bean can not null");
        }
        try {
            return method.invoke(bean, arg);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;

    }
}
