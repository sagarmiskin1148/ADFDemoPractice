package com.adf.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    // Load properties file
    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load config.properties: " + e.getMessage());
        }
    }

    // Initialize the WebDriver
    public static void initializeDriver() {
        loadConfig();
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url").replace("\"", "");
        int waitTime = Integer.parseInt(prop.getProperty("implicitWait", "10"));

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        driver.get(url);
    }

    
    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
