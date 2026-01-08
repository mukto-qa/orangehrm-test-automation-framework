package com.orangehrm.pages;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.components.HeaderComponent;
import com.orangehrm.components.SideMenuComponent;
import com.orangehrm.enums.SideMenuItem;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private final ActionDriver action;
    private final HeaderComponent header;
    private final SideMenuComponent sideMenu;

    public DashboardPage(WebDriver driver) {
        this.action = new ActionDriver(driver);
        this.header = new HeaderComponent(driver);
        this.sideMenu = new SideMenuComponent(driver);
    }

    public boolean isDashboardPageLoaded() {
        return header.isHeaderDisplayed();
    }

    public String getDashboardPageHeaderText() {
        return header.getHeaderText();
    }

    public void goToAdminPage() {
        sideMenu.navigateTo(SideMenuItem.ADMIN);
    }
}
