package com.example.safedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by "林其望".
 * DATE: 2016:08:27:11:56
 * email:1105896230@qq.com
 */

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            StringBuilder builder = new StringBuilder();
            String send = null;
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                //通过pdus来接送短信内容
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] message = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    message[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                for (SmsMessage message1 : message) {
                    builder.append("短信来自:" + message1.getDisplayOriginatingAddress() + "\n");
                    builder.append("短信内容:" + message1.getMessageBody() + "\n");
                }
            }
            Toast.makeText(context, builder.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
