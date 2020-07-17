package myTestNG.testBase;

import org.openqa.selenium.WebDriver;
import myTestNG.pageFactory.Login_Page;
import utility.ExcelUtils;

public class SignIn_Gmail {
	
	public static void Execute(WebDriver driver) throws Exception {

		// Pick Username and password from Input excel
		String sUserName = ExcelUtils.getCellData(1, 1);
		String sPassword = ExcelUtils.getCellData(1, 2);

		// Enter the Username
		Login_Page.txtbx_UserName(driver).sendKeys(sUserName);
		Login_Page.nxtbx_UserName(driver).click();

		// Enter the password
		Login_Page.txtbx_Password(driver).sendKeys(sPassword);
		Login_Page.nxtbx_Password(driver).click();

	}

}