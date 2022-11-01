package com.bsc1.base;

import com.bsc1.annotation.Api;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ApiBaseContext {

    private Api annotation;

    private Object[] param;

    public Api getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Api annotation) {
        this.annotation = annotation;
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
    }

}
