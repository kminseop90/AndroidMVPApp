package com.example.owner.mvpsampleapp.presenter;

import com.example.owner.mvpsampleapp.base.BasePresenter;
import com.example.owner.mvpsampleapp.view.MainView;

/**
 * Created by Owner on 2017-01-31.
 */

public class MainPresenterImpl extends BasePresenter<MainView> {


    public void updateMessage() {
        view().showMessage("Bye");
    }
}
