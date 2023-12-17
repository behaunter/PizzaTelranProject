package com.telran.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    public Locator usernameInput;
    public Locator passwordInput;
    public Locator loginError;
    public Locator loginBtn;
    public Locator logoutBtn;
    public Locator loginTitle;
    public LoginPage(Page page) {
        super(page);
        this.usernameInput = page.locator("#username");
        this.passwordInput = page.locator("#password");
        this.loginError = page.locator("xpath=//div[@class='login_error']");
        this.loginBtn = page.locator("#login_button");
        this.logoutBtn = page.locator("#logout_button");
        this.loginTitle = page.locator("xpath=//div[@class='login_title']");

    }

    public LoginPage logInAccount (String username,String password){
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginBtn.click();
        return this;
    }

    public LoginPage logOutAccount(){
        logoutBtn.click();
        return this;
    }



}
