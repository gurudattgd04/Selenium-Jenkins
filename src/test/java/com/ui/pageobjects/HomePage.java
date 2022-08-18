package com.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    protected WebDriver driver;

    // <h1>Hello userName</h1>
    private By messageBy = By.tagName("h1");

    public HomePage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals("Home Page of logged in user")) {
            throw new IllegalStateException("This is not Home Page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public String getMessageText() {
        return driver.findElement(messageBy).getText();
    }

    public HomePage manageProfile() {
        return new HomePage(driver);
    }
}