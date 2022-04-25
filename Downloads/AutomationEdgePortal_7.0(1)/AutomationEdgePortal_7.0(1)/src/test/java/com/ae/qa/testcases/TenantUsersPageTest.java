package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SystemUsersPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTest extends TestBase {
	TenantUsersPage tenantuserspage;
	String sheetName = "TenantUserData";

	public TenantUsersPageTest() {
		super();
	}


	@Test(priority = 8)
	public void ValidateCreatingTenantAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateCreatingTenantAdminTest", "TC_015: To verify create Tenant Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.creatingTenantUser(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"),TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),TestDataInMap.get("UserName"),
		TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));
		extentTest.log(extentTest.getStatus(), "New Tenant Admin created successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

   @Test(priority = 9)
	public void ValidateEditTenantUserTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditTenantUserTest", "TC_016: To verify Edit Tenant User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.EditTenantUser(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"),TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),TestDataInMap.get("UserName"),
			    TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"),TestDataInMap.get("NewEmailID"));	
		extentTest.log(extentTest.getStatus(), "New Tenant Admin created & edited its emailID successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=154)
	public void validateTenantUsersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantUsersPageTest", "TC_Additional:Verify Clicking Tenant users tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateTenantUsersPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Tenant Users page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
