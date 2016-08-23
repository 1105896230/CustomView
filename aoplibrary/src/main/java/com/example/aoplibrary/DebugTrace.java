package com.example.aoplibrary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by "林其望".
 * DATE: 2016:08:23:13:06
 * email:1105896230@qq.com
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD })
public @interface DebugTrace {
}
