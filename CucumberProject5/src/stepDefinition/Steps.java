package stepDefinition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Steps {
	private static WebDriver driver = null;

	@Given("^For the URL: \"([^\"]*)\" find the list of hyperlinks and validate them$")
	public void for_the_URL_find_the_list_of_hyperlinks_and_validate_them(String homePage) throws Throwable {
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\Chrome Driver_v83\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(homePage);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			System.out.println(url);
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
		throw new PendingException();
	}
}
