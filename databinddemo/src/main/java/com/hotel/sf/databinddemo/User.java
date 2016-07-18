package com.hotel.sf.databinddemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by linqiwang
 * data：2016/7/18
 * email: 1105896230@qq.com
 */
public class User extends BaseObservable implements Parcelable{
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected User(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
    }
}
