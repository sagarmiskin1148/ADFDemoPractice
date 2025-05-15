package com.adf.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PlatinumMembershipPage {

    WebDriver driver;

    public PlatinumMembershipPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSpecialty(String specialtyName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SPECIALTY_DROPDOWN));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);

        Thread.sleep(1000); // Stability pause, can try removing later
        dropdown.click();

        By option = Locators.specialtyOption(specialtyName);
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(option));
        optionElement.click();
    }
}
