package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import utility.ExcelReadWrite;

public class Steps {
	WebDriver driver;
	ExcelReadWrite wExcel;

	enum Levels {
		LEVEL1, LEVEL2, LEVEL3, LEVEL4
	};

	List<String> lv1;
	List<String> lv2;

	@Given("^I launch Attra.com website and extract the list of services$")
	public void get_Products_services_Attra() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\Chrome Driver_v83\\chromedriver.exe");
		// Instantiating driver object
		driver = new ChromeDriver();
		// Launching 'Attra.com'
		driver.get("https://www.attra.com/");
		driver.manage().window().maximize();

		new WebDriverWait(driver, 20)
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//button[text()='I agree' and @class='createPolicy']")))
				.click();

		wExcel = new ExcelReadWrite();
		ExcelReadWrite.createXcel();

		Levels l = Levels.LEVEL1;

		switch (l) {
		case LEVEL1:
			List<WebElement> ItemsLevel1 = driver.findElements(By.xpath("//*[@id=\"nav-menu-item-11254\"]/ul/li/a"));
			lv1 = new ArrayList<String>();
			int r1 = 1;
			int c1 = 0;
			ExcelReadWrite.wLevel1(0, 0, "LEVEL1");
			for (WebElement myElementL1 : ItemsLevel1) {
				String l1 = myElementL1.getAttribute("innerHTML");
				lv1.add(l1);
				System.out.println("Level1:" + l1);
				ExcelReadWrite.wLevel1(r1, c1, l1);
				r1++;
			}
			// break;
		case LEVEL2:
			List<WebElement> ItemsID_Level1 = driver.findElements(By.xpath("//*[@id=\"nav-menu-item-11254\"]/ul/li"));
			lv2 = new ArrayList<String>();
			int r2 = 1;
			int c2 = 1;
			ExcelReadWrite.wLevel1(0, 1, "LEVEL2");
			for (WebElement ElementID_L1 : ItemsID_Level1) {
				String itemID_L1 = ElementID_L1.getAttribute("id");
				System.out.println("Level 1 - Item ID:" + itemID_L1);

				List<WebElement> ItemsLevel2 = driver.findElements(By.xpath("//*[@id=\"" + itemID_L1 + "\"]/ul/li/a"));
				if (ItemsLevel2.isEmpty()) {
					continue;
				} else {
					for (WebElement myElementL2 : ItemsLevel2) {
						String l2 = myElementL2.getAttribute("innerHTML");
						lv2.add(l2);
						System.out.println("Level2:" + l2);
						ExcelReadWrite.wLevel1(r2, c2, l2);
						r2++;
					}
				}
			}
		case LEVEL3:
			List<WebElement> ItemsID_Level2 = driver
					.findElements(By.xpath("//*[@id=\"nav-menu-item-11254\"]/ul/li/ul/li"));
			int r3 = 1;
			int c3 = 2;
			ExcelReadWrite.wLevel1(0, 2, "LEVEL3");
			for (WebElement ElementID_L2 : ItemsID_Level2) {
				String itemID_L2 = ElementID_L2.getAttribute("id");
				System.out.println("Level 2 - Item ID:" + itemID_L2);

				List<WebElement> ItemsLevel3 = driver.findElements(By.xpath("//*[@id=\"" + itemID_L2 + "\"]/ul/li/a"));
				if (ItemsLevel3.isEmpty()) {
					continue;
				} else {
					for (WebElement myElementL3 : ItemsLevel3) {
						String l3 = myElementL3.getAttribute("innerHTML");
						System.out.println("Level3:" + l3);
						ExcelReadWrite.wLevel1(r3, c3, l3);
						r3++;
					}
				}
			}
			// break;
		case LEVEL4:
			List<WebElement> ItemsID_Level3 = driver
					.findElements(By.xpath("//*[@id=\"nav-menu-item-11254\"]/ul/li/ul/li/ul/li"));
			int r4 = 1;
			int c4 = 3;
			ExcelReadWrite.wLevel1(0, 3, "LEVEL4");
			for (WebElement ElementID_L3 : ItemsID_Level3) {
				String itemID_L3 = ElementID_L3.getAttribute("id");
				System.out.println("Level 3 - Item ID:" + itemID_L3);

				List<WebElement> ItemsLevel4 = driver.findElements(By.xpath("//*[@id=\"" + itemID_L3 + "\"]/ul/li/a"));
				if (ItemsLevel4.isEmpty()) {
					continue;
				} else {
					for (WebElement myElementL4 : ItemsLevel4) {
						String l4 = myElementL4.getAttribute("innerHTML");
						System.out.println("Level4:" + l4);
						ExcelReadWrite.wLevel1(r4, c4, l4);
						r4++;
					}
				}
			}
			// break;
		}
	}

	@After
	public void writeReport(Scenario scenario) throws Exception {

		ExcelReadWrite.writeXcel();
		ExcelReadWrite.closeXcel();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.close();
	}
}
