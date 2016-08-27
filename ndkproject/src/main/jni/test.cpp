#include "com_example_ndkproject_NdkJniUtils.h"

// Created by Administrator on 2016/8/27 0027.
//

JNIEXPORT jstring JNICALL Java_com_example_ndkproject_NdkJniUtils_getCLanguageString
  (JNIEnv *env, jobject obj){
    return env->NewStringUTF("Hello from JNI !");
     }