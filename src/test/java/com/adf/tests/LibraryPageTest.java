package com.adf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.adf.base.BaseClass;

public class LibraryPageTest extends BaseClass {

    @Test
    public void clicklibrary() {
   Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed or title mismatch!");

   libraryPage.clicklibrary();
        
    }
}
