package com.example.ndkproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by "林其望".
 * DATE: 2016:08:28:21:24
 * email:1105896230@qq.com
 */

public class PrivateBrocast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        setResultCode(200);
        //处理敏感数据
        String param = intent.getStringExtra("param");
        setResultData(param);
        //终止广播不需要继续发送广播
        abortBroadcast();
    }
}
