package com.bsc1.aop;

import com.bsc1.annotation.Api;
import com.bsc1.base.ApiBaseContext;
import com.bsc1.base.MethodContext;
import com.bsc1.config.FilterChainBuilder;
import com.bsc1.invoker.FilterChain;
import com.bsc1.util.MethodContextUtil;
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
        Method method = methodInvocation.getMethod();
        Object bean = methodInvocation.getThis();
        return filterChain.invoke(apiBaseContext);
    }

    public String text() {
        return "1111";
    }

    public static void main(String[] args) throws NoSuchMethodException {
        ApiInterceptor apiInterceptor = new ApiInterceptor();
        Method text = ApiInterceptor.class.getMethod("text");
        MethodContext methodContext = new MethodContext();
        methodContext.setBean(apiInterceptor);
        methodContext.setMethod(text);
        MethodContextUtil.setMethodContext(methodContext);
        FilterChain builder = FilterChainBuilder.builder();
        ApiBaseContext apiBaseContext = new ApiBaseContext();
        Object invoke = builder.invoke(apiBaseContext);
        System.out.println(invoke);
    }
}
