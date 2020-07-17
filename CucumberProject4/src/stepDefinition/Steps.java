package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;

public class Steps {
	WebDriver driver;

	@Given("^Open the Chrome and login to Gmail$")
	public void open_the_Chrome_and_launch_the_application() throws Throwable {
		// Setting the driver property to its executable's location
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\Chrome Driver_v83\\chromedriver.exe");

		// Instantiating driver object
		WebDriver driver = new ChromeDriver();
		// Launching 'https://mail.google.com'
		driver.get("https://mail.google.com");
		driver.manage().window().maximize();

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']")))
				.sendKeys("visala.ch042020");
		driver.findElement(By.id("identifierNext")).click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")))
				.sendKeys("May04_2020");
		driver.findElement(By.id("passwordNext")).click();
		driver.close();

	}
}
