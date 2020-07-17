package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import myTestNG.testBase.*;
import utility.*;

public class Gmail_Login {
	private static WebDriver driver = null;

	@Given("^Open the Chrome, launch the application and fetch data from excel$")
	public void open_the_Chrome_and_launch_the_application() throws Throwable {

// Fetch Test Data
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

// Launch Browser
		System.setProperty(Constant.DriverName, Constant.DriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.URL);

	}

// Login to Gmail
	@Step("User login to Gmail")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Allure report: Login to Gmail using Excel user credentials")
	@When("^I read Enter the Username and Password$")
	public void enter_the_Username_and_Password() throws Throwable {

		SignIn_Gmail.Execute(driver);
		System.out.println("Login Successfully.");
		ExcelUtils.setCellData("Pass", 1, 3);

	}
}
