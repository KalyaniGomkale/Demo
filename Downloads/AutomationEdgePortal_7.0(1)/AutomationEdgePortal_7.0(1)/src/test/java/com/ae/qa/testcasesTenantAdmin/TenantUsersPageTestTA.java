package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.HomePageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTestTA extends TestBase {
	TenantUsersPageTA tenantuserspageta;
	// String sheetName="TenantUserData";

	public TenantUsersPageTestTA() {
		super();
	}
	
	 @Test(priority=44)
	  public void ValidateCreatingWorkflowAdminTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateCreatingWorkflowAdminTest","TC_023: To verify create WF Admin");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.creatingUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
	    TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
		TestDataInMap.get("role"));
	  extentTest.log(extentTest.getStatus(), "It will add new workflow admin");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
	 
	 @Test(priority=45)
	  public void ValidateCreatingTenantAdminTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateCreatingTenantUserTest","TC_025: To verify create Tenant Admin");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.creatingUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
	    TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
		TestDataInMap.get("role")); 
	  extentTest.log(extentTest.getStatus(), "It will add new Tenant Admin");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
	
	 @Test(priority=46)
	  public void ValidateCreatingUserAdminTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateCreatingUserAdminTest","TC_028: To verify create User Admin");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.creatingUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
	    TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
		TestDataInMap.get("role")); 
	  extentTest.log(extentTest.getStatus(), "It will add new User Admin");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
	  
	 @Test(priority=47)
	  public void ValidateCreatingTenantUserTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateCreatingTenantUserTest","TC_024: To verify create Tenant User");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.valiateCreatingTenantUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
	    TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
		TestDataInMap.get("role")); 
	  extentTest.log(extentTest.getStatus(), "It will add Tenant User");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
	
	 @Test(priority=79)
	  public void ValidateUnverifiedStatusTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateUnverifiedStatusTest","TC_Sanity40: To verify UNVERIFIED user status functionality");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.ValidateUnverifiedStatus(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
	    TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
		TestDataInMap.get("role")); 
	  extentTest.log(extentTest.getStatus(), "It will verify status of Tenant User successfully");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 } 
	 @Test(priority=80)
	  public void ValidateActiveStatusTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateActiveStatusTest","TC_Sanity44: To verify ACTIVE user status functionality");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.ValidateActiveStatus(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd")); 
	  extentTest.log(extentTest.getStatus(), "It will verify Active status of Tenant User successfully");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
	 @Test(priority=127)
	  public void valiateEnableLockedUserTest(Method method) throws Exception { 
	  extentTest = extent.createTest("valiateEnableLockedUserTest","TC_048: To verify TA can enable locked user ");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.valiateEnableLockedUser(TestDataInMap.get("UserName"),TestDataInMap.get("Action"),
			  TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd")); 
	  extentTest.log(extentTest.getStatus(), "TA enabled locked user successfully");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
	 @Test(priority=171)
		public void validateTenantUsersPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateTenantUsersPageTATest", "TC_Additional:Verify Clicking Home tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			tenantuserspageta=new TenantUsersPageTA();
			tenantuserspageta.validateTenantUsersPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Home Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
		@Test(priority=303)
		public void ValidateBulkUserUploadWithEmailTest(Method method) throws Exception {
			extentTest = extent.createTest("ValidateBulkUserUploadWithEmailTest", "TC_060: To verify can we upload Native Users with email id");
			//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			tenantuserspageta = new TenantUsersPageTA(); 
			tenantuserspageta.bulkUserUploadWithEmail("NATIVE","F:\\Automation Edge Project\\Bulk Users\\Bulk Users 1.csv","rohil");
			extentTest.log(extentTest.getStatus(), "User is able to upload Bulk Native Users");  
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
		@Test(priority=304)
		public void ValidateBulkUserUploadWithoutEmailTest(Method method) throws Exception {
			extentTest = extent.createTest("ValidateBulkUserUploadWithoutEmailTest", "TC_062: To verify can we upload Native Users without email id");
			//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			tenantuserspageta = new TenantUsersPageTA(); 
			tenantuserspageta.bulkUserUploadWithoutEmail("NATIVE","F:\\Automation Edge Project\\Bulk Users\\Bulk Users2.csv", "suyash");
			extentTest.log(extentTest.getStatus(), "User is able to upload Bulk Native Users");  
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

		}
}
