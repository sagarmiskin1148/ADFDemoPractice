package com.adf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.adf.base.BaseClass;

public class DashBoardLogoutTest extends BaseClass {

    @Test
    public void logoutTest() {
    Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed or title mismatch!");

        dashboardPage.clickAccount();
        dashboardPage.DisplayDropdownAndClickLogout();
    }
}
