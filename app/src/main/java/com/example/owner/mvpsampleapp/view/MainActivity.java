package com.example.owner.mvpsampleapp.view;

import android.content.ComponentName;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.owner.mvpsampleapp.R;
import com.example.owner.mvpsampleapp.base.BaseActivity;
import com.example.owner.mvpsampleapp.databinding.ActivityMainBinding;
import com.example.owner.mvpsampleapp.presenter.MainPresenterImpl;

public class MainActivity extends BaseActivity implements MainView{

    private MainPresenterImpl mainPresenter = new MainPresenterImpl();
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.textview.setText("Hi");

        init();
        activityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.updateMessage();
            }
        });
    }

    private void init() {
        mainPresenter.attchView(this);


    }


    @Override
    public void showMessage(String message) {

        ComponentName componentName = new ComponentName("kr.co.kyowon.ktelepathy", "kr.co.kyowon.ktelepathy.IntroActivity");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.putExtra("flag", false);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setComponent(componentName);
        startActivity(intent);
        activityMainBinding.textview.setText(message);
    }
}
