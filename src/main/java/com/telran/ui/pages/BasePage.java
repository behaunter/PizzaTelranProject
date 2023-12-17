package com.telran.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class BasePage {

    public Page page;

    public Locator loginLink;
    public Locator homeLink;
    public Locator cafeLink;
    public Locator pizzaLink;
    public Locator headerLogo;
    public Locator footerLogo;
    public Locator rowsInTable;

    public BasePage(Page page) {
        this.page = page;
        this.loginLink = page.locator("#auth_header_menu");
        this.homeLink = page.locator("#home_header_menu");
        this.cafeLink = page.locator("#cafes_header_menu");
        this.pizzaLink = page.locator("#pizzas_header_menu");
        this.headerLogo = page.locator("#logo_header_menu");
        this.footerLogo = page.locator("#logo_footer");
        this.rowsInTable = page.locator("table tbody tr");

    }

    public void waitForSelectorToBeVisible(String selector) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void clickOnHomeLink(){
        homeLink.click();
    }

    public void goToCafePage(){
        cafeLink.click();
    }

    public void goToPizzaPage(){
        pizzaLink.click();
    }


    public void goToLoginPage(){
        loginLink.click();
        page.waitForLoadState(LoadState.LOAD);
    }

    public void clickOnHeaderLogo(){
        headerLogo.click();
    }

    public void clickOnFooterLogo(){
        footerLogo.click();
    }

    public boolean isTextOnPage(String text) {
        String pageContent = page.textContent("body");

        return pageContent.contains(text);
    }

    public boolean isTextNotOnPage(String text){
        String pageContent = page.textContent("body");

        return !pageContent.contains(text);
    }

    public int rowCountInTable (){
        return  rowsInTable.count();
    }


}
