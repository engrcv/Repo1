package stepDefinition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Steps {
	private static WebDriver driver = null;

	@Given("^For the URL: \"([^\"]*)\" find the list of images and save them in a \"([^\"]*)\"$")
	public void for_the_URL_find_the_list_of_images_and_save_them_in_a(String webPage, String folderPath)
			throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\Chrome Driver_v83\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(webPage);

		List<WebElement> listofItems = driver.findElements(By.cssSelector(
				"#desktopSearchResults > div.search-searchProductsContainer.row-base > section>ul>li>a>div>div>div>div>picture>img"));
		URL imageURL = null;
		int countF = 0;

		for (WebElement myElement : listofItems) {
			String j = myElement.getAttribute("src");
			System.out.println(j); //-> To see in console, the URL being picked 
			try {
				// generate url
				imageURL = new URL(j);
				// read url and retrieve image
				BufferedImage saveImage = ImageIO.read(imageURL.openStream());
				// Set the outfile location
				FileOutputStream outfile = new FileOutputStream(
						new File("c:/Users/User/eclipse-workspace/CucumberProject6/Images/Image" + countF++ + ".jpg"));
				// Image format can be changed to "png" or "gif" also
				ImageIO.write(saveImage, "jpg", outfile);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		throw new PendingException();
	}
}
