package com.attachee.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private final Page page;

    // Locators
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;


    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.getByPlaceholder("Username");
        this.passwordInput = page.getByPlaceholder("Password");
        this.loginButton   = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }


}
