package com.training.utility;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {
	
	public static ExtentReports extent;
	
	public static ExtentReports setupExtentReport() {
		
		
		Date date = new Date();
		String dateAppend = date.toString().replace(":", "_").replace(" ", "_");
		String reportPath = System.getProperty("user.dir")+"//target//ExecutionReport_"+ dateAppend +".html";
		ExtentSparkReporter sprarkReport = new ExtentSparkReporter(reportPath);
		
		extent = new ExtentReports();
		extent.attachReporter(sprarkReport);
		
		sprarkReport.config().setDocumentTitle("Retail Application Test Report");
		sprarkReport.config().setTheme(Theme.STANDARD);
		sprarkReport.config().setReportName("Test Execution Results");
		
		return extent;
		
	}

}
