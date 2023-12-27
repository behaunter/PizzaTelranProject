package com.telran.api.tests;


import com.telran.api.dto.CafeDto;
import com.telran.api.dto.ErrorDto;
import com.telran.api.dto.PizzaDto;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


public class ApiTests extends BaseMethods {

    private static int cafeId;
    private static int pizzaId;

    @Epic(value = "Positive Api Test")
    @Test(priority = 1)
    public void getAllPizzas() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        List<PizzaDto> response = getAllPizzasRequest();
        pizzaId = response.getFirst().getId();

        for (PizzaDto pizza : response) {
            assertNotNull(pizza.getId());
            assertNotNull(pizza.getName());
            assertNotNull(pizza.getSize());
            assertNotNull(pizza.getKeyIngredients());
            assertNotNull(pizza.getPrice());
            assertNotNull(pizza.getImage());
        }
    }

    @Epic(value = "Positive Api Test")
    @Test(priority = 1)
    public void getAllCafes() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        List<CafeDto> response = getAllCafesRequest();

        cafeId = response.getFirst().getId();


        for (CafeDto cafe : response) {
            assertNotNull(cafe.getId());
            assertNotNull(cafe.getName());
            assertNotNull(cafe.getEmail());
            assertNotNull(cafe.getCity());
            assertNotNull(cafe.getAddress());
            assertNotNull(cafe.getPhone());
        }
    }

    @Epic(value = "Positive Api Test")
    @Test(priority = 2)
    public void getPizzaById() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        PizzaDto response = getPizzaByIdRequest(pizzaId);
    }

    @Test
    public void getPizzaByIncorrectId() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.responseSpec(Data.SERVER_ERROR_CODE));

        ErrorDto response = incorrectRequests(Data.INCORRECT_PIZZA_ID);

        Assert.assertEquals(response.getError(), Data.EXPECTED_SERVER_ERROR);
    }

    @Epic(value = "Negative Api Test")
    @Test
    public void getPizzaByNotIntId() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.responseSpec(Data.CLIENT_ERROR_CODE));

        ErrorDto response = incorrectRequests(Data.NOT_INT_PIZZA_ID);

        Assert.assertEquals(response.getError(), Data.BAD_REQUEST_ERROR);
    }

    @Epic(value = "Negative Api Test")
    @Test
    public void getPizzaByIdWithASCII() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.responseSpec(Data.CLIENT_ERROR_CODE));

        ErrorDto response = incorrectRequests(Data.ASCII_PIZZA_ID);

        Assert.assertEquals(response.getError(), Data.BAD_REQUEST_ERROR);
    }

    @Epic(value = "Positive Api Test")
    @Test(priority = 2)
    public void getCafeById() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        CafeDto response = getCafeByIdRequest(cafeId);
    }

    @Epic(value = "Negative Api Test")
    @Test
    public void getCafeByIncorrectId() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.responseSpec(Data.SERVER_ERROR_CODE));

        ErrorDto response = incorrectRequests(Data.INCORRECT_CAFE_ID);

        Assert.assertEquals(response.getError(), Data.EXPECTED_SERVER_ERROR);
    }

    @Epic(value = "Negative Api Test")
    @Test
    public void getCafeByNotIntId() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.responseSpec(Data.CLIENT_ERROR_CODE));

        ErrorDto response = incorrectRequests(Data.NOT_INT_CAFE_ID);

        Assert.assertEquals(response.getError(), Data.BAD_REQUEST_ERROR);
    }

    @Epic(value = "Negative Api Test")
    @Test
    public void getCafeByIdWithASCII() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.responseSpec(Data.CLIENT_ERROR_CODE));

        ErrorDto response = incorrectRequests(Data.ASCII_CAFE_ID);

        Assert.assertEquals(response.getError(), Data.BAD_REQUEST_ERROR);
    }

    @Epic(value = "Positive Api Test")
    @Test(priority = 2)
    public void checkPizzaIsAsExpected() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        List<PizzaDto> responseForAllPizzas = getAllPizzasRequest();


        PizzaDto responseForOnePizza = getPizzaByIdRequest(pizzaId);

        assertTrue(responseForAllPizzas.toString().contains(responseForOnePizza.toString()));
        assertEquals(responseForAllPizzas.get(0).getName(), responseForOnePizza.getName());
    }

    @Epic(value = "Positive Api Test")
    @Test(priority = 2)
    public void checkCafeIsAsExpected() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        List<CafeDto> responseForAllCafes = getAllCafesRequest();


        CafeDto responseForOneCafe = getCafeByIdRequest(cafeId);

    }

    @Epic(value = "Positive Api Test")
    @Test
    public void checkEveryCafeHasAtLeastOnePizza() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        List<CafeDto> responseForAllCafes = getAllCafesRequest();

        for (CafeDto cafe : responseForAllCafes) {
            assertFalse(cafe.getPizzaMenu().isEmpty(),
                    "Cafe " + cafe.getName() + "does not have any pizza");
        }
    }

    @Epic(value = "Positive Api Test")
    @Test
    public void checkAndPrintTheCheapestPizza() {
        Specifications.installSpecification(Specifications.requestSpec(Data.URL),
                Specifications.successfulResponseWithJsonSpec());

        List<PizzaDto> responseForAllPizzas = getAllPizzasRequest();

        System.out.println(findCheapestPizza(responseForAllPizzas).getName());
    }

}
