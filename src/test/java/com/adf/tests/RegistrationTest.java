package com.adf.tests;

import com.adf.base.BaseClass;
import com.adf.pages.HomePage;
import com.adf.pages.PlatinumMembershipPage;
import com.adf.utils.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseClass {

    @BeforeMethod
    public void setUp() {
        initializeDriver();  
    }

    @Test
    public void registerAndPurchaseProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOurProducts();

        homePage.scrollAndClickSubscription(Constants.Subscription.PLATINUM);

        PlatinumMembershipPage platinumPage = new PlatinumMembershipPage(driver);
        platinumPage.selectSpecialty(Constants.Specialty.ANESTHESIOLOGY);

        System.out.println("Specialty selected and Page Title: " + driver.getTitle());
    }

    /*
    @AfterMethod
    public void tearDown() {
        tearDownDriver();
    }
    */
}
