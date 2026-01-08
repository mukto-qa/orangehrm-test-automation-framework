package com.orangehrm.components;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.enums.SideMenuItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenuComponent {

    private final ActionDriver action;

    private static final String MENU_XPATH =
            "//span[contains(@class,'oxd-main-menu-item--name') and text()='%s']";

    public SideMenuComponent(WebDriver driver) {
        this.action = new ActionDriver(driver);
    }

    public void navigateTo(SideMenuItem menuItem) {
        By menuLocator = By.xpath(
                String.format(MENU_XPATH, menuItem.getDisplayName())
        );
        action.click(menuLocator);
    }
}