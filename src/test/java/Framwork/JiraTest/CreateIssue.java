package Framwork.JiraTest;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framwork.JiraTest.commonLibrary.*;

public class CreateIssue extends Initialize {
	public static Logger log = LogManager.getLogger(Initialize.class.getName());

	/*
	 * Create new ticket with filling all needed fields
	 */
	@Test(dataProvider = "setData")
	public void CreateJiraIssue(String RequestType, String Summary, String Year, String Month, String Day,
			String Description, String Blocks, String Priority) throws InterruptedException, IOException {

		WebDriver driver = init();
		Login.LoginToProject(driver);
		CreationInitiation.Create(driver);
		Creation.CreateTicket(driver, RequestType, Summary, Year, Month, Day, Description, Blocks, Priority);
		// Click on create button
		driver.findElement(By.id("create-issue-submit")).click();

		Logout.LogoutFromProject(driver);
	}

	@DataProvider
	public Object[][] setData() throws IOException {

		Object[][] ObjArray = dataDriven.FormatData("CreateIssue");
		return ObjArray;
	}

}
