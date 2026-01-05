package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import org.testng.annotations.Test;

public class DummyTest extends BaseTest {
    @Test
    public void dummyTest() {
        String title = driver.getTitle();
        System.out.println(title);
    }
}
