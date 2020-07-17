package myTestNG.pageFactory;

import org.openqa.selenium.*;

public class Login_Page {

	static WebElement element = null;

	public static WebElement txtbx_UserName(WebDriver driver) {
		element = driver.findElement(By.id("identifierId"));
		return element;
	}

	public static WebElement nxtbx_UserName(WebDriver driver) {
		element = driver.findElement(By.id("identifierNext"));
		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='password']"));
		return element;
	}

	public static WebElement nxtbx_Password(WebDriver driver) {
		element = driver.findElement(By.id("passwordNext"));
		return element;
	}
}
