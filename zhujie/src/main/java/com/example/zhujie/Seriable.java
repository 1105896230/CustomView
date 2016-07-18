package com.example.zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 林其望
 * data：2016/7/9
 * email: 1105896230@qq.com
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Seriable {}
