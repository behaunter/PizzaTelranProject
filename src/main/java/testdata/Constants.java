package testdata;

import org.apache.commons.lang3.RandomStringUtils;

public class Constants {
    public static final String HOME_PAGE_URL = "http://pizza.telran-edu.de:2222/";

    //Home Page tests
    public static final String CAFE_PHONE = "Phone";
    public static final String PIZZA_INGREDIENTS = "Ingredients";
    public static final String LOGIN_PAGE_TEXT = "Login";

    //Login Page tests
    public static final String LOGIN_ERROR_TEXT = "Invalid username or password";
    public static final String ANONYMOUS_USERNAME = "anonymousUser!";
    public static final String CORRECT_USERNAME = "user";
    public static final String ADMIN_USERNAME = "admin";
    public static final String CORRECT_PASSWORD = "1";
    public static final String INCORRECT_USERNAME = RandomStringUtils.randomAlphanumeric(1, 20);
    public static final String INCORRECT_PASSWORD = RandomStringUtils.randomAlphanumeric(1, 20);
    public static final String ASCII_SYMBOLS = RandomStringUtils.randomAscii(1, 20);
    public static final String XSS_SCRIPT = "<script>alert(1)</script>";
    public static final String SQL_INJECTION = "SELECT * FROM Users WHERE UserId = 1;";

    //HomePageTests

    public static final String LOGO_TEXT = "Cafe";
    public static final String H1_TEXT = "Cafe Pizza";


    //Cafe Page
    public static final String INVALID_NAME_ERROR = "Put a valid name, please";
    public static final String INVALID_EMAIL_ERROR = "Enter a valid email";
    public static final String INVALID_CITY_ERROR = "Put a valid city, please";

    public static final String CAFE_NAME = RandomStringUtils.randomAlphanumeric(1, 20);
    public static final String EDITED_NAME = RandomStringUtils.randomAlphanumeric(1, 20);
    public static final String CAFE_CITY = RandomStringUtils.randomAlphanumeric(1, 20);
    public static final String CAFE_ADDRESS = RandomStringUtils.randomAlphanumeric(1, 20);
    public static final String CAFE_EMAIL = RandomStringUtils.randomAlphanumeric(1, 10) + "@gmail.com";
    public static final String WRONG_EMAIL = RandomStringUtils.randomAlphanumeric(1, 10) ;
    public static final String CAFE_PHONE_NEW = RandomStringUtils.randomAlphanumeric(1, 20);
    public static final String CAFE_OPEN = RandomStringUtils.randomAlphanumeric(1, 5);
    public static final String CAFE_CLOSE = RandomStringUtils.randomAlphanumeric(1, 5);


    //Pizza Page
    public static final String WRONG_TYPE_PRICE = "Failed to convert property value of type java.lang.String to required " +
            "type double for property price;";
    public static final String INVALID_INGREDIENTS_ERROR = "Put a valid ingredients, please";
    public static final String INVALID_SIZE_ERROR = "Put a valid size, please";

    public static final String PIZZA_NAME = RandomStringUtils.randomAlphanumeric(1, 10);
    public static final String EDITED_PIZZA_NAME = RandomStringUtils.randomAlphanumeric(1, 10);
    public static final String PIZZA_SIZE = RandomStringUtils.randomNumeric(1, 5);
    public static final String PIZZA_PRICE = RandomStringUtils.randomNumeric(1, 2);
    public static final String PIZZA_INGREDIENTS_NEW = RandomStringUtils.randomAlphanumeric(1, 10) ;
    public static final String WRONG_PRICE_TYPE = RandomStringUtils.randomAlphanumeric(1, 10) ;





}
