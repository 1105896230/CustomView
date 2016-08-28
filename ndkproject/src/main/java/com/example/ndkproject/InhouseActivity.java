package com.example.ndkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class InhouseActivity extends AppCompatActivity {

    private static final String MY_PERMISSION = "com.example.ndkproject.MY_PERSSION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inhouse);
//        if (!MY_PERMISSION.equals(getPermission(this))){
//            finish();
//        }
//        LocalBroadcastManager.getInstance(this).sendBrocast();//发送异步广播
//        LocalBroadcastManager.getInstance(this).sendBrocastSync();//发送同步广播
//        LocalBroadcastManager.getInstance(this).registerReceiver();//注册广播
//        LocalBroadcastManager.getInstance(this).unregisterReceiver();//注销广播
    }

    private void senNormalBrocast() {
        Intent intent = new Intent(this, PrivateBrocast.class);
        intent.putExtra("param", "xxx");
        sendBroadcast(intent);
    }

    private void senOrderBrocast() {
        Intent intent = new Intent(this, PrivateBrocast.class);
        intent.putExtra("param", "xxx");
//        senOrderBrocast(intent, null, mRerever, null, 0, null);
    }


    PrivateBrocast mRerever;
}
