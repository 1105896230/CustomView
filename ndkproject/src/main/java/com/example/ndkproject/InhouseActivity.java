package com.example.ndkproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InhouseActivity extends AppCompatActivity {

    private static final String MY_PERMISSION="com.example.ndkproject.MY_PERSSION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inhouse);
//        if (!MY_PERMISSION.equals(getPermission(this))){
//            finish();
//        }
    }
}
