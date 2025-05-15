package com.adf.pages;

import org.openqa.selenium.By;

public class Locators {

    // HomePage locators
    public static final By OUR_PRODUCTS_LINK = By.xpath("//span[normalize-space()='Our Products']");
    public static final By PLATINUM_SUBSCRIPTION = By.xpath("//a[@href='/Products/Memberships/platinum']");
    public static final By GOLD_SUBSCRIPTION = By.xpath("//a[@href='/Products/Memberships/gold']");
    public static final By SILVER_SUBSCRIPTION = By.xpath("//a[@href='/Products/Memberships/silver']");

    // PlatinumMembershipPage locators
    public static final By SPECIALTY_DROPDOWN = By.xpath("//div[contains(text(), 'Select a Specialty')]");

    // Dynamic locators for Specialty options
    public static By specialtyOption(String specialtyName) {
        return By.xpath("//li[contains(text(), '" + specialtyName + "')]");
    }
}
