package com.wong.mvpdemo.model;

import android.support.annotation.NonNull;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-10 下午7:07
 * @version 1.0
 */
public interface IUser {
     String getUserName();
     String getPassword();
     //登录
     boolean checkLogin(@NonNull String userName, @NonNull String pwd);
}
