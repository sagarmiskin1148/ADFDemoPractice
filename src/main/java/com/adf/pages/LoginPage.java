package com.adf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    private By usernameInput = By.id("TxtUserName");
    private By passwordInput = By.xpath("//input[@id='TxtPassword']");
    private By loginButton = By.xpath("//input[@id='container_0_LbLogin']");
    private By errorMessage = By.id("LblMessage");

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

    public String getErrorMessage() {
        WebElement errorElem = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElem.getText();
    }
}
