package com.example.safedemo;

import android.content.Context;
import android.content.pm.IPackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
//        File file = new File(Environment.getExternalStorageDirectory()+"/app-release.apk");
//        intent.setDataAndType(Uri.fromFile(file),
//                "application/vnd.android.package-archive");
//        startActivity(intent);
        test();
//        install(Environment.getExternalStorageDirectory() + "/app-release.apk");

//        execCommand("system/bin/pm install -r  " + Environment.getExternalStorageDirectory() + "/app-release.apk");

    }


    private void test() {
        File apkFile = new File(Environment.getExternalStorageDirectory() + "/app-release.apk");

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


    public boolean install(String apkPath) {
        boolean result = false;
        DataOutputStream dataOutputStream = null;
        BufferedReader errorStream = null;
        try {
            // 申请su权限
            Process process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());
            // 执行pm install命令
            String command = "pm install -r " + apkPath + "\n";
            dataOutputStream.write(command.getBytes(Charset.forName("utf-8")));
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
            errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String msg = "";
            String line;
            // 读取命令的执行结果
            while ((line = errorStream.readLine()) != null) {
                msg += line;
            }
            Log.d("TAG", "install msg is " + msg);
            // 如果执行结果中包含Failure字样就认为是安装失败，否则就认为安装成功
            if (!msg.contains("Failure")) {
                result = true;
            }
        } catch (Exception e) {
            Log.e("TAG", e.getMessage(), e);
        } finally {
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (IOException e) {
                Log.e("TAG", e.getMessage(), e);
            }
        }
        return result;
    }

    public void telephone(View view) {
        String number = "5556go";
        Class<TelephonyManager> c = TelephonyManager.class;
        Method getITelephonyMethod = null;
        try {
// setAccessible(true) 跳过java中的private方法的反射权限检查
// 及我们能够在外部调用private方法而不报错
            getITelephonyMethod = c.getDeclaredMethod("getITelephony", (Class[]) null);
            getITelephonyMethod.setAccessible(true);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            TelephonyManager tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            Object iTelephony;
            iTelephony = (Object) getITelephonyMethod.invoke(tManager, (Object[]) null);
// 反射 call方法
            Method dial = iTelephony.getClass().getDeclaredMethod("call", String.class);
            dial.invoke(iTelephony, number);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void hone(View view) {
        TelephonyManager telephoneyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        telephoneyManager.listen(new MyPhoneCallListener(), PhoneStateListener.LISTEN_CALL_STATE);
    }

    public class MyPhoneCallListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                // 电话通话的状态
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.e("test","CALL_STATE_OFFHOOK");
                    break;
                // 电话响铃的状态
                case TelephonyManager.CALL_STATE_RINGING:
                    Log.e("test","CALL_STATE_RINGING");

                    break;
                // 空闲中
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.e("test","CALL_STATE_IDLE");

                    break;
            }
            super.onCallStateChanged(state, incomingNumber);
        }
    }
}
