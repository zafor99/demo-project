package com.zafor.demo.test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class TestMe extends BaseScript{

	@Test
	public void TC01_Positive(Method method) {
		step1();
		verify1();
		step2();
		verify2();
		assert_All(method.getName());

	}
	public void verify1(){
		try{
			Assert.assertEquals(true, false);
			reportTest().log(LogStatus.PASS, "verify1 status passed");
		}catch(AssertionError e)
		{
			BaseScript.testFailed = true;
			reportTest().log  (LogStatus.FAIL, "verify1 did not passed : Stack trace" + e.getLocalizedMessage());		
		}

	}
	public void step1(){
		reportTest().log(LogStatus.INFO, "This is Step 1");
		
	}
	public void step2(){
		reportTest().log(LogStatus.INFO, "This is Step 2");
	}
	public void verify2(){
		try{		
			Assert.assertEquals(true, true);
			reportTest().log(LogStatus.PASS, "verify2 status passed");
		}catch(AssertionError e)
		{
			BaseScript.testFailed = true;
			reportTest().log(LogStatus.FAIL, "verify1 did not passed");
			
		}

	}

}
