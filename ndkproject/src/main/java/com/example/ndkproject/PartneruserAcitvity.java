package com.example.ndkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PartneruserAcitvity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    //目标Activity的包名
    private static final String TAGGET_PACKAGE = "xxx";
    //目标Activity的类名
    private static final String TAGGET_ACTIVITY = "xxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partneruser_acitvity);
    }

    void click() {
        Intent intent = new Intent();
        intent.putExtra("PARAM", "非敏感数据，公开");
        intent.setClassName(TAGGET_PACKAGE, TAGGET_ACTIVITY);
        startActivityForResult(intent,REQUEST_CODE);
    }
}
