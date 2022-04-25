package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.FileManagementPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestDataHandler;


public class FileManagementPageTest extends TestBase {
FileManagementPage filemanagementpage;


	public FileManagementPageTest() {
		super();
	}
		
	@Test(priority = 132)
	public void validateUploadDriverTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadDriverTest", "TC_136: Verify uploading driver file through file managment");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadDriver(TestDataInMap.get("PluginName"));
		extentTest.log(extentTest.getStatus(), "Chrome driver file uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=164)
	public void validateFileManagmentPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantUsersPageTest", "TC_Additional:Verify Clicking File Managment tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateFileManagmentPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "File Managment page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
