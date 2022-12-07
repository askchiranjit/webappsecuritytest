package com.webappsecurity.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class FeedbackPage extends BasePage {

    private final By name = By.id("name");

    private final By email = By.id("email");

    private final By subject = By.id("subject");

    private final By comment = By.id("comment");

    private final By submit = By.name("submit");

    private final By responseMessage = By.xpath("//h3[@id='feedback-title']/parent::div/parent::div");

    public FeedbackPage typeName(String txt) {
        WebElement element = waitForElementVisibility(name);
        element.sendKeys(txt);
        return this;
    }

    public FeedbackPage typeEmail(String txt) {
        WebElement element = waitForElementVisibility(email);
        element.sendKeys(txt);
        return this;
    }

    public FeedbackPage typeSubject(String txt) {
        WebElement element = waitForElementVisibility(subject);
        element.sendKeys(txt);
        return this;
    }

    public FeedbackPage typeComment(String txt) {
        WebElement element = waitForElementVisibility(comment);
        element.sendKeys(txt);
        return this;
    }

    public FeedbackPage sendMessage() {
        WebElement element = waitForElementClickable(submit);
        element.click();
        return this;
    }

    public boolean isResponseTextDisplayed() {
        WebElement element = waitForElementVisibility(responseMessage);
        return element
                .getText()
                .contains("Thank you for your comments,");
    }

}
