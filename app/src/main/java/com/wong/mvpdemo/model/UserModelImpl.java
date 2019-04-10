package com.wong.mvpdemo.model;

import android.support.annotation.NonNull;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-10 下午7:08
 * @version 1.0
 */
public class UserModelImpl implements IUser {
    private String userName;
    private String password;

    public UserModelImpl(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean checkLogin(@NonNull String userName, @NonNull String pwd) {
        if(userName.equals(this.userName) && pwd.equals(this.password)){
            return true;
        }
        return false;
    }


}
