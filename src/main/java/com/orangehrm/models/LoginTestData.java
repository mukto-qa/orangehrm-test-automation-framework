package com.orangehrm.models;

import lombok.Data;

@Data
public class LoginTestData {
    private LoginUserData invalidUsername;
    private LoginUserData invalidPassword;
    private LoginUserData invalidBoth;
    private LoginUserData emptyUsername;
    private LoginUserData emptyPassword;
    private LoginUserData emptyBoth;
}
