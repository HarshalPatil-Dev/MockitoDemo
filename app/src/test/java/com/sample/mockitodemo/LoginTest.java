package com.sample.mockitodemo;

import com.sample.mockitodemo.Login.Login;
import com.sample.mockitodemo.Login.LoginPresenter;
import com.sample.mockitodemo.Login.LoginPresenterImpl;
import com.sample.mockitodemo.Login.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
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
        assertThat(loginView.getUserName(), is(""));
        assertThat(loginView.getPassword(), is("HarshalPatil"));
    }
    @Test
    public void Empty_PasswordTest(){
        when(loginView.getUserName()).thenReturn("Harshal");
        when(loginView.getPassword()).thenReturn("");
        SUT.onLoginClick();
        assertThat(loginView.getUserName(),is("Harshal"));
        assertThat(loginView.getPassword(),is(""));
    }
    @Test
    public void Success_PasswordTest(){
        when(loginView.getUserName()).thenReturn("Harshal");
        when(loginView.getPassword()).thenReturn("Patil");
        SUT.onLoginClick();
        assertThat(loginView.getUserName(),is("Harshal"));
        assertThat(loginView.getPassword(),is("Patil"));
    }
}
