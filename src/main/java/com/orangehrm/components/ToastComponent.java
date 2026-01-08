package com.orangehrm.components;

import com.orangehrm.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToastComponent {

    private final ActionDriver action;

    private final By toastMessage = By.cssSelector(".oxd-toast");

    public ToastComponent(WebDriver driver) {
        this.action = new ActionDriver(driver);
    }

    public String getToastMessage() {
        return action.getText(toastMessage);
    }

    public boolean isToastDisplayed() {
        return action.isDisplayed(toastMessage);
    }
}