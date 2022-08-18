package com.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    protected WebDriver driver;
    private By usernameBy = By.name("user_name");
    private By passwordBy = By.name("password");
    private By signinBy = By.name("sign_in");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public HomePage loginValidUser(String userName, String password) {
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signinBy).click();
        return new HomePage(driver);
    }
}