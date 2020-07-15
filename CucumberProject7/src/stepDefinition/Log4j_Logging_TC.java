package stepDefinition;

import org.apache.log4j.xml.DOMConfigurator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import myTestNG.testBase.*;
import utility.*;

public class Log4j_Logging_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

// Provide Log4j configuration settings
		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("Start of the test script");
// Fetch Test Data
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		Log.info(" Excel sheet opened");
// Launch Browser
		System.setProperty(Constant.DriverName, Constant.DriverPath);
		
		driver = new ChromeDriver();

		Log.info("New driver instantiated");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Log.info("Implicit wait applied on the driver for 10 seconds");

		driver.get(Constant.URL);

		Log.info("Web application launched");
// Login to Gmail
		SignIn_Gmail.Execute(driver);

		System.out.println("Login Successfully.");

		ExcelUtils.setCellData("Pass", 1, 3);

		Log.endTestCase("End of the Test Script");

	}
}
