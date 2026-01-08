package com.orangehrm.components;

import com.orangehrm.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent {

    private final ActionDriver action;

    private final By pageHeader = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");

    public HeaderComponent(WebDriver driver) {
        this.action = new ActionDriver(driver);
    }

    public String getHeaderText() {
        return action.getText(pageHeader);
    }

    public boolean isHeaderDisplayed() {
        return action.isDisplayed(pageHeader);
    }
}