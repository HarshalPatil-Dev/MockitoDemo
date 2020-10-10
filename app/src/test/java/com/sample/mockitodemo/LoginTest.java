package com.sample.mockitodemo;

import com.sample.mockitodemo.Login.LoginPresenter;
import com.sample.mockitodemo.Login.LoginPresenterImpl;
import com.sample.mockitodemo.Login.LoginView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
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
        ArgumentCaptor<Integer> ac = ArgumentCaptor.forClass(Integer.class);
        when(loginView.getUserName()).thenReturn("");
        when(loginView.getPassword()).thenReturn("HarshalPatil");
        SUT.onLoginClick();
        verify(loginView,times(1)).showMessage(ac.capture());
        Assert.assertThat(ac.getValue(),is(R.string.error_empty_username));

    }
    @Test
    public void Empty_PasswordTest(){
        ArgumentCaptor<Integer> ac = ArgumentCaptor.forClass(Integer.class);
        when(loginView.getUserName()).thenReturn("Harshal");
        when(loginView.getPassword()).thenReturn("");
        SUT.onLoginClick();
        verify(loginView,times(1)).showMessage(ac.capture());
        Assert.assertThat(ac.getValue(),is(R.string.error_empty_password));
    }
    @Test
    public void Success_PasswordTest(){
        ArgumentCaptor<Integer> ac = ArgumentCaptor.forClass(Integer.class);
        when(loginView.getUserName()).thenReturn("Harshal");
        when(loginView.getPassword()).thenReturn("Patil");
        SUT.onLoginClick();
        verify(loginView,times(1)).showMessage(ac.capture());
        Assert.assertThat(ac.getValue(),is(R.string.success_login));

    }
}
