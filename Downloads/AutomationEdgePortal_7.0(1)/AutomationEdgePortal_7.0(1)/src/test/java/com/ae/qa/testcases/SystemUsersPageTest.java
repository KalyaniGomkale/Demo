package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SystemUsersPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class SystemUsersPageTest extends TestBase {
	SystemUsersPage systemuserspage;

	public SystemUsersPageTest() {
		super();
	}

	@Test(priority = 5)
	public void creatingSystemAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("creatingSystemAdminTest", "TC_008: Verify create System User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingSystemAdmin(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
		TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));
		extentTest.log(extentTest.getStatus(), "System User created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		
	}

	@Test(priority = 6)
	public void validateEditSystemUsers(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditSystemUsersTest", "TC_009: Verify Edit System User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.EditSystemUsers(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
		TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"), TestDataInMap.get("NewEmailID"));
		extentTest.log(extentTest.getStatus(), "System User edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 7)
	public void validatePasswordMismatch(Method method) throws Exception {
		extentTest = extent.createTest("validatePasswordMismatch", "TC_014: Verify creating sysadmin with Password mismatch");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingSystemAdminWithWrongPswd(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
				TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));
		extentTest.log(extentTest.getStatus(), "Password Mismatch gave error message");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 307)
	public void validateTenantLicenseAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("creatingSystemAdminTest", "TC_008: Verify create System User");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingTenantLicenseAdmin("SYSADMIN","TenantLicense","Admin","TenantLicenseAdmin@gmail.com","TLA01","Pune@123","Pune@123","Tenant License Admin");		
		extentTest.log(extentTest.getStatus(), "System User created successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=153)
	public void validateSystemUsersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSystemUsersPageTest", "TC_Additional:Verify Clicking system users tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateSystemUsersPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "System Users page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
