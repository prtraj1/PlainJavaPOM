package com.qs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	private WebDriver driver= null;
	@FindBy(xpath="//p[@class='home_page_heading']")
	private WebElement homePageHeading;
	
	@FindBy(id="user_icon_not_login")
	private WebElement signinbtn;
	
	public boolean verifyLandingPageHeading() {
		boolean result= false;
		result= homePageHeading.isDisplayed();
		return result;
	}
	
	public LoginPage clickLogin() {
		signinbtn.click();
		return new LoginPage(driver);
	}
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
