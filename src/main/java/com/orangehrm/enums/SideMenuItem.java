package com.orangehrm.enums;

public enum SideMenuItem {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");

    private final String displayName;

    SideMenuItem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
