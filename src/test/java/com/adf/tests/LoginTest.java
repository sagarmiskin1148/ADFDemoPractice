package com.adf.tests;

import com.adf.base.BaseClass;
import com.adf.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @BeforeMethod
    public void setUp() {
        initializeDriver();
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        loginPage.login(username, password);
        System.out.println("Login attempted with username: " + username);
    }

    /*
    @AfterMethod
    public void tearDown() {
        tearDownDriver();
    }
    */
}
