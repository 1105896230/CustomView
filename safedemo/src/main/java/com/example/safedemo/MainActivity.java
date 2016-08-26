package com.example.safedemo;

import android.content.pm.IPackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", new Root().isDeviceRooted() + "");
    }


    public void sendMessage(View view) {
        String message = "你好";
// 移动运营商允许每次发送的字节数据有限，我们可以使用Android给我们提供 的短信工具。
        if (message != null) {
            SmsManager sms = SmsManager.getDefault();
// 如果短信没有超过限制长度，则返回一个长度的List。
            List<String> texts = sms.divideMessage(message);
            for (String text : texts) {
                sms.sendTextMessage("5558", "5556", "哈哈", null, null);
            }
        }
    }

    public void install(View view) {
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        File file = new File("/storage/emulated/0/Android/data/com.example.safedemo/cache/app-release.apk");
//        intent.setDataAndType(Uri.fromFile(file),
//                "application/vnd.android.package-archive");
//        startActivity(intent);
        test();
    }

    private void test() {
        File apkFile = new File("/storage/emulated/0/Android/data/com.example.safedemo/cache/app-release.apk");

        try {
            Class<?> clazz = Class.forName("android.os.ServiceManager");
            Method method_getService = clazz.getMethod("getService",
                    String.class);
            IBinder bind = (IBinder) method_getService.invoke(null, "package");

            IPackageManager iPm = IPackageManager.Stub.asInterface(bind);
            iPm.installPackage(Uri.fromFile(apkFile), null, 2,
                    apkFile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        execCommand("system/bin/android.content.pm install -r " + "/storage/emulated/0/Android/data/com.example.safedemo/cache/app-release.apk");
    }

    public boolean execCommand(String cmd) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            return false;
        } finally {
            try {
                process.destroy();
            } catch (Exception e) {
            }
        }
        return true;
    }
}
