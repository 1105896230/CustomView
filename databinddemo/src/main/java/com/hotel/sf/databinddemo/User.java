package com.hotel.sf.databinddemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by linqiwang
 * data：2016/7/18
 * email: 1105896230@qq.com
 */
public class User extends BaseObservable {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(com.hotel.sf.databinddemo.BR.firstName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
