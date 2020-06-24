package myTestNG.pageFactory;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) throws InterruptedException {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Locate Web Element: LoginID
	@FindBy(id = "identifierId")
	private WebElement loginID;

	// Locate Web Element: Next Button1
	@FindBy(id = "identifierNext")
	private WebElement nxtButton1;

	// Locate Web Element: Password
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwrd;

	// Locate Web Element: Next Button2
	@FindBy(id = "passwordNext")
	private WebElement nxtButton2;

	// Locate Web Element: UnreadMails
	@FindBy(xpath = "//*[contains(@class,'bsU')]")
	private WebElement unreadMails;

	// Error Messages
	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	private WebElement errMessage1;
	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]")
	private WebElement errMessage2;

	// ***********************************Methods********************************************

	// Enter or Type LoginID
	public void enterLoginID(String Act_logID, String Exp_logID) throws InterruptedException {
		loginID.sendKeys(Act_logID);
		Thread.sleep(3000);
		nxtButton1.click();
		Thread.sleep(8000);
		SoftAssert sAssert = new SoftAssert();
		try {
			if (Act_logID == Exp_logID) {
				System.out.println("Login: Pass");
			}
		} catch (Throwable t) {
			String err = errMessage1.getText();
			sAssert.assertEquals(err, "Couldn't find your Google Account");
			sAssert.fail("Failed: Invalid Login ID");
			System.out.println(err);
			sAssert.assertAll();
		}
	}

	// Enter the password
	public void enterPasswrd(String Act_passwrd, String Exp_passwrd) throws InterruptedException {
		passwrd.sendKeys(Act_passwrd);
		Thread.sleep(3000);
		nxtButton2.click();
		Thread.sleep(3000);
		try {
			if (Act_passwrd == Exp_passwrd) {
				System.out.println("Password: Pass");
			}
		} catch (Throwable t) {
			String err1 = errMessage2.getText();
			Assert.assertEquals(err1, "Wrong password. Try again or click Forgot password to reset it.");
			Assert.fail("Failed: Invalid Password");
			System.out.println(err1);
		}
	}

	// Verify the successful login and Find the number of unread Mails received
	public void countUnread() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
		WebElement findFirst = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title,'Inbox')]")));
		wait.until(ExpectedConditions.visibilityOf(findFirst));
		if (isElementPresent(findFirst)) {
			System.out.println("Successfully Logged In");
		} else {
			System.out.println("Error during Login");
		}
		Thread.sleep(3000);
		String str1 = unreadMails.getText();
		System.out.print("You have " + str1 + " unread Mails in your Inbox. ");
		driver.quit();
	}

	private boolean isElementPresent(WebElement findFirst) {
		// method
		return true;
	}
}
