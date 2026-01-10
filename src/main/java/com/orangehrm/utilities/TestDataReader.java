package com.orangehrm.utilities;

import com.orangehrm.models.LoginTestData;
import com.orangehrm.models.LoginUserData;
import com.orangehrm.models.UIStringsData;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataReader {
    private static final String TEST_DATA_PATH = "testdata/";
    private static final String LOGIN_USER_DATA_FILE_PATH = TEST_DATA_PATH + "login/loginUser.json";
    private static final String LOGIN_TEST_DATA_FILE = TEST_DATA_PATH + "login/loginTestData.json";
    private static final String UI_STRINGS_DATA_FILE = TEST_DATA_PATH + "constants/uiStrings.json";

    public LoginUserData getLoginUserData() {
        return JsonUtils.deserializeJson(LOGIN_USER_DATA_FILE_PATH, LoginUserData.class);
    }

    public static LoginTestData getLoginTestData() {
        return JsonUtils.deserializeJson(LOGIN_TEST_DATA_FILE, LoginTestData.class);
    }

    public UIStringsData getUIStringsData() {
        return JsonUtils.deserializeJson(UI_STRINGS_DATA_FILE, UIStringsData.class);
    }
}
