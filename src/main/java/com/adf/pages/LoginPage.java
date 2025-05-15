package com.adf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators inside LoginPage class
    private final By usernameInput = By.id("TxtUserName");
    private final By passwordInput = By.id("TxtPassword");
    private final By loginButton = By.id("container_0_LbLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login(String username, String password) {
        WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameElem.clear();
        usernameElem.sendKeys(username);

        WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElem.clear();
        passwordElem.sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}
