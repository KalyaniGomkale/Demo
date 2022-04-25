package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.CataloguePageTA;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.pagesTenantAdmin.RequestsPageTA;
import com.ae.qa.util.ExcelHandler;

public class RequestsPageTestTA extends TestBase{
	RequestsPageTA requestspageta;

	public RequestsPageTestTA() {
		super();
	}

	@Test(priority=74)
	public void validateRequestStatusTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateRequestStatusTest", "TC_082: Verify request status");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   requestspageta = new RequestsPageTA(); 
	   requestspageta.validateRequestStatus();
	 //  requestspageta.validateRequestStatus(TestDataInMap.get("wfName"));
	   extentTest.log(extentTest.getStatus(), "Request status is verified successfully");  
       ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
	@Test(priority=91)
	public void validatecheckColumnsInRequests(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInRequests", "TC_341:To Verify - Show colum check all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.checkColumnsInRequests();
		extentTest.log(extentTest.getStatus(), "Check All option on Requests validated successfully");
	    ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=92)
	public void validatedeselectAllInRequests(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInRequests", "TC_342:To Verify - Show colum Uncheck all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.deselectAllInRequests();
		extentTest.log(extentTest.getStatus(), "UnCheck All option on Requests validated successfully");
	    ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=93)
	public void validateSpecificColumnInRequests(Method method) throws Exception {
		extentTest = extent.createTest("validateSpecificColumnInRequests", "TC_343:To Verify - Specific column get display");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		 requestspageta.SpecificColumnInRequests();
		extentTest.log(extentTest.getStatus(), "Specific column get displayed successfully");
	    ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=94)
	public void validateDownloadRequestTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadRequestTest", "TC_345:To Verify download requests");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		 requestspageta.validateDownloadRequest();
		extentTest.log(extentTest.getStatus(), "Requests downloaded successfully");
	    ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	 @Test(priority=183)
		public void validateRequestsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateRequestsPageTATest", "TC_Additional:Verify Clicking Requests tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			requestspageta = new RequestsPageTA(); 
			requestspageta.validateRequestsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Requests Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
