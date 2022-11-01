package com.bsc.filter;

import com.bsc.base.ApiBaseContext;
import com.bsc.invoker.Invoker;

public class TokenVerifyFilter implements ApiFilter {
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object doFilter(ApiBaseContext context, Invoker invoker) {
        System.out.println("TokenVerifyFilter doFilter");
        return invoker.invoke(context);
    }

    @Override
    public Object doReturn(ApiBaseContext context, Object result) {
        System.out.println("TokenVerifyFilter doReturn");
        return result;
    }
}
