package com.example.aopdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.aoplibrary.DebugTrace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testAnnotatedMethod();
    }

    @DebugTrace
    private void testAnnotatedMethod() {
        try {
            Thread.sleep(10);
            Log.e("main","haha");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
