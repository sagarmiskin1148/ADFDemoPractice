package com.adf.tests;

import com.adf.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;
import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
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
    }

    @Test
    public void validLoginTest() {
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        loginPage.login(username, password);

        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed or title mismatch!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
