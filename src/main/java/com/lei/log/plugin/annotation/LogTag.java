package com.lei.log.plugin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zl
 * @date 2020/5/21 10:30
 * @description 使用插件的注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogTag {
    /**
     * 名称
     */
    String name() default "name";

    /**
     * 标题
     */
    String title() default "title";

    /**
     * 类型
     */
    int type() default 0;

}
