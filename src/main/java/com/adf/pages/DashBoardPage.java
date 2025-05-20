package com.adf.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage 
{
	WebDriver driver;
    WebDriverWait wait;

    
    private By accountDropdown = By.xpath("//a[@class='dropdown profile top-head-link']");
    private By DropdownOptions = By.xpath("(//ul[@id='drop1']//li)[12]");

    		
     public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    public void clickAccount()
    {
    	WebElement accountEle=wait.until(ExpectedConditions.elementToBeClickable(accountDropdown));
    	accountEle.click();
    }
    
    public void DisplayDropdownAndClickLogout()
    {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DropdownOptions));
        System.out.println("Dropdown option count: " + options.size());

        for (WebElement option : options)
        {
            String text = option.getText();
            System.out.println("Option: " + text);

            if (text.equals("Logout"))
            {
                option.click();
                break;
            }
        }
    }


}

