package com.zafor.utils;

import java.io.File;





public class ExtentReportsUtil_old {
	
	/*public static ExtentHtmlReporter htmlReporter=null;
	public static ExtentReports extent=null;
	public static boolean overrideExistingReport;
	public ExtentReportsUtil_old(){
		
	}
	
	public static void init(){
		
		init(true);
	}
	
	@SuppressWarnings("deprecation")
	public static void init(boolean overrideExistingReport){
		String reportName = "ExtentReports";
	
		System.out.println("Extent Report Initialized:");		
		System.out.println(System.getProperty("user.dir") + "/ExtentReports/ExtentReports.html");
		htmlReporter = new ExtentHtmlReporter (System.getProperty("user.dir") + "/ExtentReports/" + reportName + ".html");
		htmlReporter.setAppendExisting(true);
		htmlReporter.config().setDocumentTitle(reportName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportName);
		//extent.loadConfig(new File(System.getProperty("user.dir") + "/libs/extent-config.xml"));
		extent = new ExtentReports();
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
		extent.attachReporter(htmlReporter);
	
		
	}
	
	
	public static ExtentHtmlReporter htmlReport(){
		if(htmlReporter==null){
			init();
		}
		return htmlReporter;
	}*/
}
