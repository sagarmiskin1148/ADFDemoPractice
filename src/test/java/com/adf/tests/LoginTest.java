package com.adf.tests;

import com.adf.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void validLoginTest() {       
    Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed or title mismatch!");
    }
}
