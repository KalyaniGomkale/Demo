package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.ExcelHandler;

public class WorkflowListPageTestTA extends TestBase {
	WorkflowListPageTA workflowlistpageta;
	//public InformationPageTA informationpageta=new InformationPageTA();

	public WorkflowListPageTestTA() {
		super();
	}

	@Test(priority=54)
	public void validateImportWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowTest", "TC_082: Verify Import PS workflow w/o parameter & enable the workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		//workflowlistpageta.validateImportWorkflow("Sanity3","Sanity","Default","C:\\Users\\kalyanig\\Downloads\\AE_Automation_UploadFiles\\Boolean.zip","High","20","60","3","30","Minutes");
		workflowlistpageta.validateImportWorkflow(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow without parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=55) 
	public void ValidateUploadInvalidIconTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateUploadIconTest","TC_152: Verify if user is able to upload wf icon more than 50KB");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateUploadInvalidIcon(TestDataInMap.get("wfName"),prop.getProperty("WFInavlidIcon"));
		extentTest.log(extentTest.getStatus(), "Workflow icon cant be updated as size is more than 50KB");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=56) 
	public void ValidateUploadIconTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateUploadIconTest","TC_151: Verify if user is able to upload wf icon upto 50KB");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateUploadIcon(TestDataInMap.get("wfName"),prop.getProperty("WFValidIcon"));
		extentTest.log(extentTest.getStatus(), "Workflow icon upto size 50KB uploaded successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}  

	@Test(priority=57) 
	public void ValidateEditManualExecutionTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateEditManualExecutionTest","TC_157: Verify if user can edit Manual execution time");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateEditManualExecution(TestDataInMap.get("wfName"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Manual execution time is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}  


	@Test(priority=58) 
	public void ValidateExportWorkflowTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateExportWorkflowTest","TC_157: Verify if user can export wf from development env.");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateExportWorkflow(TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Workflow exported successfully from development environment");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	} 
	@Test(priority=98)
	public void validateImportWorkflowWithConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigParamTest", "TC_083: Verify Import PS workflow with config parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Workflow with config parameter imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=99)
	public void validateImportWorkflowWithRuntimeParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithRuntimeParamTest", "TC_084: Verify Import PS workflow with runtime parameter without credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithRuntimeParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithRunTimeParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow with runtime parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=100)
	public void validateImportWorkflowWithConfigRuntimeParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigRuntimeParamTest", "TC_085: Verify Import PS workflow with configuration and runtime parameter without credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigRuntimeParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigRuntimeParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Workflow with configuration & runtime parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=101)
	public void validateImportWorkflowWithCredConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithCredConfigParamTest", "TC_086: Verify Import PS workflow with configuration with more than 1 credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithCredConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithCredAsConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),
				TestDataInMap.get("CrdentailParam1"), TestDataInMap.get("CrdentailParam2"));
		extentTest.log(extentTest.getStatus(), "Workflow with configuration param as credentials imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=102)
	public void ValidateShowFileStructureTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateShowFileStructureTest", "TC_095: Verify show file structure while importing workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ValidateShowFileStructure(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Show File structure validated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=103)
	public void ValidateUpdateWFWithConfigWFTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateUpdateWFWithConfigWFTest", "TC_100: Validate update workflow without config parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ValidateUpdateWFWithConfigWF(TestDataInMap.get("wfName"),
				prop.getProperty("updateWFWithoutConfigParam"));
		extentTest.log(extentTest.getStatus(), "Workflow without config parameter updated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=173)
	public void validateWorkflowListPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateWorkflowListPageTATest", "TC_Additional:Verify Clicking Workflows List tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA();
		workflowlistpageta.validateWorkflowListPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Workflows List Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=305)
	public void validateImportWorkflowWithConfigParamCredAndCredpoolTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigParamCredAndCredpoolTATest", "TC_087: Verify ImportPS workflow with Config parameter which uses individual credentials + credential pool");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool("KG_Private2","For Private Purpose","KG2","Pune@1234","Sanity3","Sanity","Default","F:\\Automation Edge Project\\Workflows AE\\WFWithCredAsConfigParam.zip","High","20","60","3","30","Minutes","KG_Private2","AE1");
		// workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
		//prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
		//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"), "Suyash", "AECredentials" );
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=312)
	public void validateImportWorkflowRegisteredAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowRegisteredAssistedAgent", "TC_087: Verify Import workflow for registered assisted agent");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowRegistredAssistedAgent("AssistedAgentWF05","For Assisted Agent","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\AssistedAgentWorkflow_v1.zip","Low","20","60","3","30","Minutes");
		// workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
		//prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
		//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"), "Suyash", "AECredentials" );
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=315)
	public void validateImportWorkflowUnRegisteredAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowUnRegisteredAssistedAgent", "TC_087: Verify Import workflow for unregistered assisted agent");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowUnRegistredAssistedAgent("AssistedAgentWF06","For Assisted Agent","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\AssistedAgentWorkflow_v1.zip","Low","20","60","3","30","Minutes");
		// workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
		//prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
		//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"), "Suyash", "AECredentials" );
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=306)
	public void ValidateExportMultipleWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowTest", "TC_138: To verify can export multiple workflow at a time as verified");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.vaildateExportMutlipleWorkflow();
		// workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
		//prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
		//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"), "Suyash", "AECredentials" );
		extentTest.log(extentTest.getStatus(), "Multiple workflow at a time are selected and verified");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
}



