package com.example.owner.mvpsampleapp.adapter.holder;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.owner.mvpsampleapp.R;
import com.example.owner.mvpsampleapp.databinding.UserVerticalViewBinding;
import com.example.owner.mvpsampleapp.model.vo.User;

public class UserVerticalViewHolder extends BaseViewHolder<User> {

    UserVerticalViewBinding binding;

    public static UserVerticalViewHolder newInstance(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_vertical_view, parent, false);
        return new UserVerticalViewHolder(itemView);
    }

    public UserVerticalViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
        binding.setVerticalview(this);
    }

    @Override
    public void onBindView(User user) {
        binding.id.setText(String.valueOf(user.getId()));
        binding.name.setText(user.getName());
        binding.phone.setText(user.getPhone());
    }
}
