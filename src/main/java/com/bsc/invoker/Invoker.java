package com.bsc.invoker;

import com.bsc.base.ApiBaseContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Invoker related
 *
 * @author shenbangchen
 * @date 2022/11/01 11:38
 */
public interface Invoker {

    /**
     * invoke
     *
     * @param context 上下文
     * @author shenbangchen
     * @date 2022/11/01 11:37
     */
    default Object invoke(ApiBaseContext context) {
        return null;
    }
}
