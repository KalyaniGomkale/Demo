package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.EmailNotificationPageTA;
import com.ae.qa.pagesTenantAdmin.LDAPPageTA;
import com.ae.qa.util.ExcelHandler;

public class EmailNotificationPageTestTA extends TestBase {
	EmailNotificationPageTA emailnotificationpageta;

	public EmailNotificationPageTestTA() {
		super();
	}
//Negative case when SMTP not configured
	@Test(priority=10)
	public void validateEmailNotfSMTPNotConfigTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateEmailNotfSMTPNotConfigTest", "TC_082: Verify if user try to set email notofication w/o SMTP settings");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   emailnotificationpageta = new EmailNotificationPageTA(); 
	   emailnotificationpageta.validateEmailNotfSMTPNotConfig();
	   extentTest.log(extentTest.getStatus(), "User cant set email notification w/o SMTP Setting tested successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
//Test case when SMTP Is configured-we will check if Current Agent Status is present in table or not 
	@Test(priority=12)
	public void validateEnailNotfSMTPConfTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateEnailNotfSMTPConfTest", "TC_082: Verify if user try to set email notofication after SMTP settings");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   emailnotificationpageta = new EmailNotificationPageTA(); 
	   emailnotificationpageta.validateEnailNotfSMTPConf();
	   extentTest.log(extentTest.getStatus(), "User can set email notification after SMTP Setting tested successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
	 @Test(priority=201)
		public void validateEmailNotificationPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateEmailNotificationPageTATest", "TC_Additional:Verify Clicking Email Notification tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			emailnotificationpageta = new EmailNotificationPageTA(); 
			emailnotificationpageta.validateEmailNotificationPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Email Notification Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
}
