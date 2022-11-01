package com.bsc.invoker;

import com.bsc.base.ApiBaseContext;
import com.bsc.util.MethodContextUtil;

import java.lang.reflect.Method;

/**
 * 最后调用程序
 *
 * @author shenbangchen
 * @date 2022/11/01 14:16
 */
public class EndInvoker implements Invoker {

    @Override
    public Object invoke(ApiBaseContext context) {
        return MethodContextUtil.getMethodContext().invoke(context.getParam());
    }


}
