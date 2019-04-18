package com.wong.mvpdemo.presenter;



import com.wong.mvpdemo.model.IUser;
import com.wong.mvpdemo.model.UserModelImpl;
import com.wong.mvpdemo.view.ILoginView;

import java.lang.ref.WeakReference;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-10 下午7:13
 * @version 1.0
 */
public class LoginPresenterImpl implements ILoginPresenter {

    /***
     * 强烈建议不要在presenter中使用Handler
     */

    private IUser user;
    /**
     * 弱引用，可以解决activity内存泄漏问题
     */
    private WeakReference<ILoginView> iLoginView;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = new WeakReference<>(iLoginView);
        initUser();

    }

    @Override
    public void clear() {
        iLoginView.get().onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        final boolean isSuccess = user.checkLogin(name, password);


        iLoginView.get().onLoginResult(isSuccess);
    }

    @Override
    public void onDestroy() {
        user = null;
        iLoginView.clear();

    }


    private void initUser() {
        user = new UserModelImpl("test", "1688");
    }


}
