package com.bsc.aop;

import com.bsc.annotation.Api;
import com.bsc.base.ApiBaseContext;
import com.bsc.base.MethodContext;
import com.bsc.config.FilterChainBuilder;
import com.bsc.invoker.FilterChain;
import com.bsc.util.MethodContextUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class ApiInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Api annotation = methodInvocation.getMethod().getAnnotation(Api.class);
        if (annotation == null) {
            return methodInvocation.proceed();
        }
        MethodContext methodContext = new MethodContext();
        methodContext.setMethod(methodInvocation.getMethod());
        methodContext.setBean(methodInvocation.getThis());
        MethodContextUtil.setMethodContext(methodContext);
        ApiBaseContext apiBaseContext = new ApiBaseContext();
        apiBaseContext.setAnnotation(annotation);
        apiBaseContext.setParam(methodInvocation.getArguments());
        FilterChain filterChain = FilterChainBuilder.builder();
        return filterChain.invoke(apiBaseContext);
    }

}
