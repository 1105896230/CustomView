package com.hotel.sf.databinddemo;

/**
 * Created by linqiwang
 * data：2016/7/18
 * email: 1105896230@qq.com
 */
public class MyStringUtils {
    public static String capitalize(final String word) {
        if (word.length() > 1) {
            return word.toUpperCase();
        }
        return word;
    }
}
