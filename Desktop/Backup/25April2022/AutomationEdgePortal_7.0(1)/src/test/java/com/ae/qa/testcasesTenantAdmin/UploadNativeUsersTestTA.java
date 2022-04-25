package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentLogsPageTA;
import com.ae.qa.pagesTenantAdmin.CataloguePageTA;
import com.ae.qa.pagesTenantAdmin.UploadNativeUsersTA;
import com.ae.qa.util.ExcelHandler;

public class UploadNativeUsersTestTA extends TestBase {

	UploadNativeUsersTA uploadnativeusersta;

	public UploadNativeUsersTestTA() {
		super();
	}
	
	@Test
	public void bulkUserUpload() throws Exception {
		extentTest = extent.createTest("validateBulkUserUpload", "TC_060: To verify can we upload Native Users with email id");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	uploadnativeusersta = new UploadNativeUsersTA(); 
		uploadnativeusersta.bulkUserUpload("NATIVE");
		extentTest.log(extentTest.getStatus(), "User is able to upload Bulk Native Users");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
}