package com.wong.mvpdemo.view;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-10 下午7:05
 * @version 1.0
 */
public interface ILoginView {
     //回调清空
     void onClearText();
     //登录结果回调
     void onLoginResult(boolean result);
}
