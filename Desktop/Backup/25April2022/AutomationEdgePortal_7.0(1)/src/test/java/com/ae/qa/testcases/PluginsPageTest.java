package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.PluginsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class PluginsPageTest extends TestBase {
	LoginPage loginpage;
	PluginsPage pluginspage;

	public PluginsPageTest() {
		super();
	}
//Tested for valid data, invalid location,invalid file type
	@Test(priority = 15)
	public void validateUploadPluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPlugins", "TC_032: Upload plugins zip");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadPlugins();
		extentTest.log(extentTest.getStatus(), "Plugins uploaded successfully and assigned to all tenants");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 128)
	public void validateUploadSinglePluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadSinglePluginsTest", "TC_034:Verify Single plugin upload");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadSinglePlugins(prop.getProperty("uploadSinglePluginFile"));
		extentTest.log(extentTest.getStatus(), "Single Plugins uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=158)
	public void validatePluginsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePluginsPageTest", "TC_Additional:Verify Clicking Plugins tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validatePluginsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(),"Plugins page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
