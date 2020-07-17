package pageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class readFileData {

	Properties prop;

	// public static void main(String[] args) {
	public String rFile() {
		File file = new File("C:/Users/User/eclipse-workspace/SalesForce/dataFile.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * WebDriver driver = new FirefoxDriver();
		 * 
		 * driver.get(prop.getProperty("URL"));
		 * driver.findElement(By.id("Email")).sendKeys(prop.getProperty("username"));
		 * driver.findElement(By.id("Passwd")).sendKeys(prop.getProperty("password"));
		 * driver.findElement(By.id("SignIn")).click();
		 */

	/*	System.out.println("URL ::" + prop.getProperty("URL"));
		System.out.println("User name::" + prop.getProperty("username"));
		System.out.println("Password::" + prop.getProperty("password"));*/
		 String URL = prop.getProperty("URL");
		// return URL;
		return URL;

	}

	public String getURL() {
		String url = prop.getProperty("URL");
		//String Url = "https://login.salesforce.com/";
		if (url != null)
			return url;
		else
			throw new RuntimeException("URL not specified in the Configuration.properties file.");
	}

	public String getUser() {
		String user = prop.getProperty("username");
		if (user != null)
			return user;
		else
			throw new RuntimeException("username not specified in the Configuration.properties file.");
	}

	public String getPwd() {
		String pwd = prop.getProperty("password");
		String key = "lockUnlock";
        String strEncryptedString = StringEncrypt.encryptXOR(pwd, key);
        System.out.println("Encrypted string: " + strEncryptedString);
        //String decodedPwd = StringEncrypt.decryptXOR(strEncryptedString, key);
        //System.out.println("Decrypted string: " + decodedPwd);
		//return strEncryptedString;	
        if (pwd != null)
        return strEncryptedString;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
}