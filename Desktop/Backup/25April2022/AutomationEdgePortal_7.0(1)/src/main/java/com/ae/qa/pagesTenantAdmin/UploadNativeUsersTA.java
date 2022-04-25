package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.TestUtil;

public class UploadNativeUsersTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	
	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(name = "dropdown-selector")
	WebElement dropdownSelector;
	@FindBy(xpath = "//span[normalize-space()='Upload Users']")
	WebElement uploadUsers;
	@FindBy(xpath = "//button[@name='down-sample']")
	WebElement sampleTemplateBtn;
	@FindBy(xpath ="//select[@id='userType']")
	WebElement userTypeField;
	@FindBy(xpath = "//input[@id='csvFile']")
	WebElement chooseFileBtn;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement uploadUsersBtn;
	@FindBy(xpath = "//button[@type='button'][normalize-space()='Cancel']")
	WebElement cancelBtn;
	public UploadNativeUsersTA() {
		PageFactory.initElements(driver, this);
	}

	public void bulkUserUpload(String userType) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Thread.sleep(3000);
		// Click TenantUsers Tab
	//	wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));	
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Thread.sleep(3000);
		//Click Dropdown Selector of Add New Button
		wait.until(ExpectedConditions.visibilityOf(dropdownSelector));
		dropdownSelector.click();
		Reporter.log("Dropdown Selector button is selected",true);
		Thread.sleep(5000);
		//Clicking on Upload Users from the Dropdown list
		wait.until(ExpectedConditions.visibilityOf(uploadUsers));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", uploadUsers);
		//Selecting the Native type users
		userTypeField.click();
		Reporter.log("User type field is clicked",true);
		Thread.sleep(5000);
		Select userTypr_dropDown=new Select(userTypeField);
		userTypr_dropDown.selectByValue(userType);
		//Clicking on Choose File Button and uploading the file
		chooseFileBtn.sendKeys("F:\\Automation Edge Project\\Bulk Users\\Bulk Users 1.csv");
		Reporter.log("Choose File button is selected and file is uploaded",true);
		Thread.sleep(5000);
	}






}
