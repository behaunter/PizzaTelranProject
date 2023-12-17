package com.telran.ui.tests;

import com.telran.ui.pages.CafePage;
import com.telran.ui.pages.HomePage;
import com.telran.ui.pages.LoginPage;
import testdata.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CafeTest extends TestBase {


    CafePage cafePage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void prepare() {
        cafePage = new CafePage(page);
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        loginPage.goToLoginPage();

    }

    @Test
    public void checkCafeInfoEqualsInDetailsInfo() {
        loginPage.logInAccount(Constants.CORRECT_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        assertTrue(cafePage.isInfoEquals(1));
    }

    @Test
    public void checkThatCafeHasAtLeastOnePizza() {
        loginPage.logInAccount(Constants.CORRECT_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        cafePage.goToCafeDetails(1);
        assertTrue(cafePage.isThereAnyPizzaInCafe());
    }

    @Test
    public void checkBackButtonOnCafePage(){
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        cafePage.backButton.click();
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
    }

    @Test(priority = 1)
    public void createNewCafe() throws InterruptedException {
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        cafePage.createNewCafe(Constants.CAFE_NAME,Constants.CAFE_CITY,Constants.CAFE_ADDRESS,Constants.CAFE_EMAIL,
                Constants.CAFE_PHONE_NEW,Constants.CAFE_OPEN,Constants.CAFE_CLOSE);
        Thread.sleep(3333);
        assertTrue(cafePage.isTextOnPage(Constants.CAFE_NAME));
    }

    @Test(priority = 2)
    public void editCafe(){
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        int numberOfCafe = cafePage.rowCountInTable();
        cafePage.editCafe(numberOfCafe,Constants.EDITED_NAME,Constants.CAFE_CITY,Constants.CAFE_ADDRESS,Constants.CAFE_EMAIL,
                Constants.CAFE_PHONE_NEW,Constants.CAFE_OPEN,Constants.CAFE_CLOSE);
        assertTrue(cafePage.isTextOnPage(Constants.EDITED_NAME));
    }

    @Test(priority = 3)
    public void deleteCafe(){
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        int numberOfCafe = cafePage.rowCountInTable();
        cafePage.deleteCafe(numberOfCafe);
        assertTrue(cafePage.isTextNotOnPage(Constants.EDITED_NAME));
    }

    @Test
    public void createNewCafeWithEmptyFields(){
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        cafePage.createNewCafe("","","","",
                "","","");
        assertEquals(cafePage.validationErrorName.innerText(), Constants.INVALID_NAME_ERROR);
        assertEquals(cafePage.validationErrorCity.innerText(), Constants.INVALID_CITY_ERROR);
        assertEquals(cafePage.validationErrorEmail.innerText(), Constants.INVALID_EMAIL_ERROR);
    }

    @Test
    public void createNewCafeWithWrongEmail(){
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        cafePage.createNewCafe(Constants.CAFE_NAME,Constants.CAFE_CITY,Constants.CAFE_ADDRESS,Constants.WRONG_EMAIL,
                Constants.CAFE_PHONE_NEW,Constants.CAFE_OPEN,Constants.CAFE_CLOSE);
        assertEquals(cafePage.validationErrorEmail.innerText(),Constants.INVALID_EMAIL_ERROR);
    }
}
