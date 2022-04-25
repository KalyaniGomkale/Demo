package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.FileManagementPageTA;
import com.ae.qa.util.ExcelHandler;

public class FileManagementPageTestTA extends TestBase {
	FileManagementPageTA filemanagementpageta;

	public FileManagementPageTestTA() {
		super();
	}
	 @Test(priority=198)
		public void validateFileManagementPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateFileManagementPageTATest", "TC_Additional:Verify Clicking File Management tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			filemanagementpageta = new FileManagementPageTA();
			filemanagementpageta.validateFileManagementPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "File Management Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}


}
