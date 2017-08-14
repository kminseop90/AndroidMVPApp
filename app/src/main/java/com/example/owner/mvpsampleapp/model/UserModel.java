package com.example.owner.mvpsampleapp.model;

import com.example.owner.mvpsampleapp.model.vo.User;

import java.util.ArrayList;

/**
 * Created by Owner on 08-14.
 */

public interface UserModel {

    void addUser();
    ArrayList<User> getUsers();
}
