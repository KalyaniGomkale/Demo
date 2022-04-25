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
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class AboutTabTA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 120);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();

	@FindBy(xpath = "//div[@id='login-username']")
	WebElement loginUsername;
	@FindBy(xpath = "//a[@name='about']")
	WebElement aboutTab;
	@FindBy(xpath = "(//table[@class='table shadow-none table-bordered mt-4']/tr/td)[2]")
	WebElement uiVersion;
	@FindBy(xpath = "(//table[@class='table shadow-none table-bordered mt-4']/tr/td)[4]")
	WebElement serverVersion;
	@FindBy(xpath = "(//table[@class='table shadow-none table-bordered mt-4']/tr/td)[6]")
	WebElement supportedFrameworkVersion;
	@FindBy(xpath = "(//button[@name='close'])[1]")
	WebElement closeBtn;
	@FindBy(xpath = "//div[@id='login-username']")
	WebElement UserNameTab;
	@FindBy(id = "change-logo")
	WebElement setLogoTab;
	@FindBy(id = "logoinput")
	WebElement chooseFile;
	@FindBy(xpath = "//label[@id='logoinput']/input")
	WebElement chooseFileFromDesk;
	@FindBy(name = "set-logo")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg_logo;
	@FindBy(name="sign-out")
	WebElement signOutBtn;



	public AboutTabTA() {
		PageFactory.initElements(driver, this);
	}
	//To verify the about tab
	public void aboutTab(String UIVersion, String ServerVersion, String SupportedFrameworkVersions ) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click on Profile Icon
		wait.until(ExpectedConditions.visibilityOf(loginUsername));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",loginUsername );
		Reporter.log("Profile Icon is clicked",true);
		Thread.sleep(5000);
		//Click on About tab
		wait.until(ExpectedConditions.visibilityOf(aboutTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();",aboutTab);
		Reporter.log("About Tab is clicked",true);
		Thread.sleep(6000);
		//Assertion for UI Version
		String actual_successMsg = uiVersion.getText();
		String expected_successMsg = UIVersion;
		System.out.println("UI Version:-" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"UI Version Does Not Match");
		//Assertion for Server Version
		String actual_successMsg1 = serverVersion.getText();
		String expected_successMsg1 = ServerVersion;
		System.out.println("Server Version:-" + actual_successMsg1);
		Assert.assertEquals(actual_successMsg1, expected_successMsg1,"Server Version Does Not Match");
		//Assertion for UI Version
		String actual_successMsg2 = supportedFrameworkVersion.getText();
		String expected_successMsg2 = SupportedFrameworkVersions;
		System.out.println("Supported Framework Version:-" + actual_successMsg2);
		Assert.assertEquals(actual_successMsg2, expected_successMsg2,"Supported Framework Versions Does Not Match");
		//Clicking on Close Button
		wait.until(ExpectedConditions.visibilityOf(closeBtn));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();",closeBtn);
		Reporter.log("Close Button is clicked",true);
		informationpageta.validateSignOut();
		Thread.sleep(5000);		
	}
	//To change the tenant logo
	public void changeTenantLogo() throws Exception {
		informationpageta.setTenantLogo();
	}
	

}
