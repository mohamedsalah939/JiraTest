package Framwork.JiraTest.commonLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

	public static void LogoutFromProject(WebDriver driver) throws InterruptedException {
		// logout
		driver.findElement(By.className("css-74qtiq")).click();
		driver.findElement(By.className("css-5mekwu")).click();
	}
}
