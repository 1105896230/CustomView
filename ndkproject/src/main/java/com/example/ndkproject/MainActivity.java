package com.example.ndkproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) this.findViewById(R.id.tv);

        switch (0) {
            case 1001:
                JSONObject jsonObject = null;
                String date = null;
                boolean isClose = false;
                try {
                    jsonObject = new JSONObject("");
                    date = jsonObject.getString("date");
                    isClose = jsonObject.getBoolean("isClose");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TT.set(null, "", date);
                break;
        }
        NdkJniUtils jni = new NdkJniUtils();

        mTextView.setText(jni.getCLanguageString());
    }

    static class TT {
        public static void set(Context context, String key, String value) {

        }
    }
}
