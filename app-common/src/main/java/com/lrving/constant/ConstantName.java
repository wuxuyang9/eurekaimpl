package com.lrving.constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 常量注解
 * Created by wangBaiChuan 2019-01-18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD )
public @interface ConstantName {
	public String value() default "";
}
