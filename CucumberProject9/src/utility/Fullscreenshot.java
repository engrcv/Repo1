package utility;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Fullscreenshot {

	public static void takeScreenshot(WebDriver driver, String scenarioName) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		System.out.println("screenshot taken");
		ImageIO.write(screenshot.getImage(), "jpg",
				new File("F:\\Full_Screenshot\\" + scenarioName + "Screenshot.jpg"));
	}
}
