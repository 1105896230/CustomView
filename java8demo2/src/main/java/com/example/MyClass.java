package com.example;

import android.os.Build;

import java.util.Arrays;
import java.util.List;

public class MyClass {

    public void test() {

        List<String> stc = Arrays.asList("a", "b", "A", "B");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            stc.sort(String::compareToIgnoreCase);
        }
    }

}
