package com.wong.mvpdemo.presenter;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-10 下午7:03
 * @version 1.0
 */
public interface ILoginPresenter {

    //清空
    void clear();
    //登录
    void doLogin(String name, String password);
}