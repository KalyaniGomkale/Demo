package com.ae.qa.pagesTenantAdmin;

import java.util.ArrayList;
import java.util.List;
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
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public TestUtil testutil=new TestUtil();

	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(xpath = "//a[text()='User Groups']")
	WebElement userGroupsTab;
	@FindBy(xpath = "//button[@name='add-cred']/span")
	WebElement addBtn;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement addBtnUG;
	@FindBy(id = "authType")
	WebElement userTypedropdown;
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
	@FindBy(id = "role")
	WebElement roledropdown;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(xpath = "//span[@class='fa fa-refresh']")
	WebElement refreshBtn;
	@FindBy(xpath = "//select[@id='pageSize'][1]")
	WebElement pageNumber;
	@FindBy(xpath = "//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr[2]/td/span[@class='fa fa-edit']")
	WebElement editBtn;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[contains(text(),'User updated successfully')]")
	WebElement editUserMsg;
	@FindBy(id = "gname")
	WebElement groupNameField;
	@FindBy(id = "description")
	WebElement descriptionField;
	@FindBy(xpath = "//*[@name='create']")
	WebElement createBtnUG;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement actual_userGroupMsg;
	@FindBy(id = "change-pswd")
	WebElement changePswdTab;
	@FindBy(id = "oldpswd")
	WebElement oldPswd;
	@FindBy(id = "newpswd")
	WebElement newPswd;
	@FindBy(id = "confirmpswd")
	WebElement newConfirmPswd;
	@FindBy(xpath = "//button[text()='Change']")
	WebElement changeBtn;
	@FindBy(xpath="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//span/span[text()='Select Groups']")
	WebElement AddUserToGroup;
	@FindBy(xpath="//input[@name='search']")
	WebElement searchBar;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement checkGroupName;
	@FindBy(xpath="//select[@formcontrolname='action']")
	WebElement actionDropdown;
	@FindBy(xpath="//button[text()='Next']")
	WebElement nextBtn;
	@FindBy(xpath="//*[@id='pswd']")
	WebElement Pswd;
	@FindBy(xpath="//button[@type='submit']/span")
	WebElement enableBtn;
	@FindBy(xpath="//*[@id='confirmPswd']")
	WebElement confirmPassword;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(name = "dropdown-selector")
	WebElement dropdownSelector;
	@FindBy(xpath = "//span[text()='Upload Users']")
	WebElement uploadUsers;
	@FindBy(xpath ="//select[@id='userType']")
	WebElement userTypeField;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement uploadUsersBtn;
	@FindBy(xpath = "//input[@name='csvFile']")
	WebElement chooseFileBtn;
	public TenantUsersPageTA() {
		PageFactory.initElements(driver, this);
	}
	//Workflow Admin //Tenant Admin //User Admin 
	public void creatingUser(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", tenantUsersTab);
		// click add new
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new " +RoleName,true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select user_type = new Select(userTypedropdown);
		user_type.selectByVisibleText(userType);
		fName.sendKeys(FName);
		Thread.sleep(3000);
		lName.sendKeys(LName);
		Thread.sleep(3000);
		userMail.sendKeys(UserMail);
		Thread.sleep(3000);
		userName.sendKeys(UserName);
		Thread.sleep(3000);
		pswd.sendKeys(Pswd);
		Thread.sleep(3000);
		confirmPswd.sendKeys(ConfirmPswd);
		Thread.sleep(10000);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(RoleName);
		Thread.sleep(5000);
		// create button
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].click();", createBtn);
		Reporter.log(RoleName + " is created successfully",true);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.createUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not created.");
		Reporter.log(RoleName + " created successfully",true);
		informationpageta.validateSignOut();
	}
	//Create Tenant User and edit email ID
	public void valiateCreatingTenantUser(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", tenantUsersTab);
		// click add new
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new Tenant",true);
		// Start form
		// Locating the select dropdown for Tenant
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(5000);		
		Select user_type = new Select(userTypedropdown);
		user_type.selectByVisibleText(userType);
		fName.sendKeys(FName);
		Thread.sleep(3000);
		lName.sendKeys(LName);
		Thread.sleep(3000);
		userMail.sendKeys(UserMail);
		Thread.sleep(3000);
		userName.sendKeys(UserName);
		Thread.sleep(3000);
		pswd.sendKeys(Pswd);
		Thread.sleep(3000);
		confirmPswd.sendKeys(ConfirmPswd);
		Thread.sleep(10000);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(RoleName);
		Thread.sleep(5000);
		/*	AddUserToGroup.click();
		searchBar.sendKeys(groupName);
		Thread.sleep(3000);
		checkGroupName.click();*/
		// create button
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].click();", createBtn);
		Reporter.log("User is created successfully",true);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.createUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not created.");
		Reporter.log(RoleName + " created successfully",true);
		informationpageta.validateSignOut();
	}

	public void ValidateUnverifiedStatus(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		valiateCreatingTenantUser(userType,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		driver.navigate().to(prop.getProperty("url"));
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		WebElement status=driver.findElement(By.xpath("//table/tr/td/div[@title='"+UserName+"']/../../td/button"));
		String Actual_Status=status.getText();
		Reporter.log("Actual Status of New Tenant user is :"+Actual_Status,true);
		String Expected_Status= "UNVERIFIED";
		Reporter.log("Expected Status of New Tenant user is :"+Expected_Status,true);
		Assert.assertEquals(Actual_Status,Expected_Status,"Status of newly created user is not Unverified");
		Reporter.log("Status of newly created user is UNVERIFIED, verified successfully",true);
		informationpageta.validateSignOut();
	}
	public void ValidateActiveStatus(String UserName,String Pswd, String NewPswd) throws Exception {
		loginpageta.ValidateFirstTimeLogin(UserName,Pswd,NewPswd);
		Thread.sleep(5000);
		driver.navigate().to(prop.getProperty("url"));
		loginpageta.login(UserName,NewPswd);
		Reporter.log("User log in Successfully",true);
		informationpageta.validateSignOut();
		Thread.sleep(3000);
		Reporter.log("Login into TA to verify status",true);
		driver.navigate().to(prop.getProperty("url"));
		Thread.sleep(3000);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		WebElement status=driver.findElement(By.xpath("//table/tr/td/div[@title='"+UserName+"']/../../td/button"));
		String Actual_Status=status.getText();
		Reporter.log("Actual Status of Tenant user after changing password is :"+Actual_Status,true);
		String Expected_Status= "ACTIVE";
		Reporter.log("Expected Status of Tenant user after changing password is :"+Expected_Status,true);
		Assert.assertEquals(Actual_Status,Expected_Status,"Status of newly created user is not Active");
		Reporter.log("Status of user whose First time password changed is ACTIVE, verified successfully",true);
		informationpageta.validateSignOut();
	}
	public void valiateEnableLockedUser(String UserName,String action,
			String Password, String ConfirmPswd) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Thread.sleep(2000);
		WebElement lockedBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'LOCKED')]"));
		lockedBtn.click();
		Reporter.log("Locked button clicked");
		Thread.sleep(3000);
		Select select_action=new Select(actionDropdown);
		select_action.selectByValue(action);//UNLOCK
		Thread.sleep(2000);
		nextBtn.click();
		Reporter.log("Action is selected to "+action+" user and next button is clicked",true);
		Thread.sleep(3000);
		Pswd.sendKeys(Password);
		Thread.sleep(2000);
		confirmPassword.sendKeys(ConfirmPswd);
		Thread.sleep(2000);
		enableBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.enableUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not enabled.");
		Reporter.log(UserName+ "enabled successfully",true);
		informationpageta.validateSignOut();	
	}
	public void validateTenantUsersPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
	//To verify upload users with Email Id
	public void bulkUserUploadWithEmail(String userType, String filePath,String tName) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		//Click Dropdown Selector of Add New Button
		wait.until(ExpectedConditions.visibilityOf(dropdownSelector));
		dropdownSelector.click();
		Reporter.log("Dropdown Selector button is selected",true);
		Thread.sleep(5000);
		//Clicking on Upload Users from the Dropdown list
		wait.until(ExpectedConditions.visibilityOf(uploadUsers));
		js.executeScript("arguments[0].click();", uploadUsers);
		//Selecting the Native type users
		Select userTypr_dropDown=new Select(userTypeField);
		userTypr_dropDown.selectByValue(userType);
		Reporter.log("Native Users is Selected",true);
		Thread.sleep(5000);
		//Clicking on Choose File Button and uploading the file
		chooseFileBtn.sendKeys(filePath);
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Click on Upload Users Button
		uploadUsersBtn.click();
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Again Clicking on Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		Thread.sleep(5000);
		webelements.AdvanceSearchField("userName", "eq", tName);
		Reporter.log("Below validation is to validate new tenant record is visible in webtable",true);
		String actual_TenantName = driver.findElement(By.xpath("//table/tr/td/div[text()='" + tName + "']")).getText();
		String expected_TenantName = tName;
		System.out.println("Actual:"+actual_TenantName+"Expected:"+expected_TenantName);
		Assert.assertEquals(actual_TenantName, expected_TenantName, "Tenant can not added in list");
		Reporter.log("New Tenant User is present in the table-Validated successfully",true);
		Thread.sleep(5000);
		informationpageta.validateSignOut();
		loginpageta.ValidateFirstTimeLogin(prop.getProperty("username_NU"),prop.getProperty("FT_password_NU"),prop.getProperty("password_NU"));
		Thread.sleep(5000);
		loginpageta.login(prop.getProperty("username_NU"),prop.getProperty("password_NU") );
		Thread.sleep(5000);
		String actual_successMsg = driver.findElement(By.xpath("//div/span[1][text()='"+ tName +"']")).getText();	
		String expected_successMsg = prop.getProperty("username_NU");
		System.out.println("Actual Name of the Tenant User:-" +actual_successMsg);
		System.out.println("Expected Name of the Tenant User:-"+expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"Username does not match");
		informationpageta.validateSignOut();
	}
	//To verify upload users without Email Id
	public void bulkUserUploadWithoutEmail(String userType, String filePath, String tName) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		//Click Dropdown Selector of Add New Button
		wait.until(ExpectedConditions.visibilityOf(dropdownSelector));
		dropdownSelector.click();
		Reporter.log("Dropdown Selector button is selected",true);
		Thread.sleep(5000);
		//Clicking on Upload Users from the Dropdown list
		wait.until(ExpectedConditions.visibilityOf(uploadUsers));
		js.executeScript("arguments[0].click();", uploadUsers);
		//Selecting the Native type users
		Select userTypr_dropDown=new Select(userTypeField);
		userTypr_dropDown.selectByValue(userType);
		Reporter.log("Native Users is Selected",true);
		Thread.sleep(5000);
		//Clicking on Choose File Button and uploading the file
		chooseFileBtn.sendKeys(filePath);
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Click on Upload Users Button
		uploadUsersBtn.click();
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Again Clicking on Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		Thread.sleep(5000);
		webelements.AdvanceSearchField("userName", "eq", tName);
		Reporter.log("Below validation is to validate new tenant record is visible in webtable",true);
		String actual_TenantName = driver.findElement(By.xpath("//table/tr/td/div[text()='" + tName + "']")).getText();
		String expected_TenantName = tName;
		System.out.println("Actual:"+actual_TenantName+"Expected:"+expected_TenantName);
		Assert.assertEquals(actual_TenantName, expected_TenantName, "Tenant can not added in list");
		Reporter.log("New Tenant User is present in the table-Validated successfully",true);
		informationpageta.validateSignOut();
		Thread.sleep(5000);
		loginpageta.ValidateFirstTimeLogin(prop.getProperty("username_NU1"),prop.getProperty("FT_password_NU1"),prop.getProperty("password_NU1"));
		Thread.sleep(5000);
		loginpageta.login(prop.getProperty("username_NU1"),prop.getProperty("password_NU1") );
		Thread.sleep(5000);
		String actual_successMsg = driver.findElement(By.xpath("//div/span[1][text()='"+ tName +"']")).getText();	
		String expected_successMsg = prop.getProperty("username_NU1");
		System.out.println("Actual Name of the Tenant User:-" +actual_successMsg);
		System.out.println("Expected Name of the Tenant User:-"+expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"Username does not match");
		informationpageta.validateSignOut();
	}

}
