package com.adf.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;

    public static void initializeDriver() throws Exception {
        prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/config.properties"));

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        driver.get(prop.getProperty("url"));
    }

    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
