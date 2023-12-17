
# Pizza shop UI and API Tests

My name is Mykhailo Shved and it's my final project on Shop with Pizza in Tel-Ran tech school to show my knowledge in Java Test automation.

## Contents
- [Tech Stack](#Tech-Stack)
- [Main test packages/files](#main-test-packagesfiles)
- [How to add new tests?](#how-to-add-new-tests)
- [How to run tests?](#How-to-run-tests)
- [How to serve report after tests?](#How-to-serve-report-after-tests)
- [The possible ways to fix tests](#The-possible-ways-to-fix-tests)
- [Authors](#Authors)


## Tech Stack

- Java 18
- TestNG
- Rest-Assured
- Lombok
- Playwright
- Allure
- Logback


## Main test packages/files


`src/main/java/testdata` contains all Constants that were used in UI test methods as Test Data;

`src/main/java/com/telran/api/dto` contains all DTO (Data Transfer Object) that were used for API test;

`src/main/java/com/telran/ui/pages` UI package contains all data regarding pages in POM (page object model);

`src/main/resources` contains information about allure reports and logback configuration;

`src/test/java/com/telran/ui/tests` contains different tests for UI automation of pizza shop site;

`src/test/java/com/telran/api/tests`
 contains different tests for API automation of pizza shop site;

`src/test/java/com/telran/ui/tests/TestBase.java`  Base Class for Test configurations of Playwright Framework;

## How to add new tests?

1. First, open needed UI page
2. Add needed selenide locators in specific UI page class
3. Take these locators and combine them in the methods of page classes
4. Add API layers in case if it's needed
5. Combine page classes in the tests

## How to run tests?
1. Run all the unit test classes.

   `$ mvn test`
2. Run all the unit test classes with clean up.

   `$ mvn clean test`

3. Run a single test class.

   `$ mvn -Dtest=TestApp1 test`

4. Run multiple test classes.

   `$ mvn -Dtest=TestApp1,TestApp2 test`

5. Run a single test method from a test class.

   `$ mvn -Dtest=TestApp1#methodname test`

6. Run tests with specific browser (firefox as example).

   `$ mvn test -Dbrowser=firefox`

## How to serve report after tests?
1.You can generate a report using one of the following command:  
`$ mvn allure:report`

2.Report will be generated into temp folder. Web server with results will start.   
`$ mvn allure:serve`



## The possible ways to fix tests

1. Restart tests
.If the restart doesn't help - then let's dig deeper.

2. If locator is broken.
Try to find new, correct locator, add it to the specific page.

3. If API method is broken.
Check that status code == expected status code.
If the status code >= 500 - ask devs to recheck the server status. It could be just infrastructure and fix will be rapid. Or, it could be, a bug. In this case, you should create a bug and submit it to the responsible dev
Update endpoint version and commit the changes.


## Authors

- Github - [@behaunter ](https://github.com/behaunter)
- Telegram - [@DJ_Misha  ](https://t.me/DJ_Misha)
- Email - [shved.mih5@gmail.com ](mailto:shved.mih5@gmail.com)

