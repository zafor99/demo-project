package com.zafor.demo.test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zafor.utils.ExtentReportsUtil;

public class BaseScript {
	public static Boolean testFailed = null;	
	public static ExtentTest test = null;
	
	private static ExtentTest groupTest = null;
	private static ExtentTest classTest = null;
	private static ExtentTest reportTest = null;
	public void assert_All(String name){
		if(testFailed){
			Assert.fail(name + " : Test Failed");
		}
	}
	public static ExtentTest reportTest(){
		/*if(test==null){
			test = ExtentReportsUtil.report().startTest("Test"); 
		}*/
		return reportTest;
	}
	@BeforeMethod
	public  void setUpBeforeMethod(Method method) throws Exception {		
		System.out.println("Before Method");
	
		testFailed = false;
		/*test = ExtentReportsUtil.report().startTest(method.getName());
		System.out.println(method.getName());*/
		
		reportTest = ExtentReportsUtil.report().startTest(method.getName());
		System.out.println(method.getName());
	}
	

	@AfterMethod
	public void tearDownAfterMethod(ITestResult result) throws Exception {
		
		System.out.println("After Method");
		
        if (result.getStatus() == ITestResult.FAILURE) {
        	reportTest().log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
        	reportTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
        	reportTest().log(LogStatus.PASS, "Test passed");
        }
        
        classTest.appendChild(reportTest);
		/*ExtentReportsUtil.extent.endTest(reportTest());
		ExtentReportsUtil.extent.flush();*/	

	}
	
	@BeforeClass
	public void setUpBeforeClass(){
		String className = this.getClass().getName();
		classTest = ExtentReportsUtil.report().startTest(className);
		
	}
	
	@AfterClass
	public void tearDownAfterClass(){
		ExtentReportsUtil.extent.endTest(classTest);
		ExtentReportsUtil.extent.flush();
		
	}
	
	@BeforeTest
	public void setUpBeforeGroups(){
		/*System.out.println("Before Group");
		String className = this.getClass().getName();
		groupTest = ExtentReportsUtil.report().startTest("Test");*/
	}
	
	@AfterTest
	public void setUpAfterGroups(){
		/*System.out.println("After Group");
		ExtentReportsUtil.extent.endTest(groupTest);
		ExtentReportsUtil.extent.flush();*/
	}
	
	@BeforeSuite
	public void setUpBeforeSuite(){
		System.out.println("Before Suite");
		ExtentReportsUtil.init();
	}
	
	@AfterSuite
	public void tearDownAfterSuite(){
		System.out.println("After Suite");
		ExtentReportsUtil.extent.close();
	}
}
