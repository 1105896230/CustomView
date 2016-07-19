package com.example.databind2;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by "林其望".
 * DATE: 2016:07:20:0:29
 * email:1105896230@qq.com
 */

public class User extends BaseObservable {
    public final ObservableField<String> name =
            new ObservableField<>();
}
