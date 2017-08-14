package com.example.owner.mvpsampleapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.owner.mvpsampleapp.R;
import com.example.owner.mvpsampleapp.adapter.UserAdapter;
import com.example.owner.mvpsampleapp.base.BaseActivity;
import com.example.owner.mvpsampleapp.databinding.ActivityMainBinding;
import com.example.owner.mvpsampleapp.model.vo.User;
import com.example.owner.mvpsampleapp.presenter.MainPresenter;
import com.example.owner.mvpsampleapp.presenter.MainPresenterImpl;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mainPresenter = new MainPresenterImpl();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainactivity(this);
        init();
    }

    private void init() {
        mainPresenter.attchView(this);
        binding.textview.setText("Hi");

        binding.userList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.userList.setAdapter(new UserAdapter());
        mainPresenter.showUsers();
    }


    @Override
    public void showUsers(ArrayList<User> users) {
        ((UserAdapter) binding.userList.getAdapter()).setUser(users);
    }


    public void onMessageClick(View v) {
        mainPresenter.showMessage();
    }

    @Override
    public void showMessage(String message, int image) {
        binding.textview.setText(message);
        Picasso.with(MainActivity.this).load(image).into(binding.imageview);
    }

    @Override
    protected void onDestroy() {
        mainPresenter.detachView();
        super.onDestroy();
    }
}
