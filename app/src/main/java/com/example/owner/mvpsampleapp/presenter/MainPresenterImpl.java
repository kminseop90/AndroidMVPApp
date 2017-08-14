package com.example.owner.mvpsampleapp.presenter;

import com.example.owner.mvpsampleapp.R;
import com.example.owner.mvpsampleapp.model.UserModel;
import com.example.owner.mvpsampleapp.model.UserModelImpl;
import com.example.owner.mvpsampleapp.view.MainActivity;

public class MainPresenterImpl extends MainPresenter {

    UserModel userModel;

    @Override
    public void showMessage() {
        if(isAttachView()) {
            view().showMessage("Bye", R.drawable.icon_empty_state);
        }
    }

    @Override
    public void showUsers() {
        if(isAttachView()) {
            view().showUsers(userModel.getUsers());
        }
    }

    @Override
    public void showPopup() {
        if(isAttachView()) {
            view().onNetworkError();
        }
    }

    @Override
    public void addUser() {
        if(isAttachView()) {
            userModel.addUser();
            view().showUsers(userModel.getUsers());
        }
    }


    @Override
    public void afterAttachView() {
        userModel = new UserModelImpl(((MainActivity)view()));
    }
}
