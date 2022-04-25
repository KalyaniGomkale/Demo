package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class SystemUsersPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();

	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='System Users']")
	WebElement systemUsersTab;
	@FindBy(name = "add-new")
	WebElement addBtn;
	@FindBy(id = "tenantOrgCode")
	WebElement tenantdrpdown;
	@FindBy(id = "fname")
	WebElement fName;
	@FindBy(id = "lname")
	WebElement lName;
	@FindBy(id = "useremail")
	WebElement userMail;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "pswd")
	WebElement pswd;
	@FindBy(id = "confirmPswd")
	WebElement confirmPswd;
	@FindBy(xpath = "//div[contains(text(),'Passwords Mismatch!')]")
	WebElement confirmationError;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement createBtn;
	@FindBy(xpath = "//span[@class='fa fa-refresh']")
	WebElement refreshBtn;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[contains(text(),'User updated successfully')]")
	WebElement editUserMsg;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;

	public SystemUsersPage() {
		PageFactory.initElements(driver, this);
	}
	public void creation(String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd) throws Exception {
		// Click Users Tab
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(systemUsersTab));
		js.executeScript("arguments[0].click();", systemUsersTab);
		// click add new
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		js.executeScript("arguments[0].click();", addBtn);
		log.info("started creating new system admin");
		// Start form
	/*	Select select = new Select(tenantdrpdown);
		select.selectByValue("SYSADMIN");*/
		Thread.sleep(2000);
		fName.sendKeys(FName);
		Thread.sleep(2000);
		lName.sendKeys(LName);
		Thread.sleep(2000);
		userMail.sendKeys(UserMail);
		Thread.sleep(2000);
		userName.sendKeys(UserName);
		Thread.sleep(2000);
		pswd.sendKeys(Pswd);
		Thread.sleep(2000);
		confirmPswd.sendKeys(ConfirmPswd);
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();", createBtn);
	
	}
	public void creatingSystemAdmin(String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd) throws Exception {
		creation(FName,LName,UserMail,UserName,Pswd,ConfirmPswd);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_Msg=alertMessage.getText();
		String expected_Msg=Messages.creationOfUser;
		Assert.assertEquals(actual_Msg,expected_Msg,"User not created");
		Reporter.log("User is created successfully",true);
		Thread.sleep(15000);
		for (int i = 0; i <= 2; i++) {
			String actual_UserName = driver.findElement(By.xpath("//table/tr/td/label[@title='" + UserName + "']"))
					.getText();
			String expected_UserName = UserName;
			System.out.println("Actual Username:" + actual_UserName);
			System.out.println("Expected Username:" + expected_UserName);
			Assert.assertEquals(actual_UserName, expected_UserName, "System Admin can not added in list");
			Reporter.log("System Admin is verified and present in the webtable",true);
			break;
		}
		informationpage.validateSignOut();
	}

	public void creatingSystemAdminWithWrongPswd(String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd) throws Exception {
		creation(FName,LName,UserMail,UserName,Pswd,ConfirmPswd);	
		String errorMsg = confirmationError.getText();
		Reporter.log("Actual message when user both passwords are not same: "+errorMsg,true);
		Assert.assertEquals(errorMsg, Messages.passwordMismatch, "Not getting correct result on password mismatch");
	    Reporter.log("Got correct error when there is mismatch in password",true);
		informationpage.validateSignOut();	
	}

	public void EditSystemUsers(String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd, String NewUserMail) throws Exception {
		creation(FName,LName,UserMail,UserName,Pswd,ConfirmPswd);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_Msg=alertMessage.getText();
		String expected_Msg=Messages.creationOfUser;
		Assert.assertEquals(actual_Msg,expected_Msg,"User not created");
		Reporter.log("User is created successfully",true);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//table/tr/td/label[@title='" + UserName + "']")).click();
		System.out.println("clicking on edit user & editing emailID");
		for (int i = 0; i < 30; i++) {
			userMail.sendKeys(Keys.BACK_SPACE);
		}
		userMail.sendKeys(NewUserMail);
		saveBtn.click();
		String actual_EditUserMsg = editUserMsg.getText();
		String expected_EditUserMsg = Messages.editSystemUser;
		System.out.println("Actual Username:" + actual_EditUserMsg);
		System.out.println("Expected Username:" + expected_EditUserMsg);
		Assert.assertEquals(actual_EditUserMsg, expected_EditUserMsg, "System User details not edited successfully");
		Reporter.log("System User details got edited.",true);
		informationpage.validateSignOut();
	}
	public void validateSystemUsersPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click System Users Tab
		wait.until(ExpectedConditions.visibilityOf(systemUsersTab));
		js.executeScript("arguments[0].click();", systemUsersTab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
