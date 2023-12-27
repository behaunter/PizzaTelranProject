package com.telran.ui.tests;

import com.telran.ui.pages.HomePage;
import com.telran.ui.pages.LoginPage;
import com.telran.ui.pages.PizzaPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.Constants;

import static org.testng.Assert.assertTrue;

public class PizzaTests extends TestBase {

    PizzaPage pizzaPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void prepare() {
        pizzaPage = new PizzaPage(page);
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        loginPage.goToLoginPage();
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        pizzaPage.goToPizzaPage();

    }

    @Test
    public void checkAllPizzasHaveSameInfoInCafeAndPizzaPages() {
        assertTrue(pizzaPage.checkPizzasInfo(1));
    }

    @Test
    public void checkThatPizzasImagesAreWorkingAndVisible() {
        assertTrue(pizzaPage.areAllImagesVisible());
    }

    @Test
    public void checkBackButtonOnPizzaPage() {
        pizzaPage.backButton.click();
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
    }

}
