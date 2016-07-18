package com.hotel.sf.databinddemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hotel.sf.databinddemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static User user;
    private ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User("xiaoming", "xiaohong");
        viewDataBinding.setUser(user);
    }

    public void changeName(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
