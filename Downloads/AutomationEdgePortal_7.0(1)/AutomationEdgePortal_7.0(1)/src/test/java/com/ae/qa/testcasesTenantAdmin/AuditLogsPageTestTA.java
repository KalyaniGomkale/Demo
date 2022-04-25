package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AuditLogsPageTA;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.util.ExcelHandler;

public class AuditLogsPageTestTA extends TestBase {
	AuditLogsPageTA auditlogspageta;

	public AuditLogsPageTestTA() {
		super();
	}

//No data required
	@Test(priority = 75)
	public void validatedownloadingAuditLogsTA(Method method) throws Exception {
		extentTest = extent.createTest("validatedownloadingAuditLogsTA", "TC_368: Verify download audit logs for TA");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.downloadingAuditLogsTA();
		extentTest.log(extentTest.getStatus(), "Audit Logs for TA downloading started successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority = 76)
	public void validatecheckColumnsInAuditLogsTA(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInAuditLogsTA", "TC_373: Verify show columns TA- Check All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.checkColumnsInAuditLogsTA();
		extentTest.log(extentTest.getStatus(), "Select All options checked and verified in table for TA successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority = 77)
	public void validatedeselectAllInAuditLogsTA(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInAuditLogsTA", "TC_374: Verify show columns TA- Uncheck All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.deselectAllInAuditLogsTA();
		extentTest.log(extentTest.getStatus(), "Deselect All options checked and verified in table for TA successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority = 78)
	public void verifySpecificColumnTestTA(Method method) throws Exception {
		extentTest = extent.createTest("verifySpecificColumnTestTA", "TC_375: Verify show columns for TA- specific column get display ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.verifySpecificColumnTA();
		extentTest.log(extentTest.getStatus(), "It will check specific columns for TA in the table");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	 @Test(priority=185)
		public void validateAuditLogsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateAuditLogsPageTATest", "TC_Additional:Verify Clicking Audit Logs tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateAuditLogsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Audit Logs Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

/*	@Test (priority = 32)
	public void verifycheckLogsTest(Method method) throws Exception  {
		extentTest = extent.createTest("verifycheckLogsTest", "TC_031: Verify whether logs are shown in table for last activities ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.checkLogs(TestDataInMap.get("ServerURL"),TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "Logs are shown in table for last activities are validated.");	
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	
	}*/
	
}
