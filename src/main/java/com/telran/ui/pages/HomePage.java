package com.telran.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    public Locator h1Title;
    public Locator cafesBtn;
    public Locator pizzaBtn;

    public HomePage(Page page) {
        super(page);
        this.h1Title = page.locator("h1");
        this.cafesBtn = page.locator("#cafes_button");
        this.pizzaBtn = page.locator("#pizzas_button");
    }

    public HomePage clickOnCafesBtn() {
        cafesBtn.click();
        return this;
    }

    public HomePage clickOnPizzasBtn() {
        pizzaBtn.click();
        return this;
    }

}
