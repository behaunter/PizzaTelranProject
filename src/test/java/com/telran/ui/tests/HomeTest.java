package com.telran.ui.tests;

import com.telran.ui.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import testdata.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomeTest extends TestBase{

    HomePage homePage;

    @BeforeMethod
    public void prepare() {
     homePage = new HomePage(page);
     homePage.clickOnHomeLink();
    }

    @Test
    public void checkTitleOfPage(){
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
    }

    @Test
    public void checkHeaderLogoOnPage(){
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
        homePage.clickOnHeaderLogo();
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
    }

    @Test
    public void checkFooterLogoOnPage(){
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));
        homePage.clickOnFooterLogo();
        assertTrue(homePage.headerLogo.innerText().contains(Constants.LOGO_TEXT));
        assertTrue(homePage.h1Title.innerText().contains(Constants.H1_TEXT));

    }
    @Test
    public void checkLinkToCafePage(){
        homePage.goToCafePage();
        String currentCafeUrl = page.url();
        assertNotEquals(currentCafeUrl, Constants.HOME_PAGE_URL);
        assertFalse(homePage.h1Title.isVisible());
        assertTrue(homePage.isTextOnPage(Constants.CAFE_PHONE));


    }
    @Test
    public void checkButtonToCafesPage(){
        homePage.clickOnCafesBtn();
        String currentCafeUrl = page.url();
        assertNotEquals(currentCafeUrl, Constants.HOME_PAGE_URL);
        assertFalse(homePage.h1Title.isVisible());
        assertTrue(homePage.isTextOnPage(Constants.CAFE_PHONE));


    }
    @Test
    public void checkLinkToPizzaPage(){
        homePage.goToPizzaPage();
        String currentCafeUrl = page.url();
        assertNotEquals(currentCafeUrl, Constants.HOME_PAGE_URL);
        assertFalse(homePage.h1Title.isVisible());
        assertTrue(homePage.isTextOnPage(Constants.PIZZA_INGREDIENTS));
    }

    @Test
    public void checkButtonToPizzasPage(){
        homePage.clickOnPizzasBtn();
        String currentCafeUrl = page.url();
        assertNotEquals(currentCafeUrl, Constants.HOME_PAGE_URL);
        assertFalse(homePage.h1Title.isVisible());
        assertTrue(homePage.isTextOnPage(Constants.PIZZA_INGREDIENTS));
    }

    @Test
    public void checkLinkToLoginPage(){
        homePage.goToLoginPage();
        String currentCafeUrl = page.url();
        assertNotEquals(currentCafeUrl, Constants.HOME_PAGE_URL);
        assertFalse(homePage.h1Title.isVisible());
        assertTrue(homePage.isTextOnPage(Constants.LOGIN_PAGE_TEXT));
    }
}
