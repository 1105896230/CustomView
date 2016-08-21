package com.example;

import android.os.Build;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class MyClass {

    public void test() {

        List<String> stc = Arrays.asList("a", "b", "A", "B");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            stc.sort(String::compareToIgnoreCase);
        }
        int a = 100;
        a = (int) 229l;
    }

}
