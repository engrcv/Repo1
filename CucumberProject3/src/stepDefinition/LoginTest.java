package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjectModel.LoginPOM;
import pageObjectModel.StringEncrypt;
import pageObjectModel.readFileData;

public class LoginTest {

	WebDriver driver = null;

//Read the data file
	readFileData readFile  =  new readFileData();

//Browser open
//	@BeforeMethod
	@Given("^Open the Chrome and launch the application$")
	public void setUp() {

		//Set the system property to open the chrome browser.
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\Chrome Driver_v83\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(readFile.rFile());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

//	@Test
	@When("^I Enter the Username and Password$")
	public void validLoginPOM() throws InterruptedException {

		LoginPOM loginpage = new LoginPOM(driver);
		String strEncryptedString = readFile.getPwd();
		String key = "lockUnlock";
		String decodedPwd = StringEncrypt.decryptXOR(strEncryptedString, key);
        System.out.println("Decrypted string: " + decodedPwd);
		loginpage.LoginWithoutCookies(readFile.getUser(), decodedPwd);

		Thread.sleep(25000); // wait 25 second, meanwhile you will get email verification code.

//Enter verification code manually which you received on email

		WebElement verifyButton = driver.findElement(By.name("save"));

		verifyButton.click();

	}

//	@AfterMethod
	@After
	public void TestClose() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.close();

	}

}