package com.focus.report;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	private static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir")+"/reports/";
		new File(directory).mkdir();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter = new ExtentHtmlReporter("./reports/Extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automatic Report");
		htmlReporter.config().setReportName("Automation Testing");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Environnment", "Test");
		extent.setSystemInfo("Manuel Reyes", "QA Engineer (SDET)");
		extent.attachReporter(htmlReporter);
		
		return extent;
	}
	
	public static String getReportName() {
		Date date = new Date();
		String fileName = "AutomationReport_"+date.toString().replace(":", "_").replace(" ", "_")+".png";
		return fileName;
	}
}
