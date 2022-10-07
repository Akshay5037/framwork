package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.PropertiesUtils;

public class BaseClass {

	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentTest test=null;
	public static ExtentSparkReporter spark = null;

	public static Logger log = Logger.getLogger(BaseClass.class);

	public void initialization() throws Exception {
		System.out.println("initializing browser");// only on console
		log.info("intializing browser");// file & console..

		String browserName = PropertiesUtils.readProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.readProperty("url"));
		
	}
		public void reportInit() {
			report = new ExtentReports();
			spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		
	}

}
