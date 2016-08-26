package com.example.safedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", new Root().isDeviceRooted() + "");
    }


    public void sendMessage(View view) {
        String message = "你好";
// 移动运营商允许每次发送的字节数据有限，我们可以使用Android给我们提供 的短信工具。
        if (message != null) {
            SmsManager sms = SmsManager.getDefault();
// 如果短信没有超过限制长度，则返回一个长度的List。
            List<String> texts = sms.divideMessage(message);
            for (String text : texts) {
                sms.sendTextMessage("5558", "5556", "哈哈", null, null);
            }
        }
    }
}
