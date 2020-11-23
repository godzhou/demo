package com.example.demo.chain;

import java.lang.annotation.*;

/**
 * 链节点注册器
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ChainRegister {

    //命名空间
    String namespace() default "DEFAULT";

    //名称
    String name() default "VOID";

    //顺序
    int order() default 0;
}
