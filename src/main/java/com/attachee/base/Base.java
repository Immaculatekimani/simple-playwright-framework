package com.attachee.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeSuite;

public class Base {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;
    protected static BrowserContext context;
    protected static Properties prop;


    @BeforeSuite
    public void setup() throws IOException {
        if (playwright == null) {
            prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/config.properties"));

            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
            context = browser.newContext();
            page = context.newPage();
            page.navigate(prop.getProperty("base.url"));
        }
    }

    @AfterSuite
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }


}
