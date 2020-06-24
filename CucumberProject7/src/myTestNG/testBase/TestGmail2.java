package myTestNG.testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import myTestNG.pageFactory.LoginPage;
import java.io.FileReader;
import au.com.bytecode.opencsv.CSVReader;

public class TestGmail2 {
	WebDriver driver;
	private static final String FILE_PATH = "C:\\Users\\User\\eclipse-workspace\\MyProjectGmail\\test.csv";

	@Test
	public void launchGmail() throws Exception {

		// Read the CSV File for parameters
		CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
		String[] nextLine;
		String furl = " ", fdriverPath = " ", fdriverName = " ";
		String fAct_logID = " ", fAct_passwrd = " ", fExp_logID = " ", fExp_passwrd = " ";
		while ((nextLine = reader.readNext()) != null) {
			for (int i = 0; i < 7; i++) {
				continue;
			}
			// *Parameters*
			furl = nextLine[0]; // furl - It is the URL link to be used
			fdriverPath = nextLine[1]; // fdriverPath - It is the User's System folder path for Drivers
			fdriverName = nextLine[2]; // fdriverName - Driver to be used like Chrome, Firefox etc
			fAct_logID = nextLine[3]; // fAct_logID - The Login ID user enter/types
			fAct_passwrd = nextLine[4]; // fAct_passwrd - Password user enter/types
			fExp_logID = nextLine[5]; // fExp_logID - The expected/valid Login ID of the user
			fExp_passwrd = nextLine[6]; // fExp_passwrd - The expected/valid password of the user
		}

		// Launch the Web Page
		// Setting the driver property to its executable's location
		System.setProperty(fdriverName, fdriverPath);
		// Instantiating driver object
		driver = new ChromeDriver();
		// Launching 'https//mail.google.com'
		driver.get(furl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

		// Creating instance of Login Page
		LoginPage page2 = new LoginPage(driver);

		// Enter or Type LoginID
		page2.enterLoginID(fAct_logID, fExp_logID);

		// Enter the password
		page2.enterPasswrd(fAct_passwrd, fExp_passwrd);

		// Find the number of unread Mails in Inbox received
		page2.countUnread();
	}
}
