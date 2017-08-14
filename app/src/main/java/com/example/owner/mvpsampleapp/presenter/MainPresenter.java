package com.example.owner.mvpsampleapp.presenter;

import com.example.owner.mvpsampleapp.base.BasePresenter;
import com.example.owner.mvpsampleapp.view.MainView;

/**
 * Created by Owner on 08-11.
 */

public abstract class MainPresenter extends BasePresenter<MainView> {
    public abstract void showMessage();
    public abstract void showUsers();


}
