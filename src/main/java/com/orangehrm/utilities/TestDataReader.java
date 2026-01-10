package com.orangehrm.utilities;

import com.orangehrm.models.LoginUserData;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataReader {
    private static final String TEST_DATA_PATH = "testdata/";
    private static final String LOGIN_USER_DATA_FILE_PATH = TEST_DATA_PATH + "login/loginUser.json";

    public LoginUserData getLoginUserData() {
        return JsonUtils.deserializeJson(LOGIN_USER_DATA_FILE_PATH, LoginUserData.class);
    }
}
