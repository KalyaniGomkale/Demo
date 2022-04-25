package com.ae.qa.pagesTenantAdmin;

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
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;
import com.aventstack.extentreports.Status;

public class WorkflowListPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 100);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public CataloguePageTA cataloguepageta=new CataloguePageTA();
	public RequestsPageTA requestspageta=new RequestsPageTA();
	public CredentialsPageTA credentialspageta=new CredentialsPageTA(); 
    public AgentListPageTA agentlistta=new AgentListPageTA();
	
    @FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Workflow List']")
	WebElement workflowListTab;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement importTab;
	@FindBy(id = "workflow_name")
	WebElement workflowName;
	@FindBy(id = "description")
	WebElement wfDescription;
	@FindBy(id = "category_name")
	WebElement wfCategory;
	@FindBy(id = "is_assisted")
	WebElement assistedCheckbox;
	@FindBy(name = "rdpEnabled")
	WebElement enableRDPCheckbox;
	@FindBy(xpath="//fieldset[@class='workflow-fieldset']/div/label//input")
	WebElement ChooseWFToImport;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(id = "wfPriority")
	WebElement wfPriority;
	@FindBy(id = "expectedCompletionTime")
	WebElement expected_completionTime;
	@FindBy(id = "maxCompletionTime")
	WebElement max_CompletionTime;
	@FindBy(id = "cleanupOldReqHours")
	WebElement cleanupOldReqHours;
	@FindBy(id = "manualExecutionTime")
	WebElement manualExecutionTime;
	@FindBy(id = "manualTimeUnit")
	WebElement manualTimeUnit;
	@FindBy(name = "submit")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;
	@FindBy(xpath = "//div/h5[text()='Show file content']")
	WebElement showFileContent;
	@FindBy(xpath = "//div/h5[text()='Content:']")
	WebElement content;
	@FindBy(name = "dropdown-selector")
	WebElement importDrpDwn;
	@FindBy(xpath = "//span[text()='Export']")
	WebElement exportBtn;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement selectWf;
	@FindBy(xpath = "//div[@class='right-inner-addon']/input[@name='search']")
	WebElement searchBar;
	@FindBy(id = "isVerified")
	WebElement verifiedCheckbx;
	@FindBy(id = "export-btn")
	WebElement ewfBtn;
	@FindBy(id = "wfIcon")
	WebElement wfIcon;
	@FindBy(xpath = "//form/fieldset[2]/legend[1]/span")
	WebElement emailNotification;
	@FindBy(id = "notifyWfFailure")
	WebElement notifyWfFailureBox;
	@FindBy(id = "notifyLongRunningWf")
	WebElement notifyExceedingTimeBox;
	@FindBy(id = "ROLE_TENANT_ADMIN")
	WebElement roleTA;
	@FindBy(id = "ROLE_WORKFLOW_ADMIN")
	WebElement roleWA;
	@FindBy(id = "toEmail")
	WebElement emailID;
	@FindBy(id = "sendToRequestCreator")
	WebElement reqCreator;
	@FindBy(id = "failureMessage")
	WebElement failMsg;
	@FindBy(id = "isSeqExec")
	WebElement enableSeqExec;
	@FindBy(xpath="//span[@class='text-danger']")
	WebElement smtpEmailNotification;
	@FindBy(id="wfName")
	WebElement WfsList;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	List<WebElement> WfsList1;
	//@FindBy(xpath="//*[@id='options-list']/li[6]/label")
	//WebElement Workflow;
	@FindBy(id="export-btn")
	WebElement ExportBtn;
	@FindBy(xpath="//*[@id='psExportModal']/export-workflow/div/div/form/div[1]")
	WebElement Anywhere;
	@FindBy(xpath="//*[@id='options-list']/li/label")
	WebElement Wfselect;
	@FindBy(xpath="//span[@class='fa fa-caret-right']")
	WebElement configParamBar;
	@FindBy(xpath="//input[@id='a']")
	WebElement configParamInput;
	@FindBy(xpath="//select[@id='a']")
	WebElement credParam1;
	@FindBy(xpath="//select[@id='b']")
	WebElement credParam2;
	@FindBy(xpath="//li[@class='list-group-item']/b")
	WebElement uploadedZipName;
	@FindBy(xpath="//span[text()='Update']")
	WebElement updateOption;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement wf_dropdown;
	@FindBy(xpath="//input[@name='search']")
	WebElement search;
	@FindBy(xpath="//*[@id='options-list']/li/label/span")
	WebElement selectWF;
	@FindBy(xpath="(//label/input[@type=\"file\"])[2]")
	WebElement updateWFBox;
	@FindBy(xpath="//div[@class='pull-left']/button[1]/span")
	WebElement updateBtn;
	@FindBy(xpath="//input[@id='a-poolCredential'][2]")
	WebElement credPoolRadioBtn_a;
	@FindBy(xpath="//input[@id='b-poolCredential'][2]")
	WebElement credPoolRadioBtn_b;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	@FindBy(xpath="//legend[@id='conf-toggle']")
	WebElement configParam;
	@FindBy(xpath="(//input[@id='a-poolCredential'])[1]")
	WebElement credentials;
	@FindBy(xpath="//select[@id='a']")
	WebElement credentialsDropdown;
	@FindBy(xpath="//select[@id='b']")
	WebElement credentialsPoolDropdown;
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath = "//b[text()='No workflow(s) found']")
	WebElement wfNotFoundTitle;

	public WorkflowListPageTA() {
		PageFactory.initElements(driver, this);
	}
	public void ImportForm(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		importTab.click();
		Reporter.log("Import button clicked",true);
		workflowName.sendKeys(wfName);
		Thread.sleep(3000);
		wfDescription.sendKeys(wfdes);
		Thread.sleep(3000);
		Select wfCategory_drpdown = new Select(wfCategory);
		wfCategory_drpdown.selectByVisibleText(category);
		Thread.sleep(3000);
		if (assistedCheckbox.isSelected()) {
			Reporter.log("assisted Workflow is selected",true);
			assistedCheckbox.click();
			Reporter.log("assisted Workflow is unselected",true);
		} else {
			Reporter.log("Is Assisted Workflow checkbox is unselected");
		}
		Thread.sleep(3000);
		if (enableRDPCheckbox.isSelected()) {
			Reporter.log("Enable RDP checkbox is selected",true);
			enableRDPCheckbox.click();
			Reporter.log("Enable RDP checkbox is unselected",true);
		} else {
			System.out.println("Enable RDP checkbox is unselected");
		}
		Thread.sleep(3000);
		//ChooseWFToImport.sendKeys(prop.getProperty("WFToImportPath"));
		ChooseWFToImport.sendKeys(WFImportPath);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", createBtn);
		Reporter.log("Create Button is clicked",true);
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(wfPriority));
		Select wfPriority_drpdown = new Select(wfPriority);
		wfPriority_drpdown.selectByVisibleText(priority);
		Reporter.log("Priority is set",true);
		Thread.sleep(2000);
		expected_completionTime.clear();
		expected_completionTime.sendKeys(expTime);
		Reporter.log("Expected Completion Time in Seconds is set",true);
		Thread.sleep(2000);
		max_CompletionTime.clear();
		max_CompletionTime.sendKeys(maxTime);
		Reporter.log("Maximum Completion Time in Seconds is set",true);
		Thread.sleep(2000);
		cleanupOldReqHours.clear();
		cleanupOldReqHours.sendKeys(cleanUpHrs);
		Reporter.log("Cleanup Requests older than Hours fields is set",true);
		Thread.sleep(2000);
		manualExecutionTime.clear();
		manualExecutionTime.sendKeys(manExeTime);
		Reporter.log("Manual Execution Time is set",true);
		wait.until(ExpectedConditions.visibilityOf(manualTimeUnit));
		Select manualTimeUnit_drpdown = new Select(manualTimeUnit);
		manualTimeUnit_drpdown.selectByVisibleText(tUnit);
		Reporter.log("Manual Execution time unit is set",true);
		Thread.sleep(3000);
	}
	public void validateImportWorkflow(String wfName, String wfdes, String category, String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		String emailActual_message=smtpEmailNotification.getText();
		Reporter.log("Alert Message when user dont configure smtp"+emailActual_message,true);
		String emailExpected_message=Messages.smtpNotConfig;
		Assert.assertEquals(emailActual_message,emailExpected_message, "Not getting correct message when smtp not set");
		Reporter.log("Getting correct message for email notification as smtp not configured",true);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateImportWorkflowWithConfigParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String ConfigParamString) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		configParamBar.click();
		Thread.sleep(3000);
		configParamInput.sendKeys(ConfigParamString);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateImportWorkflowWithRuntimeParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		//	configParamBar.click();
		//	Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateImportWorkflowWithConfigRuntimeParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String ConfigParamString) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		configParamBar.click();
		Thread.sleep(3000);
		configParamInput.sendKeys(ConfigParamString);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateImportWorkflowWithCredConfigParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String Credential1,String Credential2) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		configParamBar.click();
		Thread.sleep(2000);
		credPoolRadioBtn_a.click();
		Thread.sleep(2000);
		Select cred_dropdwn1=new Select(credParam1);
		cred_dropdwn1.selectByVisibleText(Credential1);
		Thread.sleep(2000);
		credPoolRadioBtn_b.click();
		Thread.sleep(2000);
		Select cred_dropdwn2=new Select(credParam2);
		cred_dropdwn2.selectByVisibleText(Credential2);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void ValidateUploadInvalidIcon(String wfname, String IconPath) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(3000);
		WebElement editBtn= driver.findElement(By.xpath("//table/tr/td[@title='"+wfname+"']/../td[7]/span[@title='Edit Worklfow']"));
		editBtn.click();
		Reporter.log("Edit button is clicked",true);
		wfIcon.sendKeys(IconPath);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.InvalidWFIcon;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow icon updated");
		Reporter.log("Icon Updation done successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}

	public void ValidateUploadIcon(String wfname, String IconPath) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(3000);
		WebElement editBtn= driver.findElement(By.xpath("//table/tr/td[@title='"+wfname+"']/../td[7]/span[@title='Edit Worklfow']"));
		editBtn.click();
		Reporter.log("Edit button is clicked",true);
		wfIcon.sendKeys(IconPath);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Icon Updation done successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void ValidateEditManualExecution(String wfname,String manExeTime, String tUnit) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		Thread.sleep(4000);
		//Click on Edit Button
		WebElement edit_btn = driver.findElement(By.xpath("//tr/td[contains(text(),'"+wfname +"')]/../td/span[@title='Edit Worklfow']"));
		js.executeScript("arguments[0].click();", edit_btn);
		Thread.sleep(3000);
		Reporter.log("Edit button is Clicked",true);
		//Clear and Enter Manual Execution time.
		manualExecutionTime.clear();
		manualExecutionTime.sendKeys(manExeTime);
		wait.until(ExpectedConditions.visibilityOf(manualTimeUnit));
		Select manualTimeUnit_drpdown = new Select(manualTimeUnit);
		manualTimeUnit_drpdown.selectByVisibleText(tUnit);
		Thread.sleep(3000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		Reporter.log("Aactual Success Message after editing workflow: " + Actual_successMsg,true);
		String Expected_successMsg = Messages.updateWorkflow;
		Reporter.log("Expected Success Message after editing workflow: " +Expected_successMsg ,true);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		informationpageta.validateSignOut();
	}
	public void ValidateExportWorkflow(String wfName) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		importDrpDwn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Dropdown button", true);
		exportBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Export option from dropdown", true);
		WfsList.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Workflows dropdown ", true);
		searchBar.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on search bar");
		searchBar.sendKeys(wfName);
		Wfselect.click();
		Reporter.log("Checked the Workflow name ", true);
		WfsList.click();
		Thread.sleep(2000);
		ExportBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on export bottun", true);
		String actual_successMsg = success_msg.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg = Messages.exportWorkflow;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "export does not started.");
		informationpageta.validateSignOut();
	}
	public void ValidateShowFileStructure(String wfName, String wfdes, String category, String WFImportPath,String ExpectedFileName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		importTab.click();
		Reporter.log("Import button clicked",true);
		workflowName.sendKeys(wfName);
		Thread.sleep(3000);
		wfDescription.sendKeys(wfdes);
		Thread.sleep(3000);
		Select wfCategory_drpdown = new Select(wfCategory);
		wfCategory_drpdown.selectByVisibleText(category);
		Thread.sleep(3000);
		ChooseWFToImport.sendKeys(WFImportPath);
		Thread.sleep(3000);
		showFileContent.click();
		//here we will validate UploadedFile.zip
		String Actual_FileName=uploadedZipName.getText();
		String Expected_FileName=ExpectedFileName;
		Assert.assertEquals(Actual_FileName,Expected_FileName,"Zip file not found");
		Reporter.log("Zip File found in File Structure:"+Actual_FileName,true);
		informationpageta.validateSignOut();
	}
	public void ValidateUpdateWFWithConfigWF(String wfName,String updatedWFPath) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		importDrpDwn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Dropdown button", true);
		updateOption.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Update option from dropdown", true);
		wf_dropdown.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Workflows dropdown ", true);
		search.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on search bar");
		selectWF.click();
		Reporter.log("Checked the Workflow name which needs to be updated", true);
		updateWFBox.sendKeys(updatedWFPath);
		Thread.sleep(2000);
		updateBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Update bottun", true);
		Thread.sleep(3000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		informationpageta.validateSignOut();
		cataloguepageta.validateSubmitRequest(wfName);
		requestspageta.validateRequestStatus();

	}
	public void validateWorkflowListPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		js.executeScript("arguments[0].click();", workflowListTab);
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
	public void validateImportWorkflowWithConfigParamCredAndCredpool(String CredName,String CredDescp,String UserName,String Pswd,String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit , String credentialName , String credentialPoolName) throws Exception
	{
		credentialspageta.ValidateCreateCredentials(CredName,CredDescp,UserName,Pswd);
		ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		//Clicking on Configuration Parameters
		wait.until(ExpectedConditions.visibilityOf(configParam));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", configParam);
		Reporter.log("Configuration Parameters dropdown is clicked",true);
		//Clicking on Credential Radio Button
		credentials.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Radio Button", true);
		//Selecting Credentials from the dropdown
		Select credentials_drpdown = new Select(credentialsDropdown);
		credentials_drpdown.selectByVisibleText(credentialName);
		Thread.sleep(3000);
		//Clicking on Credentials Pool Radio Button
		credPoolRadioBtn_b.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Pool Radio Button", true);
		//Selecting Credentials Radio Button
		Select credentialsPool_drpdown = new Select(credentialsPoolDropdown);
		credentialsPool_drpdown.selectByVisibleText(credentialPoolName);
		Thread.sleep(3000);
		//Clicking on Save Button
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();         
	}
	public void validateImportWorkflowRegistredAssistedAgent(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		ImportForm(wfName,wfdes,category, WFImportPath, priority,
				expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut(); 
		cataloguepageta.validateSubmitRequest(wfName);
		requestspageta.validateRequestStatus();
		informationpageta.validateSignOut();
	}
	public void validateImportWorkflowUnRegistredAssistedAgent(String wfName, String wfdes, String category, String WFImportPath, String priority,
		String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
	ImportForm(wfName,wfdes,category, WFImportPath, priority,
			expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
	saveBtn.click();
	Thread.sleep(4000);
	Reporter.log("Save button is clicked",true);
	wait.until(ExpectedConditions.visibilityOf(success_msg));
	String Actual_successMsg = success_msg.getText();
	System.out.println("Actual Message : " + Actual_successMsg);
	String Expected_successMsg = Messages.updateWorkflow;
	System.out.println("Expected Message :"+Expected_successMsg);
	Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
	Reporter.log("Workflow updated",true);
	Thread.sleep(2000);
	WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
	sliderToEnableWF.click();
	Reporter.log("Workflow is enabled successfully",true);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(catalogueTab));
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",catalogueTab);
	Reporter.log("Catalogue Tab is clicked",true);
	Thread.sleep(2000);
	boolean wfNameToSendRequest = wfNotFoundTitle.isDisplayed();
	if(wfNameToSendRequest){
		System.out.println("Agent is been deleted need to be registred so that WF will be present in Catalogue");
	}else {
		System.out.println("Agent is registered and not been deleted");
	}
	informationpageta.validateSignOut();
	agentlistta.downloadAssistedAgent();
	agentlistta.checkStatusOfAssistedAgent();
	cataloguepageta.validateSubmitRequest(wfName);
		}
	

	public void vaildateExportMutlipleWorkflow() throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		js.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		importDrpDwn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Dropdown button", true);
		exportBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Export option from dropdown", true);
		WfsList.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Workflows dropdown ", true);
		searchBar.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on search bar");
		//Selecting all the Workflows present in the dropdown list
		List<WebElement> workflow_List =  WfsList1;
		int workflows_size = workflow_List.size();
		System.out.println("Number of Workflows:- "+workflows_size);
		for(int i = 0; i<workflows_size; i++) {

			workflow_List.get(i).click();
		}
		Thread.sleep(5000);
		//searchBar.sendKeys(wfName);
		//Wfselect.click();
		//Reporter.log("Checked the Workflow name ", true);
		WfsList.click();
		Thread.sleep(2000);
		ExportBtn.click();
		Thread.sleep(2000);
		String actual_successMsg = success_msg.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg = Messages.exportWorkflow;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "export does not started.");
		informationpageta.validateSignOut();
	}

}
