package com.qs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver= null;
	private WebDriverWait wait;
	
	@FindBy(xpath="//div[@class='profile-name']/h1")
	private WebElement profilename;
	
	@FindBy(xpath="//span[contains(@class,'glyphicon-menu-down')]/preceding-sibling::div")
	private WebElement userdropdown;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logoutlink;
	
	public boolean verifyProfileNameVisible() {
		boolean result= false;
		result= profilename.isDisplayed();
		return result;
	}
	
	public LandingPage logOut() {
		userdropdown.click();
		wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(logoutlink));
		logoutlink.click();
		return new LandingPage(driver);
	}
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
