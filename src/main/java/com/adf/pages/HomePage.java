package com.adf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOurProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locators.OUR_PRODUCTS_LINK));
        element.click();
    }

    public void scrollAndClickSubscription(String subscriptionName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By subscriptionLocator;

        switch(subscriptionName.toLowerCase()) {
            case "platinum":
                subscriptionLocator = Locators.PLATINUM_SUBSCRIPTION;
                break;
            case "gold":
                subscriptionLocator = Locators.GOLD_SUBSCRIPTION;
                break;
            case "silver":
                subscriptionLocator = Locators.SILVER_SUBSCRIPTION;
                break;
            default:
                throw new IllegalArgumentException("Invalid subscription name: " + subscriptionName);
        }

        WebElement subscriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionLocator));

        // Scroll into view for safety
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscriptionElement);
        wait.until(ExpectedConditions.elementToBeClickable(subscriptionElement));

        subscriptionElement.click();
    }
}
