package com.zafor.utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportsUtil {
	
	public static ExtentReports extent=null;
	public static boolean overrideExistingReport;

	public ExtentReportsUtil(){
		
	}
	
	public static void init(){
		
		init(true);
	}

	public static void init(boolean overrideExistingReport){
		String reportName = "ExtentReports";
		System.out.println("Extent Report Initialized:");
		ExtentReportsUtil.overrideExistingReport = overrideExistingReport;
		System.out.println(System.getProperty("user.dir") + "/ExtentReports/ExtentReports.html");
		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/" + reportName + ".html", overrideExistingReport);

		
	}
	
	
	public static ExtentReports report(){
		if(extent==null){
			init();
		}
		return extent;
	}
}
