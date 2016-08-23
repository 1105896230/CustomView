package com.example.aoplibrary;

import android.util.Log;

/**
 * Created by "林其望".
 * DATE: 2016:08:23:13:07
 * email:1105896230@qq.com
 */

public class DebugLog {
    private DebugLog() {
    }

    /**
     * Send a debug log message
     *
     * @param tag     Source of a log message.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Log.d(tag, message);
    }
}
