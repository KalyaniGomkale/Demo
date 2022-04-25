package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class EmailNotificationPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	
	@FindBy(xpath = "//span[text()='Settings']")
	WebElement settingsTab;
	@FindBy(xpath = "//a[text()='Email Notification']")
	WebElement emailNotificationTab;
	@FindBy(xpath="//h1")
	WebElement actual_error;
	@FindBy(xpath="//table/tr/th")
	WebElement notificationTable;
	//table/tr[5]/td[2]/label
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	
	public EmailNotificationPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateEmailNotfSMTPNotConfig() throws Exception {
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Reporter.log("Settings Tab is clicked",true);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", emailNotificationTab);
		Reporter.log("Email Notifications Tab is clicked",true);
		Thread.sleep(3000);
		String actual_errorMessage=actual_error.getText();
		Reporter.log("When SMTP is not configured for TA and he tries to set email notification,"
				+ " in this case he will get error as: "+actual_errorMessage,true);
		String expected_errorMessage="Not Configured";
		Assert.assertEquals(actual_errorMessage, expected_errorMessage,"Getting incorrect error message");
		Reporter.log("Getting correct error when SMTP not configured and user try to do SMTP settings");
		informationpageta.validateSignOut();
	}
	//Test case when SMTP Is configured-we will check if Current Agent Status is present in table or not 
	public void validateEnailNotfSMTPConf() throws Exception{
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Reporter.log("Settings Tab is clicked",true);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", emailNotificationTab);
		Reporter.log("Email Notifications Tab is clicked",true);
		Thread.sleep(3000);
		Boolean flag= notificationTable.isDisplayed();
		if(flag) {
			Assert.assertTrue(flag);
			Reporter.log("Email notification table is visible after SMTP configuration",true);
		}else {
			Assert.assertTrue(flag);
			Reporter.log("Email notification table is not visible after SMTP Configured",true);
		}
	}
	public void validateEmailNotificationPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",emailNotificationTab);
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
