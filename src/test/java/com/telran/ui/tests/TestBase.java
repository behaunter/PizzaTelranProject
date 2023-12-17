package com.telran.ui.tests;

import com.microsoft.playwright.*;
import io.qameta.allure.Step;
import testdata.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class TestBase {

    private Browser browser;
    protected Page page;
    private BrowserContext context;
    private Boolean isTraceEnabled = false;

    @Step("Starting Browser")
    @BeforeClass
    public void  setUp(){

        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        //browser for context
        context = browser.newContext();

        //tracing
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(false)
                .setSources(false));
        isTraceEnabled = true;

        //creating new page
        page = context.newPage();
        page.navigate(Constants.HOME_PAGE_URL);

    }

    //closing browser after tests
    @Step("Closing Browser")
    @AfterClass
    public void tearDown(){
        if (browser != null){
            browser.close();
            browser = null;
        }
    }

}
