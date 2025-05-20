package com.adf.tests;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.adf.pages.DashBoardPage;
import com.adf.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashBoardLogoutTest 
{
	WebDriver driver;
    LoginPage loginPage;
    DashBoardPage dashboardPage;
    Properties prop;

    @BeforeMethod
    public void setUp() throws Exception {
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop = new Properties();
        prop.load(fis);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        dashboardPage = new DashBoardPage(driver);
    }

    @Test
    public void logoutTest() {
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        
        loginPage.login(username, password);
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed or title mismatch!");
        
               
        dashboardPage.clickAccount();
        dashboardPage.DisplayDropdownAndClickLogout();
    }

    /*@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
 	

}*/
    
}