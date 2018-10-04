package com.supportSearch.support_search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject {

	@FindBy(id = "as-search-input")
	private WebElement searchInput;

	@FindBy(id = "yes-button")
	private WebElement yesbutton;

	@FindBy(id = "rating-done")
	private WebElement rating;

	@FindBy(id = "filter-view-button")
	private WebElement filterViewButton;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void search() {
		WebElement searchbox = this.searchInput;
		// enter text "iphone battery" in search box
		searchbox.sendKeys("iphone battery");
		// press enter
		searchbox.sendKeys(Keys.ENTER);
	}

	public void filter() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement filter = this.filterViewButton;
		filter.click();
	}

	public void clickYesBtn() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement yes_btn = this.yesbutton;
		Thread.sleep(3000);
		yes_btn.click();
	}
}
