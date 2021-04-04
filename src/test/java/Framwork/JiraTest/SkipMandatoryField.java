package Framwork.JiraTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Framwork.JiraTest.commonLibrary.*;

public class SkipMandatoryField extends Initialize {
	public static Logger log = LogManager.getLogger(Initialize.class.getName());

	/*
	 * Try to create issue without filling the mandatory fields and make sure it is
	 * not created
	 */
	@Test
	public boolean SkipMandatoryFieldWhileCreation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = init();
		Login.LoginToProject(driver);
		CreationInitiation.Create(driver);
		/*
		 * Click on create button without filling summary In the creation form we have
		 * only one mandatory field called summary so I will open the form and click on
		 * create without filling it
		 */
		driver.findElement(By.id("create-issue-submit")).click();

		if (driver.findElement(By.xpath("(//div[text()='You must specify a summary of the issue.'])")).isDisplayed()) {
			return true;
		}

		return false;

	}

}
