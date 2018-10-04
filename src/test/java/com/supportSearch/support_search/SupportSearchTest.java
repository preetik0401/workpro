package com.supportSearch.support_search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SupportSearchTest extends FunctionalTest {

	SearchPage page = null;

	@Test(priority = 1)
	public void openPage() {
		driver.get("https://support.apple.com/");
		page = new SearchPage(driver);
	}

	@Test(priority = 2)
	public void searchPage() {
		page.search();
	}

	@Test(priority = 3)
	public void filter() {
		page.filter();
	}

	@Test(priority = 4)
	public void supportArticle() {

		WebElement support_article = driver.findElement(By.xpath("//*[contains(text(),'Support Articles')]"));
		support_article.click();
	}

	@Test(priority = 5)
	public void iphoneBatteryText() {
		String expectedText = "iPhone Battery and Performance";
		WebElement iphone_battery_text = driver
				.findElement(By.xpath("//*[contains(text(),'iPhone Battery and Performance')]"));
		String actualText = iphone_battery_text.getText();
		Assert.assertEquals(actualText, expectedText);
		iphone_battery_text.click();
	}

	@Test(priority = 6)
	public void clickYesBtn() throws InterruptedException {

		page.clickYesBtn();

	}

	@Test(priority = 7)
	public void thankYouText() {
		WebElement thankYou = driver.findElement(By.id("rating-done"));
		thankYou.isDisplayed();
		String expectedText = "Thanks for your feedback.";
		String actualText = thankYou.getText();
		Assert.assertEquals(actualText, expectedText);
	}

}
