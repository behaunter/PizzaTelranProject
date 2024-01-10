package com.telran.ui.tests;

import com.telran.ui.pages.CafePage;
import com.telran.ui.pages.LoginPage;
import com.telran.ui.pages.PizzaPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.Constants;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PizzaCRUDTests extends TestBase {

    PizzaPage pizzaPage;
    LoginPage loginPage;
    CafePage cafePage;

    @BeforeClass
    public void createNewCafe() {
        pizzaPage = new PizzaPage(page);
        loginPage = new LoginPage(page);
        cafePage = new CafePage(page);


        loginPage.goToLoginPage();
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        cafePage.createNewCafe(Constants.CAFE_NAME, Constants.CAFE_CITY, Constants.CAFE_ADDRESS, Constants.CAFE_EMAIL, Constants.CAFE_PHONE_NEW, Constants.CAFE_OPEN, Constants.CAFE_CLOSE);
    }

    @BeforeMethod
    public void prepare() {
        loginPage.goToLoginPage();
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        pizzaPage.goToPizzaPage();
    }

    @Test(priority = 1)
    public void createNewPizza() {
        pizzaPage.createNewPizza(Constants.PIZZA_NAME, Constants.PIZZA_SIZE, Constants.PIZZA_PRICE, Constants.PIZZA_INGREDIENTS_NEW, Constants.CAFE_NAME);
        assertTrue(pizzaPage.isTextOnPage(Constants.PIZZA_NAME));

    }

    @Test(priority = 2)
    public void editPizza() {
        int numberOfPizza = pizzaPage.rowCountInTable();
        pizzaPage.editPizza(numberOfPizza, Constants.EDITED_PIZZA_NAME, Constants.PIZZA_SIZE, Constants.PIZZA_PRICE, Constants.PIZZA_INGREDIENTS_NEW, Constants.CAFE_NAME);
        assertTrue(pizzaPage.isTextOnPage(Constants.EDITED_PIZZA_NAME));

    }

    @Test(priority = 3)
    public void deletePizza() {
        int numberOfPizza = pizzaPage.rowCountInTable();
        pizzaPage.deletePizza(numberOfPizza);
        assertTrue(pizzaPage.isTextNotOnPage(Constants.EDITED_PIZZA_NAME));
    }

    @Test
    public void createNewPizzaWithEmptyValues() {
        pizzaPage.createNewPizza("", "", "", "", Constants.CAFE_NAME);
        assertEquals(pizzaPage.validationErrorIngredients.innerText(), Constants.INVALID_INGREDIENTS_ERROR);
        assertEquals(pizzaPage.validationErrorSize.innerText(), Constants.INVALID_SIZE_ERROR);
    }

    @Test
    public void createNewPizzaWithWrongPriceType() {
        pizzaPage.createNewPizza("", "", Constants.WRONG_PRICE_TYPE, "", Constants.CAFE_NAME);
        assertTrue(pizzaPage.notIntValueError.innerText().contains(Constants.WRONG_TYPE_PRICE));

    }

    @AfterClass
    public void deleteCafe() {
        loginPage.goToLoginPage();
        loginPage.logInAccount(Constants.ADMIN_USERNAME, Constants.CORRECT_PASSWORD);
        cafePage.goToCafePage();
        int numberOfCafe = cafePage.rowCountInTable();
        cafePage.deleteCafe(numberOfCafe);
    }

}
