package com.example.databind2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        RecyclerView view = (RecyclerView) findViewById(R.id.recycleView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setItemAnimator(new DefaultItemAnimator());

        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.name.set("1");
        users.add(user);
        user = new User();
        user.name.set("2");
        users.add(user);
        user = new User();
        user.name.set("3");
        users.add(user);
        user = new User();
        user.name.set("4");
        users.add(user);
        user = new User();
        user.name.set("5");
        users.add(user);
        user = new User();
        user.name.set("6");
        users.add(user);
        user = new User();
        user.name.set("7");
        users.add(user);
        MyAdapter myAdapter = new MyAdapter(this, users);
        view.setAdapter(myAdapter);
    }

}
