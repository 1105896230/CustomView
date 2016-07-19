package com.example.databind2;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.databind2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User user;
    private ActivityMainBinding viewDataBinding;

    private Button findview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User();
        user.name.set("小明");
        viewDataBinding.setUser(user);
        findview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"找到了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void change(View view) {
        user.name.set("小红");
        user.name.get();
    }
}
