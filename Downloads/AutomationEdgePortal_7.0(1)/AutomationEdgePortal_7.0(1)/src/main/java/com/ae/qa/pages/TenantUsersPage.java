package com.ae.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.Reporter;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class TenantUsersPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();

	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(xpath = "//button[@name='add-cred']/span")
	WebElement addBtn;
	@FindBy(xpath = "//ae-multiselect[@id='tenantOrgCode']")
	WebElement tenantdropdown;
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
	// @FindBy(id="role")
	@FindBy(id = "role")
	WebElement roledropdown;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(xpath = "//span[@class='fa fa-refresh']")
	WebElement refreshBtn;
	@FindBy(xpath = "//select[@id='pageSize'][1]")
	WebElement pageNumber;
	//@FindBy(xpath = "//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr[2]/td/span[@class='fa fa-edit']")
	//WebElement editBtn;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[contains(text(),'User updated successfully')]")
	WebElement editUserMsg;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;

	public TenantUsersPage() {
		PageFactory.initElements(driver, this);
		// this.driver=driver;
	}

	public void creatingTenantUser(String tenantOrgCode, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		// click add new
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		js.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new Tenant",true);
		// Start form 
		//Locating the select dropdown for Tenant
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		tenantdropdown.click();
		Thread.sleep(3000);
		WebElement select_tenant=driver.findElement(By.xpath("//div[@id='options-list']/li/label[contains(text(),'"+tenantOrgCode+"')]/span"));
		select_tenant.click();
		Thread.sleep(3000);
		tenantdropdown.click();
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
		Thread.sleep(2000);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(RoleName);
		Thread.sleep(5000);
		// create button
		js.executeScript("arguments[0].click();", createBtn);
		//Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_Msg=alertMessage.getText();
		String expected_Msg=Messages.creationOfUser;
		Assert.assertEquals(actual_Msg,expected_Msg,"User not created");
		Reporter.log("User is created successfully",true);
		//one more validation if created user is displayed in table
		Thread.sleep(5000);
		for (int i = 0; i <= 3; i++) {
			String actual_UserName = driver
					.findElement(By.xpath("//table/tr/td/div[contains(@title,'" + UserName + "')]")).getText();
			String expected_UserName = UserName;
			System.out.println("Actual Username:" + actual_UserName);
			System.out.println("Expected Username:" + expected_UserName);
			Assert.assertEquals(actual_UserName, expected_UserName, "New user can not added in list");
			Reporter.log("New user is verified and present in the webtable",true);
			break;
		}
		informationpage.validateSignOut();
	}

	public void EditTenantUser(String tenantOrgCode, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String NewUserMail)throws Exception {
		creatingTenantUser(tenantOrgCode,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
	//	editBtn.click();
		WebElement editBtn=driver.findElement(By.xpath("//div[@class='table-responsive']/table/tr/td/div[@title='"+UserName+"']/../../td/span[@title='Edit User']"));
		editBtn.click();
		Thread.sleep(2000);
		for (int i = 0; i < 30; i++) {
			userMail.sendKeys(Keys.BACK_SPACE);
		}
		userMail.sendKeys(NewUserMail);
		saveBtn.click();
		String actual_EditUserMsg = editUserMsg.getText();
		String expected_EditUserMsg = Messages.editUser;
		System.out.println("Actual Username:" + actual_EditUserMsg);
		System.out.println("Expected Username:" + expected_EditUserMsg);
		Assert.assertEquals(actual_EditUserMsg, expected_EditUserMsg, "Tenant User details not edited successfully");
		Reporter.log("Tenant User details got edited.",true);
		informationpage.validateSignOut();
	}
	public void validateTenantUsersPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click System Users Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();",tenantUsersTab);
		Thread.sleep(6000);
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
