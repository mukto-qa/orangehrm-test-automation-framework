package com.orangehrm.utilities;

import com.orangehrm.models.LoginTestData;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        LoginTestData data = TestDataReader.getLoginTestData();
        return new Object[][]{{data.getInvalidUsername()}, {data.getInvalidPassword()}, {data.getInvalidBoth()},};
    }

    @DataProvider(name = "emptyLoginData")
    public static Object[][] emptyLoginData() {
        LoginTestData data = TestDataReader.getLoginTestData();
        return new Object[][]{{data.getEmptyUsername()}, {data.getEmptyPassword()}, {data.getEmptyBoth()},};
    }
}
