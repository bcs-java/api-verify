package com.bsc1.annotation;

public @interface Column {

    /**
     * 参数名称
     *
     * @return {@link String }
     * @author shenbangchen
     * @date 2022/11/01 11:11
     */
    String name() default "";

    /**
     * 入参匹配正则
     *
     * @return {@link String }
     * @author shenbangchen
     * @date 2022/11/01 11:14
     */
    String grep() default "";

    /**
     * 是否必填项
     *
     * @return boolean
     * @author shenbangchen
     * @date 2022/11/01 11:16
     */
    boolean required() default false;

}
