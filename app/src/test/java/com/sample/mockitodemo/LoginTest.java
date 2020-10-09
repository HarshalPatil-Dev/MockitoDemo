package com.sample.mockitodemo;

import com.sample.mockitodemo.Login.LoginPresenter;
import com.sample.mockitodemo.Login.LoginPresenterImpl;
import com.sample.mockitodemo.Login.LoginView;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginTest {

    LoginView loginView;
    LoginPresenter SUT;

    @Before
    public void setup() throws Exception{
        loginView = mock(LoginView.class);
        SUT = new LoginPresenterImpl(loginView);
    }

    @Test
    public void Empty_UserNameTest(){
        when(loginView.getUserName()).thenReturn("");
        when(loginView.getPassword()).thenReturn("HarshalPatil");
        SUT.onLoginClick();
        verify(loginView).showMessage(R.string.error_empty_username);

    }
    @Test
    public void Empty_PasswordTest(){
        when(loginView.getUserName()).thenReturn("Harshal");
        when(loginView.getPassword()).thenReturn("");
        SUT.onLoginClick();
        verify(loginView).showMessage(R.string.error_empty_password);
    }
    @Test
    public void Success_PasswordTest(){
        when(loginView.getUserName()).thenReturn("Harshal");
        when(loginView.getPassword()).thenReturn("Patil");
        SUT.onLoginClick();
        verify(loginView).showMessage(R.string.success_login);

    }
}
