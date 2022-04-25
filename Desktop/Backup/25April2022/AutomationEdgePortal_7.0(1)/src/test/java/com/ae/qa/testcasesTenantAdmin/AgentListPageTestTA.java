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

	@Test(priority=70)
	public void validateDownloadAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadAgentTest", "TC_227: Verify if user can download & register agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.downloadAgent();
		extentTest.log(extentTest.getStatus(), "Agent registered successfully");
	    ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
/*	
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
	 @Test(priority=177)
		public void validateAgentListPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateAgentListPageTATest", "TC_Additional:Verify Clicking Agent List tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			agentlistpageta = new AgentListPageTA();
			agentlistpageta.validateAgentListPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Agent List Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}*/
}

