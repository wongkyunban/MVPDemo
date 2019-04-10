package com.wong.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.wong.mvpdemo.model.IUser;
import com.wong.mvpdemo.model.UserModelImpl;
import com.wong.mvpdemo.view.ILoginView;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-10 下午7:13
 * @version 1.0
 */
public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView iLoginView;
    private IUser user;
    private Handler handler;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());

    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        final boolean isSuccess = user.checkLogin(name, password);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(isSuccess);
            }
        }, 3000);


    }



    private void initUser() {
        user = new UserModelImpl("wongkyunban", "1688");
    }

}
