package Framwork.JiraTest.commonLibrary;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	/*
	 * Login to Jira using email and password
	 */
	public static void LoginToProject(WebDriver driver) throws InterruptedException, IOException {

		String password = DecryptPassword.GetDecryptedPW();
		// Read the email from the excel sheet
		ArrayList<String> data = dataDriven.getData("Login", "Password");
		String email = data.get(1);
		// navigate to URL in the browser
		driver.get("https://id.atlassian.com/login/");
		Thread.sleep(50000);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(email);
		Thread.sleep(50000);
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(30000);
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(30000);
	}

}
