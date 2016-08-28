package com.example.ndkproject;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by "林其望".
 * DATE: 2016:08:28:22:49
 * email:1105896230@qq.com
 */

public class MyApplication extends Application {
    private static final String SIGATRUE_MD5 = "xxx";

    @Override
    public void onCreate() {
        super.onCreate();
        String signatureMD5 = getSignatureMD5(this);
        if (!signatureMD5.equals(SIGATRUE_MD5)) {
            System.exit(0);
        }
    }

    private String getSignatureMD5(Context context) {
        String backString = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] bytes = packageInfo.signatures[0].toByteArray();
//            backString = DisgUtils.md5(bytes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return backString;
    }

    private boolean isEmualotr(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null && deviceId.equals("000000000000000")) {
                return true;
            }
            return Build.MODEL.equals("sdk") || Build.MODEL.equals("google_sdk");
        } catch (Exception ioe) {

        }
        return false;
    }

    public boolean isCheck(int pid, String pkg) {
        File file = new File("/proc/" + pid + "/maps");
        if (!file.exists()) {
            return false;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String lineString = null;

            while ((lineString = bufferedReader.readLine()) != null) {
                String trim = lineString.trim();
                if (trim.contains("/data/data") && !trim.contains("/data/data/" + pkg)) {
                    return false;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
