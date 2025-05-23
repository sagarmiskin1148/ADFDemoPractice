package com.adf.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryPage
{

	WebDriver driver;
    WebDriverWait wait;
	
	
	private By libraryfeature = By.xpath("//a[span[text()='Library']]");
    private By libraryselectSpecalitydropdown = By.xpath("(//a[text()='select'])[1]");
    private By selectAnesthesiology = By.xpath("(//div//ul)[1]//li[text()='Anesthesiology']");
    

    public LibraryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    
    }
    
    
    public void clicklibrary()
    {
    	WebElement libEle=wait.until(ExpectedConditions.elementToBeClickable(libraryfeature));
    	libEle.click();
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    	WebElement libraryDD=wait.until(ExpectedConditions.elementToBeClickable(libraryselectSpecalitydropdown));
    	libraryDD.click();
    	
    	

    	WebElement selectAnths=wait.until(ExpectedConditions.elementToBeClickable(selectAnesthesiology));
    	selectAnths.click();
    	
    	
    }
    
    
}
