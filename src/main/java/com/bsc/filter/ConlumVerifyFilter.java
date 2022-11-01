package com.bsc1.filter;

import com.bsc1.base.ApiBaseContext;
import com.bsc1.invoker.Invoker;

public class ConlumVerifyFilter implements ApiFilter {
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Object doFilter(ApiBaseContext context, Invoker invoker) {
        System.out.println("ConlumVerifyFilter doFilter");
        return invoker.invoke(context);
    }

    @Override
    public Object doReturn(ApiBaseContext context, Object result) {
        System.out.println("ConlumVerifyFilter doReturn");
        return result;
    }
}
