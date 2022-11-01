package com.bsc1.annotation;

public @interface Api {

    /**
     * 接口名称
     *
     * @return {@link String }
     * @author shenbangchen
     * @date 2022/11/01 10:47
     */
    String apiName() default "";

    /**
     * 入参集合检验字段
     *
     * @return {@link Column[] }
     * @author shenbangchen
     * @date 2022/11/01 10:48
     */
    Column[] columnList() default {};

    /**
     * 令牌
     *
     * @return {@link String }
     * @author shenbangchen
     * @date 2022/11/01 10:49
     */
    String token() default "";

    /**
     * 角色权限
     *
     * @return {@link String }
     * @author shenbangchen
     * @date 2022/11/01 10:49
     */
    String role() default "";
}
