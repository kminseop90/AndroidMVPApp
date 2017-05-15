package com.example.owner.mvpsampleapp.base;

/**
 * Created by Owner on 2017-01-31.
 */

public class BasePresenter<VIEW extends BaseView> {

    private VIEW view;

    public void attchView(VIEW view) {
        this.view = view;
    }

    public void detachView() {
        view = null;

    }
    public VIEW view() {
        return view;
    }

}
