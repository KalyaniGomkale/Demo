package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.EmailReportsPageTA;
import com.ae.qa.util.ExcelHandler;

public class EmailReportsPageTestTA extends TestBase {
	EmailReportsPageTA emailreportspageta;

	public EmailReportsPageTestTA() {
		super();
	}
	 @Test(priority=189)
		public void validateEmailReportsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateEmailReportsPageTATest", "TC_Additional:Verify Clicking Email Reports tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			emailreportspageta = new EmailReportsPageTA();
			emailreportspageta.validateEmailReportsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Email Reports Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
