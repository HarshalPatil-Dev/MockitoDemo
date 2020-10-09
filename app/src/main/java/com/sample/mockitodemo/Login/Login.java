package com.sample.mockitodemo.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sample.mockitodemo.BaseActivity;
import com.sample.mockitodemo.R;

public class Login extends BaseActivity implements LoginView {

    private LoginPresenter mPresenter;
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        mPresenter = new LoginPresenterImpl(this);
        edtUsername = findViewById(R.id.userName);
        edtPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onLoginClick();
            }
        });
    }

    @Override
    public String getUserName() {
        return edtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }

    @Override
    public void showMessage(int resid) {
        Toast.makeText(this,getString(resid),Toast.LENGTH_SHORT).show();
    }



}