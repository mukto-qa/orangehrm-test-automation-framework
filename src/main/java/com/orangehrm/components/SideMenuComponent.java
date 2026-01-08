package com.orangehrm.components;

import com.orangehrm.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenuComponent {

    private final ActionDriver action;

    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By dashboardMenu = By.xpath("//span[text()='Dashboard']");

    public SideMenuComponent(WebDriver driver) {
        this.action = new ActionDriver(driver);
    }

    public void goToPIM() {
        action.click(pimMenu);
    }

    public void goToDashboard() {
        action.click(dashboardMenu);
    }
}