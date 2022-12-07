package com.webappsecurity.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    private final By homeTab = By.id("homeMenu");

    private final By onlineBankingTab = By.id("onlineBankingMenu");

    private final By feedbackTab = By.id("feedback");

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isHomeTabDisplayed() {
        WebElement homeTabElement = waitForElementVisibility(homeTab);
        return homeTabElement.isDisplayed();
    }

    public boolean isHomeTabActive() {
        WebElement homeTabElement = waitForElementVisibility(homeTab);
        return homeTabElement
                .getAttribute("class")
                .equals("active");
    }

    public boolean isOnlineBankingTabDisplayed() {
        WebElement onlineBankingTabElement = waitForElementVisibility(onlineBankingTab);
        return onlineBankingTabElement.isDisplayed();
    }

    public boolean isOnlineBankingTabActive() {
        WebElement onlineBankingTabElement = waitForElementVisibility(onlineBankingTab);
        return onlineBankingTabElement
                .getAttribute("class")
                .equals("active");
    }

    public boolean isFeedbackTabDisplayed() {
        WebElement feedbackTabElement = waitForElementVisibility(feedbackTab);
        return feedbackTabElement.isDisplayed();
    }

    public boolean isFeedbackTabActive() {
        WebElement feedbackTabElement = waitForElementVisibility(feedbackTab);
        return feedbackTabElement
                .getAttribute("class")
                .equals("active");
    }

    public HomePage navigateToOnlineBanking() {
        WebElement onlineBankingTabElement = waitForElementClickable(onlineBankingTab);
        onlineBankingTabElement.click();
        return this;
    }

    public HomePage navigateToFeedback() {
        WebElement feedbackTabElement = waitForElementClickable(feedbackTab);
        feedbackTabElement.click();
        return this;
    }

    public HomePage navigateToHome() {
        WebElement homeTabElement = waitForElementClickable(homeTab);
        homeTabElement.click();
        return this;
    }
}
