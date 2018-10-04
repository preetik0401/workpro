package com.supportSearch.support_searchWithoutPageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SupportSearchTest {
	public WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		 driver = new SafariDriver();
	}
	
	@Test(priority=1)
	public void openPage() {
		 driver.get("https://support.apple.com/");
	}
	
	@Test(priority=2)
	public void search() {
		
		WebElement searchbox = driver.findElement(By.id("as-search-input"));
  	  //enter text "iphone battery" in search box
  	   searchbox.sendKeys("iphone battery");  	   
  	   //press enter
  	   searchbox.sendKeys(Keys.ENTER);
	}
	
	@Test(priority=3)
	public void filter() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement filter = driver.findElement(By.id("filter-view-button"));
  	     filter.click();
	}
	
	@Test(priority=4)
	public void supportArticle() {
		
		WebElement support_article = driver.findElement(By.xpath("//*[contains(text(),'Support Articles')]"));
 	    support_article.click();
	}
	
	@Test(priority=5)
	public void iphoneBatteryText() {
		String expectedText = "iPhone Battery and Performance"; 
		WebElement iphone_battery_text = driver.findElement(By.xpath("//*[contains(text(),'iPhone Battery and Performance')]"));
 	    String actualText=iphone_battery_text.getText();
		Assert.assertEquals(actualText,expectedText);
		iphone_battery_text.click();
	}
	
	@Test(priority=6)
	public void clickYesBtn() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 WebElement yes_btn = driver.findElement(By.id("yes-button"));
    	 	 Thread.sleep(3000);  
    	     yes_btn.click();
    	     
	}
	
	@Test(priority=7)
	public void thankYouText() {
		WebElement thankYou = driver.findElement(By.id("rating-done"));
   	 thankYou.isDisplayed();
		String expectedText = "Thanks for your feedback."; 
		 String actualText=thankYou.getText();
		Assert.assertEquals(actualText,expectedText);
	}
	@AfterTest
	public void afterTest() {
	driver.close();
	}
}
