package utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reporter {

	private static List<Result> details;
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = "C:\\Users\\User\\eclipse-workspace\\CucumberProject9\\report_template.html";

	public Reporter() {
	}

	public static void initialize() {
		details = new ArrayList<Result>();
	}

	public static void report(String actualValue, String expectedValue, String screenPath) {
		if (actualValue.equals(expectedValue)) {
			Result r = new Result("Pass", "Actual value '" + actualValue + "' matches expected value ", screenPath);
			System.out.println("details:" + r);
			details.add(r);
			System.out.println("record added");
		} else {
			Result r = new Result("Fail",
					"Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "' ",
					screenPath);
			details.add(r);
			System.out.println("Invalid record added");
		}
	}

	public static void showResults() {
		for (int i = 0; i < details.size(); i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}

	public static void writeResults(String scenarioName) {

		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
				for (int i = 0; i < details.size(); i++) {
				System.out.println("screen link:" + details.get(i).getScreen());
				reportIn = reportIn.replaceFirst(resultPlaceholder,
						"<tr><td>" + Integer.toString(i + 1) + "</td><td>" + details.get(i).getResult() + "</td><td>"
								+ details.get(i).getResultText() + "<br><a href=\"" + details.get(i).getScreen()
								+ "\">ScreenShot</a></td></tr>" + resultPlaceholder);
			}
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String reportPath = "C:\\Users\\User\\eclipse-workspace\\CucumberProject9\\report_" + currentDate + ".html";
			System.out.println("OUTFILE Path:" + reportPath);
			// Create or Append the OutFile with Current Date
			if (Files.notExists(Paths.get(reportPath))) {
				Files.write(Paths.get(reportPath), reportIn.getBytes(), StandardOpenOption.CREATE);
			} else {
				Files.write(Paths.get(reportPath), reportIn.getBytes(), StandardOpenOption.APPEND);
			}
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.getMessage());
		}
	}
}