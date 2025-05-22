package com.adf.base;

import com.adf.pages.DashBoardPage;
import com.adf.pages.LibraryPage;
import com.adf.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashBoardPage dashboardPage;
    protected LibraryPage libraryPage;
    protected Properties prop;

    @BeforeMethod
    public void setUp() throws Exception {
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop = new Properties();
        prop.load(fis);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        dashboardPage = new DashBoardPage(driver);
        libraryPage = new LibraryPage();
    }

    /*@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
