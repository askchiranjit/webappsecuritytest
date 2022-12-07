package com.webappsecurity.test.uitests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseTest {

    @Autowired
    protected WebDriver browser;

    protected void navigateTo(String url) {
        browser.navigate().to(url);
    }

    protected void back() {
        browser.navigate().back();
    }

    protected void closeBrowser() {
        if (browser != null) {
            browser.quit();
        }
    }
}
