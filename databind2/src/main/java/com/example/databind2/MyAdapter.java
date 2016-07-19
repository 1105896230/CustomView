package com.example.databind2;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databind2.databinding.ItemUserBinding;

import java.util.List;

/**
 * Created by "林其望".
 * DATE: 2016:07:20:1:07
 * email:1105896230@qq.com
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BindingHolder> {

    private List<User> users;
    private final TypedValue mTypedValue = new TypedValue();

    public class BindingHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public ItemUserBinding getBinding() {
            return binding;
        }

        public void setBinding(ItemUserBinding binding) {
            this.binding = binding;
        }
    }

    public MyAdapter(Context context, List<User> users) {
        this.users = users;
    }

    @Override
    public MyAdapter.BindingHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        ItemUserBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_user,
                parent,
                false);
        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        User user = users.get(position);
        holder.binding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
