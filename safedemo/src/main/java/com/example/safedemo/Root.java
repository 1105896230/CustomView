package com.example.safedemo;

import android.util.Log;

import java.io.File;

/**
 * Created by "林其望".
 * DATE: 2016:08:26:22:29
 * email:1105896230@qq.com
 */

public class Root {

    private static String LOG_TAG = Root.class.getName();

    public boolean isDeviceRooted() {
        boolean bool = false;

        try{
            if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists())){
                bool = false;
            } else {
                bool = true;
            }
            Log.d(LOG_TAG, "bool = " + bool);
        } catch (Exception e) {

        }
        return bool;
    }

    public boolean checkRootMethod1() {
        String buildTags = android.os.Build.TAGS;

        if (buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }
        return false;
    }

    public boolean checkRootMethod2() {
        try {
            File file = new File("/system/app/Superuser.apk");
            if (file.exists()) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean checkRootMethod3() {
        if (new ExecShell().executeCommand(ExecShell.SHELL_CMD.check_su_binary) != null) {
            return true;
        } else {
            return false;
        }
    }
}
