package com.orangehrm.pages;

import com.orangehrm.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final ActionDriver action;

    private final By usernameInputField = By.name("username");
    private final By passwordInputField = By.name("password");
    private final By loginButton = By.xpath("//button[text()=' Login ']");
    private final By errorMessage = By.xpath("//p[text()='Invalid credentials']");
    private final By requiredErrorText = By.xpath("//span[text()='Required']");

    public LoginPage(WebDriver driver) {
        this.action = new ActionDriver(driver);
    }

    public void login(String username, String password) {
        action.enterText(usernameInputField, username);
        action.enterText(passwordInputField, password);
        action.click(loginButton);
    }

    public boolean isErrorMessageDisplayed() {
        return action.isDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return action.getText(errorMessage);
    }

    public boolean isRequiredErrorMessageDisplayed() {
        return action.isDisplayed(requiredErrorText);
    }

    public String getRequiredErrorMessage() {
        return action.getText(requiredErrorText);
    }
}
