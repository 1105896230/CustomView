package com.example.java8demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ApplePredicate applePredicate=(Apple apple)-> "red".equals(apple.getColor());
        
    }
}
