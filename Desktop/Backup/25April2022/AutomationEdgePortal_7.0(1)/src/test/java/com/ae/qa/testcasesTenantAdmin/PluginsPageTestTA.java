package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.PluginsPageTA;
import com.ae.qa.util.ExcelHandler;

public class PluginsPageTestTA extends TestBase {
	PluginsPageTA pluginspageta;

	public PluginsPageTestTA() {
		super();
	}
	 @Test(priority=190)
		public void validatePluginsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validatePluginsPageTATest", "TC_Additional:Verify Clicking Plugins tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			pluginspageta = new PluginsPageTA();
			pluginspageta.validatePluginsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Plugins Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
