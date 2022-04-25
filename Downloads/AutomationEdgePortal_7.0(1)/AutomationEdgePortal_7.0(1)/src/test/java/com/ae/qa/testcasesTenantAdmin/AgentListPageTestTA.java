package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.SchedulerPageTA;
import com.ae.qa.util.ExcelHandler;

public class AgentListPageTestTA extends TestBase {
	AgentListPageTA agentlistpageta;

	public AgentListPageTestTA() {
		super();
	}

    /*@Test(priority=70)
	public void validateDownloadAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadAgentTest", "TC_227: Verify if user can download & register agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.downloadAgent();
		extentTest.log(extentTest.getStatus(), "Agent registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=71)
	public void validateCheckStatusOfAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateCheckStatusOfAgent", "TC_361: Verify status of agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.checkStatusOfAgent();
		extentTest.log(extentTest.getStatus(), "Agent registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=88)
	public void validatecheckColumnsInAgentList(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInAgentList", "TC_241:To Verify - Show colum check all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.checkColumnsInAgentList();
		extentTest.log(extentTest.getStatus(), "Check All option on Agent List validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=89)
	public void validatedeselectAllInAgentListTA(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInAgentListTA", "TC_242:To Verify - Show colum Uncheck all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.deselectAllInAgentListTA();
		extentTest.log(extentTest.getStatus(), "UnCheck All option on Agent List validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=90)
	public void validateSpecificColumnInAgentList(Method method) throws Exception {
		extentTest = extent.createTest("validateSpecificColumnInAgentList", "TC_243:To Verify - Specific column get display");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.SpecificColumnInAgentList();
		extentTest.log(extentTest.getStatus(), "Specific column get displayed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=308)
	public void validateDeleteAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteAgent", "TC_: Verify Delete Agent");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateDeleteAgent("DELL@DESKTOP-5VHKQUJ");	
		extentTest.log(extentTest.getStatus(), "Agent Deleted successfully");
		// ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=310)
	public void validateDownloadAssistedAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadAssistedAgentTest", "TC_: Verify if user can download & register Assisted agent");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.downloadAssistedAgent();		
		extentTest.log(extentTest.getStatus(), "Assisted Agentregistered successfully");
		// ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=311)
	public void validatecheckStatusOfAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckStatusOfAssistedAgent", "TC_: Verify status of Assisted agent");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.checkStatusOfAssistedAgent();		
		extentTest.log(extentTest.getStatus(), "Assisted Agent registered successfully");
		// ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=309)
	public void validateassignAssistedAgentToUser(Method method) throws Exception {
		extentTest = extent.createTest("validateassignAssistedAgentToUser", "TC_: Verify Assign To User in Assign to user tab");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.assignAssistedAgentToUser("MadhuRani2");		
		extentTest.log(extentTest.getStatus(), "Assisn To User registered successfully");
		// ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=316)
	public void validateunassignAssistedAgentToUser(Method method) throws Exception {
		extentTest = extent.createTest("validateunassignAssistedAgentToUser", "TC_: Verify UnAssign To User in Assign to user Tab");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.unassignAssistedAgentToUser("Rohil","Assisted Agents","Agents");		
		extentTest.log(extentTest.getStatus(), "Assisn To User registered successfully");
		// ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=313)
	public void ValidateEditAssistedAgentName(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditAssistedAgentName", "TC_: Verify Edit Agent Name");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateEditAssistedAgentName("DELL@DESKTOP-5VHKQUJ");	
		extentTest.log(extentTest.getStatus(), "Edit Agent Name Successfully");
		// ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	@Test(priority=314)
	public void validateDeleteAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteAssistedAgent", "TC_: Verify Delete Assisted Agent");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateDeleteAgent("DELL@DESKTOP-5VHKQUJ");	
		extentTest.log(extentTest.getStatus(), "Agent Deleted successfully");
		// ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test(priority=177)
	public void validateAgentListPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentListPageTATest", "TC_Additional:Verify Clicking Agent List tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAgentListPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Agent List Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
}

