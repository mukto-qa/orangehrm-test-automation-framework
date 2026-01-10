package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.models.LoginUserData;
import com.orangehrm.models.UIStringsData;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.DataProviders;
import com.orangehrm.utilities.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginUserData loginUserData;
    private UIStringsData uiStringsData;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setupPages() {
        loginUserData = TestDataReader.getLoginUserData();
        uiStringsData = TestDataReader.getUIStringsData();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(description = "TC_AUTH_01_01: Verify successful login with valid Admin credentials", groups = {"smoke"})
    public void shouldLoginSuccessfully() {
        loginPage.login(loginUserData.getUsername(), loginUserData.getPassword());
        Assert.assertTrue(dashboardPage.isDashboardPageLoaded(), "Dashboard page should be loaded after successful login");
        Assert.assertEquals(dashboardPage.getDashboardPageHeaderText(), uiStringsData.getDashboardPageHeader(), "Dashboard header text mismatch");
    }

    @Test(description = "TC_AUTH_01_02 - TC_AUTH_01_04: Verify login fails with invalid credentials", groups = {"regression"}, dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class)
    public void shouldFailLoginWithInvalidCredentials(LoginUserData userData) {
        loginPage.login(userData.getUsername(), userData.getPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        Assert.assertEquals(loginPage.getErrorMessage(), uiStringsData.getInvalidCredentialsMessage(), "Error message text mismatch");
    }

    @Test(description = "TC_AUTH_01_05 - TC_AUTH_01_07: Verify login fails with empty credentials", groups = {"regression"}, dataProvider = "emptyLoginData", dataProviderClass = DataProviders.class)
    public void shouldFailLoginWithEmptyCredentials(LoginUserData userData) {
        loginPage.login(userData.getUsername(), userData.getPassword());
        Assert.assertTrue(loginPage.isRequiredErrorMessageDisplayed(), "Required error message not displayed");
        Assert.assertEquals(loginPage.getRequiredErrorMessage(), uiStringsData.getRequiredFieldMessage(), "Required message text mismatch");
    }

    @Test(description = "TC_AUTH_01_12: Verify case sensitivity of password field", groups = {"regression"})
    public void shouldLoginSuccessfullyWithCaseSensitivityOfPasswordField() {
        loginPage.login(loginUserData.getUsername(), loginUserData.getPassword().toUpperCase());
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        Assert.assertEquals(loginPage.getErrorMessage(), uiStringsData.getInvalidCredentialsMessage(), "Error message text mismatch");
    }
}
