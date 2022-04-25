package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;

public class HomePage extends TestBase {
	public LoginPage loginpage = new LoginPage();
	public WebDriverWait wait = new WebDriverWait(driver, 60);
	public InformationPage informationpage=new InformationPage();
	
	
	@FindBy(xpath="//*[@id='menu-search']/input")
	WebElement searchMenu;
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateSearchFunctionality(String TabName) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(3000);
		searchMenu.sendKeys(TabName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual_tabname=driver.findElement(By.xpath("//*[text()='"+TabName+"']")).getText();
		String expected_tabname=TabName;
		Reporter.log("User searched for functionality: "+TabName+" and Found is: "+actual_tabname,true);
		Assert.assertEquals(actual_tabname, expected_tabname,"Search functionality did'nt work properly");
		Reporter.log("Search Functionality working properly",true);
		informationpage.validateSignOut();
	}
}
