package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;

public class IPWhitelistingPageTA extends TestBase{
	  public LoginPageTA loginpage = new LoginPageTA();
	  public static WebDriverWait wait = new WebDriverWait(driver, 300);
	  public InformationPageTA informationpageta=new InformationPageTA();
	  
	  @FindBy(xpath="//span[text()='Agents']")
	  WebElement AgentsTab;
	  @FindBy(xpath="//a[text()='IP Whitelisting']")
	  WebElement IPWhitelistingTab;
	  @FindBy(xpath="//div[@class='title-div']/h2")
	  WebElement pageTitle;
	  
	  public IPWhitelistingPageTA()
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
		public void validateIPWhitelistingPageTA(String PageTitle) throws Exception {
			loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
			Reporter.log("User log in Successfully",true);
			//First search for tab and click on it
			wait.until(ExpectedConditions.visibilityOf(AgentsTab));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", AgentsTab);
			js.executeScript("arguments[0].click();", IPWhitelistingTab);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//Now validate page title is same as expected
			String actual_title=pageTitle.getText();
			String expected_title=PageTitle;
			Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
							+ "page title is: "+expected_title,true);
			Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
			Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
			informationpageta.validateSignOut();
		}
}
