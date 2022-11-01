package com.bsc1.invoker;

import com.bsc1.base.ApiBaseContext;

import java.lang.reflect.Method;

public class FilterChain {

    private Invoker head;


    public Object invoke(ApiBaseContext context) {
        return head.invoke(context);
    }

    public void setHead(Invoker head) {
        this.head = head;
    }
}
