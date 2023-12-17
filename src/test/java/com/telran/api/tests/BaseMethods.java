package com.telran.api.tests;

import com.telran.api.dto.CafeDto;
import com.telran.api.dto.ErrorDto;
import com.telran.api.dto.PizzaDto;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class BaseMethods {

    public static PizzaDto findCheapestPizza(List<PizzaDto> pizzas) {

        PizzaDto cheapest = pizzas.get(0);

        for (PizzaDto pizza : pizzas) {
            if (pizza.getPrice() < cheapest.getPrice()) {
                cheapest = pizza;
            }
        }
        return cheapest;
    }

    public static List<PizzaDto> getAllPizzasRequest() {
        List<PizzaDto> response = given()
                .when()
                .get("pizzas")
                .then()
                .log().all()
                .time(lessThan(Data.TWO_SECONDS))
                .extract().response().jsonPath().getList("", PizzaDto.class);
        return response;
    }

    public static List<CafeDto> getAllCafesRequest() {
        List<CafeDto> response = given()
                .when()
                .get("cafes")
                .then()
                .log().all()
                .time(lessThan(Data.TWO_SECONDS))
                .extract().response().jsonPath().getList("", CafeDto.class);
        return response;
    }

    public static PizzaDto getPizzaByIdRequest(int id) {
        return given()
                .when()
                .get("pizzas/"+ id)
                .then()
                .log().all()
                .time(lessThan(Data.TWO_SECONDS))
                .extract().response().as(PizzaDto.class);
    }

    public static CafeDto getCafeByIdRequest(int id) {
        return given()
                .when()
                .get("cafes/"+ id)
                .then()
                .log().all()
                .time(lessThan(Data.TWO_SECONDS))
                .extract().response().as(CafeDto.class);
    }

    public static ErrorDto incorrectRequests(String currentUrl) {
        return given()
                .when()
                .get(currentUrl)
                .then()
                .log().all()
                .time(lessThan(Data.TWO_SECONDS))
                .extract().response().as(ErrorDto.class);
    }
}
