package myTestNG.testBase;

import org.openqa.selenium.WebDriver;

//import myTestNG.pageFactory.Home_Page;
import myTestNG.pageFactory.Login_Page;
import utility.ExcelUtils;
import utility.Log;

public class SignIn_Gmail {

	public static void Execute(WebDriver driver) throws Exception {

		String sUserName = ExcelUtils.getCellData(1, 1);

		Log.info("Username picked from Excel is " + sUserName);

		String sPassword = ExcelUtils.getCellData(1, 2);

		Log.info("Password picked from Excel is " + sPassword);

		Login_Page.txtbx_UserName(driver).sendKeys(sUserName);

		Log.info("Username entered in the Username text box");

		Login_Page.nxtbx_UserName(driver).click();

		Log.info("Clicked on next btn");
		
		Login_Page.txtbx_Password(driver).sendKeys(sPassword);

		Log.info("Password entered in the Password text box");

		Login_Page.nxtbx_Password(driver).click();

		Log.info("Clicked on login btn");

	}

}