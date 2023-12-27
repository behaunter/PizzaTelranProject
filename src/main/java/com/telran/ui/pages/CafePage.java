package com.telran.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafePage extends BasePage {
    public Locator expectedCafe;
    public Locator rowsInTable;
    public Locator newButton;
    public Locator backButton;
    public Locator nameInput;
    public Locator cityInput;
    public Locator addressInput;
    public Locator mailInput;
    public Locator phoneInput;
    public Locator openInput;
    public Locator closeInput;
    public Locator submitBtn;
    public Locator validationErrorName;
    public Locator validationErrorEmail;
    public Locator validationErrorCity;

    public CafePage(Page page) {
        super(page);
        this.expectedCafe = page.locator("xpath=//div[@class='cafe_menu_right']");
        this.rowsInTable = page.locator("table tbody tr");
        this.newButton = page.locator("#new_button");
        this.backButton = page.locator("#back_button");
        this.nameInput = page.locator("#name");
        this.cityInput = page.locator("#city");
        this.phoneInput = page.locator("#phone");
        this.addressInput = page.locator("#address");
        this.mailInput = page.locator("#email");
        this.openInput = page.locator("#open");
        this.closeInput = page.locator("#close");
        this.submitBtn = page.locator("#submit_button");
        this.submitBtn = page.locator("#submit_button");
        this.validationErrorName = page.locator("xpath=//div[contains(text(),'Put a valid name, please')]");
        this.validationErrorEmail = page.locator("xpath=//div[contains(text(),'Enter a valid email')]");
        this.validationErrorCity = page.locator("xpath=//div[contains(text(),'Put a valid city, please')]");
    }

    public CafePage createNewCafe(String name, String city, String address, String email, String phone, String open, String close) {
        newButton.click();
        nameInput.fill(name);
        cityInput.fill(city);
        addressInput.fill(address);
        mailInput.fill(email);
        phoneInput.fill(phone);
        openInput.fill(open);
        closeInput.fill(close);
        submitBtn.click();
        return this;
    }

    public CafePage editCafe(int cafeNumber, String name, String city, String address, String email, String phone, String open, String close) {
        page.locator("xpath=//body[1]/main[1]/section[1]/table[1]/tbody[1]/tr[" + cafeNumber + "]/td[10]/form[1]/div[2]/button[1]").click();
        nameInput.clear();
        nameInput.fill(name);
        cityInput.clear();
        cityInput.fill(city);
        addressInput.clear();
        addressInput.fill(address);
        mailInput.clear();
        mailInput.fill(email);
        phoneInput.clear();
        phoneInput.fill(phone);
        openInput.clear();
        openInput.fill(open);
        closeInput.clear();
        closeInput.fill(close);
        submitBtn.click();
        return this;
    }

    public CafePage deleteCafe(int cafeNumber) {
        page.locator("xpath=//body[1]/main[1]/section[1]/table[1]/tbody[1]/tr[" + cafeNumber + "]/td[11]/form[1]/div[2]/button[1]").click();
        return this;
    }

    @Step("Check if info equals in two tables")
    public boolean isInfoEquals(int numberOfCafeInTable) {
        String text1 = page.locator("xpath=//tbody/tr[" + numberOfCafeInTable + "]").innerText();

        page.locator("xpath=//body[1]/main[1]/section[1]/table[1]/tbody[1]/tr[" + numberOfCafeInTable + "]/td[9]/form[1]/div[2]/button[1]").click();

        String text2 = expectedCafe.innerText();


        List<String> list1 = new ArrayList<>(Arrays.asList(text1.split("\\s+")));
        List<String> list2 = new ArrayList<>(Arrays.asList(text2.split("\\s+")));
        return list1.containsAll(list2);
    }

    public boolean isThereAnyPizzaInCafe() {
        return rowsInTable.count() >= 1;
    }

    public CafePage goToCafeDetails(int numberOfCafeInTable) {
        page.locator("xpath=//body[1]/main[1]/section[1]/table[1]/tbody[1]/tr[" + numberOfCafeInTable + "]/td[9]/form[1]/div[2]/button[1]").click();
        return this;
    }

}
