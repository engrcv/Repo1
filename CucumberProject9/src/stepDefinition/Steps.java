package stepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

import utility.Fullscreenshot;
import utility.ReadXcel;
import utility.Reporter;

public class Steps {
	WebDriver driver;
	String userID;
	String pwd;
	
	@Given("^I read Enter the Username and Password from excel \"(.*?)\"$")
	public void enter_the_Username_and_Password(String file) throws Throwable {
		ReadXcel.readXcel(file);

		for (int rowNum = 0; rowNum < 1; rowNum++) {
			userID = ReadXcel.getUser(rowNum);
			pwd = ReadXcel.getPwd();
			Reporter.initialize();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\User\\eclipse-workspace\\Chrome Driver_v83\\chromedriver.exe");
			// Instantiating driver object
			driver = new ChromeDriver();
			// Launching 'https//mail.google.com'
			driver.get("https://mail.google.com");
			driver.manage().window().maximize();

			// Username is entered
			new WebDriverWait(driver, 10)
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']")))
						.sendKeys(userID);
			
			//Reporter.writeResults();
		   	driver.findElement(By.id("identifierNext")).click();
			// Password is entered
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")))
					.sendKeys(pwd);
			driver.findElement(By.id("passwordNext")).click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		ReadXcel.closeXcel();
	}
	
	@After
	public void writeReport(Scenario scenario) throws IOException {
		String scenarioName = scenario.getName();
		
		//Take Screenshot of Pass/Failed scenario
		Fullscreenshot.takeScreenshot(driver, scenarioName);
		
		//Write the result to html with current date
		String screenPath = "F:/Full_Screenshot/" + scenario.getName()+ "Screenshot.jpg";
		//String screenPath = "F:/Full_Screenshot/";
		Reporter.report(userID, "visala.ch042020",screenPath);
		Reporter.writeResults(scenarioName);
		
		//Show the result in console
		Reporter.showResults();
		
		driver.close();
	}
}
