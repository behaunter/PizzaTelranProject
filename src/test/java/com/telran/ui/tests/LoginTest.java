package com.telran.ui.tests;

import com.telran.ui.pages.HomePage;
import com.telran.ui.pages.LoginPage;
import testdata.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class LoginTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void prepare() {
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        loginPage.goToLoginPage();
    }

    @Test
    public void successLogin() {
        loginPage.logInAccount(Constants.CORRECT_USERNAME,Constants.CORRECT_PASSWORD);
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
        loginPage.goToLoginPage();
        assertTrue(loginPage.loginTitle.innerText().contains(Constants.CORRECT_USERNAME));
    }

    @Test
    public void successLogout(){
        loginPage.logInAccount(Constants.CORRECT_USERNAME,Constants.CORRECT_PASSWORD);
        loginPage.goToLoginPage();
        assertTrue(loginPage.loginTitle.innerText().contains(Constants.CORRECT_USERNAME));
        loginPage.logOutAccount();
        loginPage.goToLoginPage();
        assertTrue(loginPage.loginTitle.innerText().contains(Constants.ANONYMOUS_USERNAME));
    }

    @Test
    public void LoginWithAdminCreds(){
        loginPage.logInAccount(Constants.ADMIN_USERNAME,Constants.CORRECT_PASSWORD);
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
        loginPage.goToLoginPage();
        assertTrue(loginPage.loginTitle.innerText().contains(Constants.ADMIN_USERNAME));
    }
    @Test
    public void incorrectLogin(){
        loginPage.logInAccount(Constants.INCORRECT_USERNAME,Constants.INCORRECT_PASSWORD);
        assertTrue(loginPage.loginError.innerText().contains(Constants.LOGIN_ERROR_TEXT));
    }

    @Test
    public void loginWithEmptyValues(){
        loginPage.logInAccount("","");
        assertTrue(loginPage.loginError.innerText().contains(Constants.LOGIN_ERROR_TEXT));
    }

    @Test
    public void loginWithSpaces(){
        loginPage.logInAccount(" " + Constants.CORRECT_USERNAME + " "," " + Constants.CORRECT_PASSWORD + " ");
        assertTrue(loginPage.loginError.innerText().contains(Constants.LOGIN_ERROR_TEXT));
    }


    @Test
    public void tryXssScriptOnLoginFields(){
        loginPage.logInAccount(Constants.XSS_SCRIPT,Constants.XSS_SCRIPT);
        assertTrue(loginPage.loginError.innerText().contains(Constants.LOGIN_ERROR_TEXT));
    }

    @Test
    public void trySqlInjectionOnLoginFields(){
        loginPage.logInAccount(Constants.SQL_INJECTION,Constants.SQL_INJECTION);
        assertTrue(loginPage.loginError.innerText().contains(Constants.LOGIN_ERROR_TEXT));
    }


    @Test
    public void LoginWithHighRegistryLetters(){
        loginPage.logInAccount(Constants.CORRECT_USERNAME.toUpperCase(),
                Constants.CORRECT_PASSWORD.toUpperCase());
        assertTrue(loginPage.loginError.innerText().contains(Constants.LOGIN_ERROR_TEXT));
    }


    @Test
    public void loginWithASCIISymbols(){
        loginPage.logInAccount(Constants.ASCII_SYMBOLS,Constants.ASCII_SYMBOLS);
        assertTrue(loginPage.loginError.innerText().contains(Constants.LOGIN_ERROR_TEXT));
    }


}
