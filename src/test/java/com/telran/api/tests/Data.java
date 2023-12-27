package com.telran.api.tests;

public class Data {
    public static final String URL = "http://pizza.telran-edu.de:2222/api/";
    public static final int SERVER_ERROR_CODE = 500;
    public static final int CLIENT_ERROR_CODE = 400;
    public static final String EXPECTED_SERVER_ERROR = "Internal Server Error";
    public static final String BAD_REQUEST_ERROR = "Bad Request";
    public static final String INCORRECT_PIZZA_ID = "pizzas/100";
    public static final String NOT_INT_PIZZA_ID = "pizzas/10000000000000000000000000000";
    public static final String ASCII_PIZZA_ID = "pizzas/!@#$";
    public static final String INCORRECT_CAFE_ID = "pizzas/100";
    public static final String NOT_INT_CAFE_ID = "pizzas/10000000000000000000000000000";
    public static final String ASCII_CAFE_ID = "pizzas/!@#$";
    public static final long TWO_SECONDS = 2000L;
    public static final String THE_CHEAPEST_PIZZA = "Pizza Romano";

}
