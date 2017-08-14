package com.example.owner.mvpsampleapp.presenter;

import com.example.owner.mvpsampleapp.R;
import com.example.owner.mvpsampleapp.model.vo.User;

import java.util.ArrayList;

/**
 * Created by Owner on 2017-01-31
 */

public class MainPresenterImpl extends MainPresenter {

    @Override
    public void showMessage() {
        if(isAttachView()) {
            view().showMessage("Bye", R.drawable.icon_empty_state);
        }
    }

    @Override
    public void showUsers() {
        if(isAttachView()) {
            ArrayList<User> users = new ArrayList<>();
            for(int i = 0 ; i < 100; i++) {
                User user = new User(i, "name : " + i, "phone : " +  i);
                users.add(user);
            }
            view().showUsers(users);
        }
    }


}
