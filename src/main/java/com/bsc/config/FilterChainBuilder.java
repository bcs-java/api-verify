package com.bsc1.config;

import com.bsc1.base.ApiBaseContext;
import com.bsc1.filter.ApiFilter;
import com.bsc1.invoker.EndInvoker;
import com.bsc1.invoker.FilterChain;
import com.bsc1.invoker.Invoker;

import java.util.ArrayList;
import java.util.List;

public class FilterChainBuilder {

    public static FilterChain builder() {
        List<ApiFilter> allFilter = new ArrayList<>(ApplicationContextHolder.getBeansOfType(ApiFilter.class));
        allFilter.sort((o1, o2) -> Integer.compare(o2.getOrder(), o1.getOrder()));
        Invoker last = new EndInvoker();
        for (ApiFilter apiFilter : allFilter) {
            Invoker next = last;
            last = new Invoker() {
                @Override
                public Object invoke(ApiBaseContext context) {
                    Object o = apiFilter.doFilter(context, next);
                    return apiFilter.doReturn(context, o);
                }
            };
        }
        FilterChain apiBaseContextFilterChain = new FilterChain();
        apiBaseContextFilterChain.setHead(last);
        return apiBaseContextFilterChain;
    }
}
