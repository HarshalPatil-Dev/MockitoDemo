package com.sample.mockitodemo.Login;

import com.sample.mockitodemo.R;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void onLoginClick() {

        if(loginView.getUserName().isEmpty()){
            loginView.showMessage(R.string.error_empty_username);
        }
        if(loginView.getPassword().isEmpty()){
            loginView.showMessage(R.string.error_empty_password);
        }
        if(!loginView.getUserName().isEmpty() && !loginView.getPassword().isEmpty()){
            loginView.showMessage(R.string.success_login);
        }

    }
}
