package com.example.owner.mvpsampleapp.view;

import com.example.owner.mvpsampleapp.base.BaseView;
import com.example.owner.mvpsampleapp.model.vo.User;

import java.util.ArrayList;

/**
 * Created by Owner on 2017-01-31.
 */

public interface MainView extends BaseView {

    void showMessage(String message, int image);
    void showUsers(ArrayList<User> users);
}
