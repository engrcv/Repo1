package java10_fullScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Fullscreenshot {
	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Java_Selenium Training\\chromedriver_win32_v83\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
		//Take a full screenshot of webpage
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		//Save screenshot to .jpg file		
		ImageIO.write(screenshot.getImage(), "jpg",
				new File("F:\\Java_Selenium Training\\Full Screenshot\\FullScreenshot.jpg"));
	}
}
