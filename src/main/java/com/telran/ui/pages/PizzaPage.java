package com.telran.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PizzaPage extends BasePage {
    public Locator pizzaImage;
    public Locator rowsInTable;
    public Locator cafeName;
    public Locator newButton;
    public Locator backButton;
    public Locator nameInput;
    public Locator sizeInput;
    public Locator keyIngredientsInput;
    public Locator priceInput;
    public Locator selector;
    public Locator submitBtn;
    public Locator validationErrorSize;
    public Locator validationErrorIngredients;
    public Locator notIntValueError;

    public PizzaPage(Page page) {
        super(page);
        this.pizzaImage = page.locator("xpath=//tbody/tr[1]/td[1]/img[1]");
        this.rowsInTable = page.locator("table tbody tr");
        this.cafeName = page.locator("#cafe_name");
        this.newButton = page.locator("xpath=//button[contains(text(),'New')]");
        this.backButton = page.locator("xpath=//button[contains(text(),'Back')]");
        this.nameInput = page.locator("#name");
        this.sizeInput = page.locator("#size");
        this.keyIngredientsInput = page.locator("#key_ingredients");
        this.priceInput = page.locator("#price");
        this.selector = page.locator("xpath=//select[@id='cafe']");
        this.submitBtn = page.locator("#submit_button");
        this.validationErrorSize = page.locator("xpath=//div[contains(text(),'Put a valid size, please')]");
        this.validationErrorIngredients = page.locator("xpath=//div[contains(text(),'Put a valid ingredients, please')]");
        this.notIntValueError = page.locator("xpath=//div[contains(text(),'Failed to convert property " + "value of type java.lang')]");
    }

    public PizzaPage createNewPizza(String name, String size, String price, String ingredients, String option) {
        newButton.click();
        nameInput.clear();
        nameInput.fill(name);
        sizeInput.fill(size);
        keyIngredientsInput.fill(ingredients);
        priceInput.fill(price);
        selector.selectOption(option);
        submitBtn.click();
        return this;
    }

    public PizzaPage editPizza(int cafeNumber, String name, String size, String price, String ingredients, String option) {
        page.locator("xpath=//body[1]/div[1]/main[1]/section[1]/table[1]/tbody[1]/tr[" + cafeNumber + "]/td[9]/form[1]/div[2]/button[1]").click();
        nameInput.clear();
        nameInput.fill(name);
        sizeInput.clear();
        sizeInput.fill(size);
        keyIngredientsInput.clear();
        keyIngredientsInput.fill(ingredients);
        priceInput.clear();
        priceInput.fill(price);
        selector.selectOption(option);
        submitBtn.click();
        return this;
    }

    public PizzaPage deletePizza(int pizzaNumber) {
        page.locator("xpath=//body[1]/div[1]/main[1]/section[1]/table[1]/tbody[1]/tr[" + pizzaNumber + " ]/" + "td[10]/form[1]/div[2]/button[1]").click();
        return this;
    }

    //Firstly ,i get info about pizza in PizzaPage from Table, then i go to shop and take info about pizzas there
    // to check if they are same.
    public boolean checkPizzasInfo(int pizzaNumber) {
        List<Map<String, String>> generalPizzas = new ArrayList<>();
        int rowCount = rowsInTable.count();

        for (int i = 1; i < rowCount; i++) {
            Map<String, String> generalPizza = new HashMap<>();
            generalPizza.put("name", page.locator("xpath=//tbody/tr[" + i + "]/td[3]").innerText());
            generalPizza.put("cafe", page.locator("xpath=//tbody/tr[" + i + "]/td[7]").innerText());
            generalPizzas.add(generalPizza);
        }
        page.locator("xpath=//tbody/tr[" + pizzaNumber + "]/td[8]").click();
        List<Map<String, String>> cafePizzas = new ArrayList<>();

        int rowCount2 = rowsInTable.count();
        for (int i = 1; i < rowCount2; i++) {

            Map<String, String> cafePizza = new HashMap<>();
            cafePizza.put("name", page.locator("xpath=//tbody/tr[" + i + "]/td[3]").innerText());
            cafePizza.put("cafe", cafeName.innerText());
            cafePizzas.add(cafePizza);
        }
        boolean containsAllPizzas = true;

        for (Map<String, String> cafePizza : cafePizzas) {
            if (!generalPizzas.contains(cafePizza)) {
                containsAllPizzas = false;
                break;
            }
        }
        return containsAllPizzas;
    }

    //Firstly, i get url of image, go to this page and check if there is no 404 page
    public boolean areAllImagesVisible() {
        int rowCount = rowsInTable.count();
        boolean b = false;
        for (int i = 1; i < rowCount; i++) {
            String srcOfImage = page.locator("//tbody/tr[" + i + "]/td[1]/img[1]").getAttribute("src");
            String fullUrl = "http://pizza.telran-edu.de:2222" + srcOfImage;
            page.navigate(fullUrl);
            b = isTextNotOnPage("Whitelabel Error Page");
            page.goBack();
        }
        return b;
    }

}
