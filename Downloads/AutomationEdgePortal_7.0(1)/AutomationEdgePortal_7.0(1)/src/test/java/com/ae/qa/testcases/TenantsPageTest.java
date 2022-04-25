package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.ReadExcel;
import com.ae.qa.util.TestDataHandler;
import com.ae.qa.util.TestUtil;

import com.aventstack.extentreports.gherkin.model.Scenario;


public class TenantsPageTest extends TestBase {
	LoginPage loginpage;
	TenantsPage tenantspage;
	TestDataHandler testdata=new TestDataHandler();
	
	//constructor is used to initialize object of class and super to call superclass objects and access the superclass methods and variables
	public TenantsPageTest() {
		super();
	}
	//Here we are eliminating hard-coded value and adopting data driven approach
	@Test(priority = 2)
	public void validateAddNewTenant(Method method) throws Exception {
		extentTest = extent.createTest("validateAddNewTenant", "TC_001: To Verfiy Add new Tenant");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		System.out.println("Values from excel:"+TestDataInMap.get("TenantName")+TestDataInMap.get("Description")+TestDataInMap.get("OrganizationCode"));
		tenantspage.addNewTenants(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"));
		extentTest.log(extentTest.getStatus(), "Tenant added successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 3)
	public void validateaddNewTenantsWithDuplicateOrgCode(Method method) throws Exception {
		extentTest = extent.createTest("validateAddNewTenantsWithDuplicateOrgCode","TC_006: To verify if user give duplicate org code");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		System.out.println("Values from excel:"+TestDataInMap.get("TenantName")+TestDataInMap.get("Description")+TestDataInMap.get("OrganizationCode"));
		tenantspage.addNewTenantsWithDuplicateOrgCode(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"));
		extentTest.log(extentTest.getStatus(), "Tenant not created with duplicate org code");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 4)
	public void verifyLicenseInfoTest(Method method) throws Exception {
		extentTest = extent.createTest("verifyLicenseInfoTest", "TC_007: Verify License Information");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.verifyLicenseInfo();
		extentTest.log(extentTest.getStatus(), "It validates the license status of Sysadmin");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=152)
	public void validateTenantsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantsPageTest", "TC_Additional:Verify Clicking Tenants tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateTenantsPage(TestDataInMap.get("TabName"),TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Tenants page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
