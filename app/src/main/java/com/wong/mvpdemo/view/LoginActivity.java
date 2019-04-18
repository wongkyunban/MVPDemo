package com.wong.mvpdemo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wong.HomeActivity;
import com.wong.mvpdemo.R;
import com.wong.mvpdemo.presenter.ILoginPresenter;
import com.wong.mvpdemo.presenter.LoginPresenterImpl;
import com.wong.mvpdemo.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find view
        editUser = (EditText) this.findViewById(R.id.et_username);
        editPass = (EditText) this.findViewById(R.id.et_password);
        btnLogin = (Button) this.findViewById(R.id.button);

        btnClear  = (Button) this.findViewById(R.id.clear_button);

        //set listener
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        //init
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String user = editUser.getText().toString().trim();
                String pwd = editPass.getText().toString().trim();
                //判断输入内容不能为空
                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pwd)) {
                    //调用逻辑层的登录
                    loginPresenter.doLogin(user, pwd);
                }
                break;

            case R.id.clear_button:
                loginPresenter.clear();
                break;
        }
    }

    @Override
    public void onClearText() {
        editUser.setText("");
        editPass.setText("");
    }

    @Override
    public void onLoginResult(boolean result) {
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity.class));
        } else{
            Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(loginPresenter != null) {
            loginPresenter.onDestroy();
            loginPresenter = null;
        }
        Log.i("LLLLLLL","Bye Bye");

    }
}
