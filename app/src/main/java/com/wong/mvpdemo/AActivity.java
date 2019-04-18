package com.wong.mvpdemo;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wong.mvpdemo.presenter.LoginPresenterImpl;
import com.wong.mvpdemo.view.LoginActivity;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectActivityLeaks().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().setClassInstanceLimit(LoginPresenterImpl.class,1).penaltyLog().build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AActivity.this, LoginActivity.class));
            }
        });
    }
}
