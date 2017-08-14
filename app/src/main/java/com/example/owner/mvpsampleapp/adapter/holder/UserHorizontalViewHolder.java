package com.example.owner.mvpsampleapp.adapter.holder;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.owner.mvpsampleapp.R;
import com.example.owner.mvpsampleapp.databinding.UserHorizontalViewBinding;
import com.example.owner.mvpsampleapp.model.vo.User;

public class UserHorizontalViewHolder extends BaseViewHolder<User> {

    UserHorizontalViewBinding binding;

    public static UserHorizontalViewHolder newInstance(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_horizontal_view, parent, false);
        return new UserHorizontalViewHolder(itemView);
    }

    public UserHorizontalViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
        binding.setHorizontalview(this);
    }

    @Override
    public void onBindView(User user) {
        binding.id.setText(String.valueOf(user.getId()));
        binding.name.setText(user.getName());
        binding.phone.setText(user.getPhone());
    }
}