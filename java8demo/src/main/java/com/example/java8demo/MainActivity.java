package com.example.java8demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplePredicate applePredicate = (Apple apple) -> "red".equals(apple.getColor());


//        ()->42
//        (Apple e)->e.getWeight()>50
//        (String s)->s.length()
//        (int x, int y) -> {
//            Log.e("test", x + "");
//            Log.e("test", y + "");
//        }
    }
}
