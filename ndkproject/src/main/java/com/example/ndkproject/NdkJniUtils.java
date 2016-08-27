package com.example.ndkproject;

/**
 * Created by "林其望".
 * DATE: 2016:08:27:14:55
 * email:1105896230@qq.com
 */

public class NdkJniUtils {
    static {
        System.loadLibrary("NdkJniUtils");
    }
    public native String getCLanguageString();
}
