package com.ae.qa.pagesTenantAdmin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;
import com.ae.qa.util.TestUtil;

public class AgentListPageTA extends TestBase{

	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA informationpageta=new InformationPageTA();
	public CataloguePageTA catalogueta=new CataloguePageTA();

	@FindBy(xpath="//span[text()='Agents']")
	WebElement AgentsTab;
	@FindBy(xpath="//a[text()='Workflow Assignment']")
	WebElement WorkflowAssignmentTab;
	@FindBy(xpath="//div[@class='agent-assign-desktop']/div/div/label")
	WebElement agentNotReg;
	@FindBy(xpath="//a[text()='Agent List']")
	WebElement AgentListTab;
	@FindBy(id = "download-agent")
	WebElement downloadAgentBtn;
	@FindBy(xpath="//*[@name='delete-agent']/span")
	WebElement downloadBtn;
	@FindBy(xpath="//*[@id='177']/div/span[3]")
	WebElement successMsgBox;
	@FindBy(xpath="//button[@name='refresh-btn']")
	WebElement refreshTable;
	@FindBy(xpath="//table[@id='agentTable']/tr[3]/td[5]/span")
	WebElement status;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement showColumnDrpdown;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']/div")
	WebElement columnCount;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(id ="btnAssisted")
	WebElement AssistedAgentTab;
	@FindBy(id ="assisted")
	WebElement assignToUserTab;
	@FindBy(xpath ="(//div/div/div/input)[2]")
	WebElement searchBar;
	@FindBy(xpath ="//button[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath ="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath ="//button[text()='Stop']")
	WebElement confirmStopBtn;
	@FindBy(xpath ="//button[text()='Delete']")
	WebElement confirmDeleteBtn;
	@FindBy(xpath = "//h2[text()='Assisted Agents']")
	WebElement assistedAgentPageTitle;
	@FindBy(xpath="//*[@id='menu-search']/input")
	WebElement searchMenu;
	@FindBy(xpath="//button[@title='Edit Agent']")
	WebElement editBtn;
	@FindBy(xpath="//input[@id='agentName']")
	WebElement agentName;
	
	public AgentListPageTA()
	{
		PageFactory.initElements(driver, this);
	}

	public void downloadAgent() throws Exception
	{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		//Verify when user try to assign wf without registering agent
		js.executeScript("arguments[0].click();", WorkflowAssignmentTab);	
		Reporter.log("User navigated to workflow assignment Tab",true);
		Thread.sleep(3000);
		String expected_agentNotRegError=agentNotReg.getText();
		Reporter.log("When Agent is not registered and user try to assign workflow to agent then get error message as: "+expected_agentNotRegError,true);
		String actual_agentNotRegError = "No agent registered";
		Assert.assertEquals(actual_agentNotRegError, expected_agentNotRegError,"Not getting correct error in Workflow assignment Tab");
		Reporter.log("Getting correct error when user didnt register agent & try to assign workflow");
		Thread.sleep(2000);
		Reporter.log("Now User needs to download agent first",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agent List Tab",true);
		downloadAgentBtn.click();
		Thread.sleep(3000);
		downloadBtn.click();
		Reporter.log("Agent download started",true);
		Thread.sleep(100000);
		TestUtil.unzip(prop.getProperty("zipFilePath"),prop.getProperty("destDir"));
		Reporter.log("File unzipped properly",true);
		//ProcessBuilder pb= new ProcessBuilder(prop.getProperty("AgentRegBatFile"));
		//Process process= pb.start();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
		//StringBuilder sb=new StringBuilder();
		//  String line;
		/*  while((line = reader.readLine()) != null) {
				  sb.append(line + "\n");
				  }*/
		//  System.out.println(sb);
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "AgentRun.bat");
		File dir = new File(prop.getProperty("AgentRegBatFilePath"));
		pb.directory(dir);
		Process p = pb.start();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		//  driver.quit();
	}

	public void checkStatusOfAgent() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(8000);
		for(int i=0;i<3;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Agent is in running mode",true);
		informationpageta.validateSignOut();
	}
	public void checkColumnsInAgentList() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		Assert.assertEquals(sizeOfColumnsInt, 7, "All columns not selected");
		Reporter.log("All Column got displayed in records after Checking select All checkbox.",true);
		informationpageta.validateSignOut();
	}
	public void deselectAllInAgentListTA() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.",true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.",true);
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);//3
		Reporter.log("Selected count of No. of colums " + sizeOfColumnsInt,true);//3
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th/span"));
		Reporter.log("Total No of columns in table: " + TotalColumn.size(),true);
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Agent Name") || value.contains("Status") || value.contains("Resource Utilization")) {
			Reporter.log("Column Value found",true);
			Assert.assertEquals(sizeOfColumnsInt, 3, "All columns are not deselected. ");
			Reporter.log("All Options got deselected except Agent Name,Status and Resource Utilization.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}
	public void SpecificColumnInAgentList() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.",true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
				Thread.sleep(3000);
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.",true);

		}
		// select 2 more columns
		driver.findElement(By.xpath("//a/span[text()='Agent Type']")).click();
		driver.findElement(By.xpath("//a/span[text()='Executing Workflows']")).click();
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th/span"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Agent Name") && value.contains("Execution Threads") && value.contains("Resource Utilization")
				&& value.contains("Status") && value.contains("Executing Workflows")) {
			Reporter.log("Column Value found",true);
			Assert.assertTrue(true);
			Assert.assertEquals(sizeOfColumnsInt, TotalColumn.size(), "All columns selected not found in table.");
			Reporter.log("All columns selected found in table.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}
	public void downloadAssistedAgent() throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		//Verify when user try to assign wf without registering agent
		js.executeScript("arguments[0].click();", WorkflowAssignmentTab);	
		Reporter.log("User navigated to workflow assignment Tab",true);
		Thread.sleep(3000);
		String expected_agentNotRegError=agentNotReg.getText();
		Reporter.log("When Agent is not registered and user try to assign workflow to agent then get error message as: "+expected_agentNotRegError,true);
		String actual_agentNotRegError = "No agent registered";
		Assert.assertEquals(actual_agentNotRegError, expected_agentNotRegError,"Not getting correct error in Workflow assignment Tab");
		Reporter.log("Getting correct error when user didnt register agent & try to assign workflow");
		Thread.sleep(2000);
		Reporter.log("Now User needs to download agent first",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agent List Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agent Tab",true);
		downloadAgentBtn.click();
		Thread.sleep(3000);
		downloadBtn.click();
		Reporter.log("Assisted Agent download started",true);
		Thread.sleep(100000);
		TestUtil.unzip(prop.getProperty("zipFilePathA"),prop.getProperty("destDirA"));
		Reporter.log("File unzipped properly",true);
		//ProcessBuilder pb= new ProcessBuilder(prop.getProperty("AgentRegBatFile"));
		//Process process= pb.start();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
		//StringBuilder sb=new StringBuilder();
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "AgentRun.bat");
		File dir = new File(prop.getProperty("AgentRegBatFilePath"));
		pb.directory(dir);
		Process p = pb.start();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void checkStatusOfAssistedAgent() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		Thread.sleep(8000);
		for(int i=0;i<4;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Assisted Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Assisted Agent is in running mode",true);
		informationpageta.validateSignOut();
	}
	public void assignAssistedAgentToUser(String Username) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		js.executeScript("arguments[0].click();",  assignToUserTab);
		Reporter.log("User navigated to Assign To User Tab",true);
		searchBar.sendKeys(Username);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(4000);
		saveBtn.click();
		Thread.sleep(2000);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.assignToUser;
		System.out.println("Actual Message:- "+actual_Message);
		System.out.println("Expected Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"Assignment not updated successfully");
		informationpageta.validateSignOut();
	}
	public void validateDeleteAgent(String agentName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(2000);
		for(int i=0;i<1;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Agent is in running mode",true);
		Thread.sleep(2000);
		//WebElement stop_btn = driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+agentName+"')]/../button[@title='Stop Agent']"));
		WebElement stop_btn= driver.findElement(By.xpath("//button[@title='Stop Agent']"));
		stop_btn.click();
		Thread.sleep(2000);
		confirmStopBtn.click();
		Thread.sleep(10000);
		for(int i=0;i<2;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Stopping")) {
				Assert.assertEquals(AgentStatus,"Stopping","Agent is not in Stopping mode");
				break;
			}
		}
		Reporter.log("Agent is in Stopping mode",true);
		Thread.sleep(2000);
		//WebElement delete_btn = driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+agentName+"')]/../button[@title='Delete Agent']"));
		WebElement delete_btn= driver.findElement(By.xpath("//button[@title='Delete Agent']"));
		delete_btn.click();
		Thread.sleep(2000);
		confirmDeleteBtn.click();
		Thread.sleep(4000);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.deleteAgent;
		System.out.println("Expected Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"Agent not deleted successfully");
		informationpageta.validateSignOut();
	}
	public void validateDeleteAssistedAgent(String agentName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		Thread.sleep(2000);
		for(int i=0;i<1;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Assisted Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Assisted Agent is in running mode",true);
		Thread.sleep(2000);
		//WebElement stop_btn = driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+agentName+"')]/../button[@title='Stop Agent']"));
		WebElement stop_btn= driver.findElement(By.xpath("//button[@title='Stop Agent']"));
		stop_btn.click();
		Thread.sleep(2000);
		confirmStopBtn.click();
		Thread.sleep(10000);
		for(int i=0;i<2;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(5000);
			if(AgentStatus.equals("Stopped")) {
				Assert.assertEquals(AgentStatus,"Stopped","Assisted Agent is not in Stopping mode");
				break;
			}
		}
		Reporter.log("Agent is in Stopping mode",true);
		Thread.sleep(2000);
		//WebElement delete_btn = driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+agentName+"')]/../button[@title='Delete Agent']"));
		WebElement delete_btn= driver.findElement(By.xpath("//button[@title='Delete Agent']"));
		delete_btn.click();
		Thread.sleep(2000);
		confirmDeleteBtn.click();
		Thread.sleep(4000);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.deleteAgent;
		System.out.println("Expected Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"Assisted Agent not deleted successfully");
		informationpageta.validateSignOut();
	}
	public void unassignAssistedAgentToUser(String Username, String PageTitle, String tabName) throws Exception {
		assignAssistedAgentToUser(Username);
		loginpage.login(prop.getProperty("username_NU"), prop.getProperty("password_NU"));
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", AgentsTab);
		//Reporter.log("User navigated to Agents Tab",true);
		//js.executeScript("arguments[0].click();", AgentListTab);
		//Reporter.log("User navigated to Agentslist Tab",true);
		//Thread.sleep(2000);
		//js.executeScript("arguments[0].click();", AssistedAgentTab);
		//Reporter.log("User navigated to Assisted Agents Tab",true);
		//Thread.sleep(2000);
		//String actual_title=assistedAgentPageTitle.getText();
		//String expected_title=PageTitle;
		//Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						//+ "page title is: "+expected_title,true);
		//Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		//Reporter.log("User is assigned with Assisted Agent so Agent tab is visible with Assisted agent",true);
		searchMenu.sendKeys(tabName);
		Thread.sleep(2000);
		informationpageta.validateSignOut();
		assignAssistedAgentToUser(Username);
		loginpage.login(prop.getProperty("username_NU"), prop.getProperty("password_NU"));
		Thread.sleep(2000);
		searchMenu.sendKeys(tabName);
		Thread.sleep(2000);
		//boolean agentTabVisibility= AgentsTab.isDisplayed();
		//System.out.println(agentTabVisibility);
		Reporter.log("User is not assigned to Assisted agent so Agent tab is not visible", true);
		informationpageta.validateSignOut();
		}
	public void validateEditAssistedAgentName(String AgentName) throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agentslist Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		js.executeScript("arguments[0].click();", editBtn);
		Reporter.log("User clicked on Edit Btn",true);
		for(int i = 0; i < 50; i++) {
		agentName.sendKeys(Keys.BACK_SPACE);
		}
		agentName.sendKeys(AgentName);
		Thread.sleep(2000);
		saveBtn.click();
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.editAgentName;
		Reporter.log("Actual message displayed on screen is: "+actual_Message+ " and Expected "
				+ "message is: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Assisted Agent Name did not get changed");
		Reporter.log("Edit button is clicked and Assisted agent name is changed successfully",true);
		Thread.sleep(4000);
		String changedAgentName = driver.findElement(By.xpath("//table/tr/td/span[text()='" + AgentName + "']")).getText();
		System.out.println("Changed Assisted Agent Name:- "+changedAgentName);
		if(changedAgentName.contentEquals(AgentName)){
			System.out.println("Agent Name is changed Successfully");
		}else {
			System.out.println("Agent Name not changed Successfully");
		}
		informationpageta.validateSignOut();
	}
	public void validateAgentListPageTA(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		js.executeScript("arguments[0].click();", AgentListTab);
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
}	 
















