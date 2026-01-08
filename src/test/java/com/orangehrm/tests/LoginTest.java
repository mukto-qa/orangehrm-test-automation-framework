package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setupPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void loginTest(){
        loginPage.login("admin", "Thisisfortest@001");
        Assert.assertTrue(dashboardPage.isDashboardPageLoaded());
        Assert.assertEquals(dashboardPage.getDashboardPageHeaderText(), "Dashboard");
    }
}
