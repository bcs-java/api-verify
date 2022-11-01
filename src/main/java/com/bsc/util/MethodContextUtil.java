package com.bsc.util;

import com.bsc.base.MethodContext;

/**
 * 方法上下文跑龙套
 *
 * @author shenbangchen
 * @date 2022/11/01 16:41
 */
public class MethodContextUtil {

    private static ThreadLocal<MethodContext> tl = new ThreadLocal<>();

    /**
     * 设置方法上下文
     *
     * @param context 上下文
     * @author shenbangchen
     * @date 2022/11/01 16:41
     */
    public static void setMethodContext(MethodContext context) {
        tl.remove();
        tl.set(context);
    }

    /**
     * get方法上下文,只能获取一次
     *
     * @return {@link MethodContext }
     * @author shenbangchen
     * @date 2022/11/01 16:41
     */
    public static MethodContext getMethodContext() {
        MethodContext methodContext = tl.get();
        tl.remove();
        return methodContext;
    }
}
