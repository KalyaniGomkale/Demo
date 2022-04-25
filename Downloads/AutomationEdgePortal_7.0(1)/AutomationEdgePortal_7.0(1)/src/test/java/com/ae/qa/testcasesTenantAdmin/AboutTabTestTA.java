package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AboutTabTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.util.ExcelHandler;

public class AboutTabTestTA extends TestBase{
	AboutTabTA abouttabta;

	public  AboutTabTestTA() {
		super();
	}
	@Test
	public void AboutTabTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTab", "TC_74: To verify About tab");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		abouttabta = new AboutTabTA(); 
		abouttabta.aboutTab("7.2.0","7.2.0-SNAPSHOT","3");
		extentTest.log(extentTest.getStatus(), "Verify About Tab");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	@Test
	public void validateSetTenantLogo(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordTest", "TC_078:Change Tenant Logo");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		abouttabta = new AboutTabTA();
		abouttabta.changeTenantLogo();
		extentTest.log(extentTest.getStatus(), "Tenant changed Logo set successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}