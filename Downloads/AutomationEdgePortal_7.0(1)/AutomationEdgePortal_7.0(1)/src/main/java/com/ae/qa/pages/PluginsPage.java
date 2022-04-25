package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class PluginsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 180);
	public LoginPage loginpage = new LoginPage();
	public WebElements webelements = new WebElements();
	public InformationPage informationpage=new InformationPage();

	@FindBy(xpath = "//span[(text()='Plugins')]")
	WebElement pluginsTab;
	@FindBy(name = "upload-zip")
	WebElement uploadZipBtn;
	@CacheLookup
	@FindBy(id = "pluginsFile")
	WebElement chooseFile;
	@FindBy(xpath = "//input[@id='pluginsFile']")
	WebElement chooseFileFromLocation;
	@FindBy(id = "uploadButton")
	WebElement uploadBtn;
	@FindBy(id = "select-all")
	WebElement upgradeAllBox;
	@FindBy(id = "select-all-assignment")
	WebElement assignAllBox;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath = "//table/tr[2]/td[5]/span")
	WebElement licenseStatus;
	@FindBy(xpath="//button[@name='dropdown-selector']")
	WebElement uploadDropdown;
	@FindBy(xpath="//span[text()='New Plugin']")
	WebElement newPlugin;
	@FindBy(xpath="//input[@id='pluginsFile']")
	WebElement uploadJar;
	@FindBy(id="uploadButton")
	WebElement uploadSingeJarBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	
	public PluginsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validateUploadPlugins() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		// Click Upload zip button
		wait.until(ExpectedConditions.visibilityOf(uploadZipBtn));
		js.executeScript("arguments[0].click();", uploadZipBtn);
		Reporter.log("Upload zip button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		chooseFileFromLocation.sendKeys(prop.getProperty("uploadPluginFile"));
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Plugin zip started uploading",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", upgradeAllBox);
		Reporter.log("Upgrade all plugin checkbox is selected",true);
		Thread.sleep(1000);
		assignAllBox.click();
		Reporter.log("Assign to all checkbox is selected",true);
		Thread.sleep(1000);
		saveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(6000);
		informationpage.validateSignOut();
	}
	public void validateUploadSinglePlugins(String uploadJarFile) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		Thread.sleep(3000);
		uploadDropdown.click();
		Thread.sleep(1000);
		newPlugin.click();
		Reporter.log("New Plugin button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		uploadJar.sendKeys(uploadJarFile);
		Thread.sleep(3000);
		uploadSingeJarBtn.click();
		Reporter.log("Single Plugin Jar started uploading",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg =Messages.singlePluginUpload;
		System.out.println("actual success msg is: " + actual_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Single Plugin not uploaded.");
		Reporter.log("Single plugin jar uploaded successfully");
		informationpage.validateSignOut();
	}
	public void validatePluginsPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
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
