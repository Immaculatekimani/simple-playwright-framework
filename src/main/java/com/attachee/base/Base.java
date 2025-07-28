package com.attachee.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Base {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;
    protected Properties prop;

    @BeforeClass
    public void setup() throws IOException {
        prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/config.properties"));

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));

        context = browser.newContext();
        page = context.newPage();
        page.navigate(prop.getProperty("base.url"));
    }

    @AfterClass
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
