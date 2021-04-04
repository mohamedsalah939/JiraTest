package Framwork.JiraTest.commonLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreationInitiation {
	/*
	 * Route to the need page and click on create button
	 */
	public static void Create(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='Jira Service Management']")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("createGlobalItemIconButton")).click();
		Thread.sleep(20000);
	}
}
