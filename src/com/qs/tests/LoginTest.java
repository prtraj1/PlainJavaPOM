package com.qs.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qs.pages.HomePage;
import com.qs.pages.LandingPage;
import com.qs.pages.LoginPage;

public class LoginTest {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/tantraadmin/browserdrivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://staging-beta.qsleap.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void loginTest() {
		LandingPage lan= new LandingPage(driver);
		LoginPage lp=lan.clickLogin();
		lp.setUsername("discover.prithvi+40");
		lp.setPassword("qwer1234");
		HomePage hp=lp.clickLogin();
		boolean res=hp.verifyProfileNameVisible();
		Assert.assertTrue(res, "Profile name was not visible");
		
	}
	
	@Test
	public void logoutTest() {
		HomePage hp= new HomePage(driver);
		LandingPage lanp=hp.logOut();
		boolean res=lanp.verifyLandingPageHeading();
		Assert.assertTrue(res, "Landing page paragraph not visible");
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	

}
