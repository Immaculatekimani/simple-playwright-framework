package com.attachee.tests;

import com.attachee.pages.AccessMaintainersPages;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.attachee.base.Base;
import com.attachee.pages.LoginPage;

public class LoginTest extends Base{
     @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


}
