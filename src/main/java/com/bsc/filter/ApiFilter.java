package com.bsc.filter;

import com.bsc.base.ApiBaseContext;
import com.bsc.invoker.Invoker;

/**
 * 抽象接口过滤器
 *
 * @author shenbangchen
 * @date 2022/11/01 11:17
 */
public interface ApiFilter {

    /**
     * 执行顺序
     *
     * @return int
     * @author shenbangchen
     * @date 2022/11/01 16:32
     */
    int getOrder();

    /**
     * 过滤器
     *
     * @param context 上下文
     * @param invoker 调用程序
     * @return {@link Object }
     * @author shenbangchen
     * @date 2022/11/01 16:32
     */
    default Object doFilter(ApiBaseContext context, Invoker invoker) {
        return invoker.invoke(context);
    }

    /**
     * 返回过滤
     *
     * @param context 上下文
     * @param result  结果
     * @return {@link Object }
     * @author shenbangchen
     * @date 2022/11/01 16:32
     */
    default Object doReturn(ApiBaseContext context, Object result) {
        return result;
    }
}
