package com.bsc.base;

import com.bsc.annotation.Api;

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
