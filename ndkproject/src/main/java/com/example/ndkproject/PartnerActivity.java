package com.example.ndkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PartnerActivity extends AppCompatActivity {

    //伙伴应用的签名
    private static final String PARTNER_SINGATURE = "xxxx";
    //伙伴应用的包名
    private static final String PARTENR_PKG_NAME = "xxxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

    }

    private boolean check(Intent intent) {
//        String aPackage = intent.getPackage();
//        if (!aPackage.equals(PARTENR_PKG_NAME)) {
//            return false;
//        }
//        if (!getSingature(aPackage).equal(PARTNER_SINGATURE)) {
//            return false;
//        }
        return true;
    }
}
