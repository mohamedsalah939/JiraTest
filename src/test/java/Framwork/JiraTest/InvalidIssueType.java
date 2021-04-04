package Framwork.JiraTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framwork.JiraTest.commonLibrary.*;

public class InvalidIssueType extends Initialize {
	public static Logger log = LogManager.getLogger(Initialize.class.getName());

	/*
	 * Try to choose ticket type not existing in the dropdown
	 */
	@Test(dataProvider = "setData")
	public void EnterInvalidIssueType(String Type) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = init();
		Login.LoginToProject(driver);
		CreationInitiation.Create(driver);
		// enter invalid option for issue type
		driver.findElement(By.id("request-or-issue-type-field-field")).sendKeys(Type);

		Boolean IsPresent = driver.findElements(By.id("assistive-text")).size() > 0;

		if (!IsPresent) {
			Assert.fail();
		}

		Logout.LogoutFromProject(driver);
	}

	@DataProvider
	public Object[][] setData() throws IOException {

		Object[][] ObjArray = dataDriven.FormatData("InvalidIssueType");
		return ObjArray;
	}

}
