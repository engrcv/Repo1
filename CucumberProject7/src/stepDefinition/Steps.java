package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("^Open the Chrome and launch the application$")
	public void open_the_Chrome_and_launch_the_application() throws Throwable {
		// Setting the driver property to its executable's location
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\Chrome Driver_v83\\chromedriver.exe");

		// Instantiating driver object
		WebDriver driver = new ChromeDriver();
		// Launching 'https//mail.google.com'
		driver.get("https://mail.google.com");
		driver.manage().window().maximize();
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("visala.ch042020");
        driver.findElement(By.id("identifierNext")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("May04_2020");
        driver.findElement(By.id("passwordNext")).click();
		driver.close();

	}

	@When("^I read Enter the Username and Password from excel \"(.*?)\"$")
	public void enter_the_Username_and_Password(String file) throws Throwable {
		
		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet myExcelSheet = myExcelBook.getSheet("Users");
		XSSFRow row = myExcelSheet.getRow(0);

		if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING) {
			String UserID = row.getCell(0).getStringCellValue();
			System.out.println("User : " + UserID);
		}
		if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
			String Passwrd = row.getCell(1).getStringCellValue();
			System.out.println("PWD :" + Passwrd);
		}
		myExcelBook.close();
	
	}

}
