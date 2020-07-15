package myTestNG.pageFactory;

import org.openqa.selenium.*;

import utility.Log;

//import utility.Log;

public class Login_Page {

	static WebElement element = null;

	public static WebElement txtbx_UserName(WebDriver driver) {

		element = driver.findElement(By.id("identifierId"));

		Log.info("Username text box found");

		return element;
	}

	public static WebElement nxtbx_UserName(WebDriver driver) {

		element = driver.findElement(By.id("identifierNext"));

		Log.info("Username next btn found");

		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@name='password']"));

		Log.info("Password text box found");

		return element;
	}

	public static WebElement nxtbx_Password(WebDriver driver) {

		element = driver.findElement(By.id("passwordNext"));

		Log.info("Password next btn found");

		return element;
	}
}
