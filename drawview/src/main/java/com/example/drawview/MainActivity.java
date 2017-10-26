package com.example.drawview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.drawview.activity.class1.Class1Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btn1:
               startActivity(new Intent(this, Class1Activity.class));
               break;
       }
    }
}
