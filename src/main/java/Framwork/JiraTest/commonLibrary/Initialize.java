package Framwork.JiraTest.commonLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialize {

	/*
	 * Create driver object for Google Chrome browser Will implement WebDriver
	 * interface
	 */
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
