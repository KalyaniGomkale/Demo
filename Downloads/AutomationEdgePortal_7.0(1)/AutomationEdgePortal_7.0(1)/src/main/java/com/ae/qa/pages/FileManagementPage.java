package com.ae.qa.pages;

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
import com.ae.qa.util.Messages;

public class FileManagementPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 220);
	public LoginPage loginpage = new LoginPage();
	public WebElements webelements = new WebElements();
	public InformationPage informationpage=new InformationPage();
	

	@FindBy(xpath = "//span[(text()='File Management')]")
	WebElement fileManagmentTab;
	@FindBy(xpath = "//button[@name='new-req']")
	WebElement uploadBtn;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement plugindropdown;
	@FindBy(xpath = "//input[@formcontrolname='search']")
	WebElement searchBar;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement PluginCheckbox;
	@FindBy(xpath = "//input[@formcontrolname='file']")
	WebElement chooseFile;
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement success_Message;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public FileManagementPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validateUploadDriver(String pluginName) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click File Management Tab
		wait.until(ExpectedConditions.visibilityOf(fileManagmentTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",fileManagmentTab);
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Upload Button is clicked",true);
		plugindropdown.click();
		Thread.sleep(3000);
		searchBar.sendKeys(pluginName);
		Thread.sleep(3000);
		PluginCheckbox.click();
		Reporter.log("Plugin Name is selected",true);
		Thread.sleep(3000);
		chooseFile.sendKeys(prop.getProperty("ChromeDriverFile"));
		Thread.sleep(3000);
		submitBtn.click();
		Reporter.log("Submit button is clicked",true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = Messages.fileUpload;
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Chrome driver not uploaded");
		Reporter.log("Chrome driver uploaded successfully",true);
		informationpage.validateSignOut();
	}
	public void validateFileManagmentPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click File Management Tab
				wait.until(ExpectedConditions.visibilityOf(fileManagmentTab));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",fileManagmentTab);
				Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}

}
