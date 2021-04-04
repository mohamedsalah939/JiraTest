package Framwork.JiraTest;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framwork.JiraTest.commonLibrary.*;

public class ReadIssue extends Initialize {
	public static Logger log = LogManager.getLogger(Initialize.class.getName());

	/*
	 * Search for a previous created issue using the key
	 */
	@Test(dataProvider = "setData")
	public void SearchForIssue(String IssueKey) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		// Create driver object for Google Chrome browser
		// Will implement WebDriver interface
		WebDriver driver = init();
		Login.LoginToProject(driver);

		Thread.sleep(20000);
		driver.get("https://khazna.atlassian.net/jira/servicedesk/projects/GSP/queues/custom/4");

		/*
		 * select all elements that have class of the tickets key replacing space in the
		 * class name because selenium cannot read compound class
		 */
		List<WebElement> keys = driver.findElements(By.cssSelector("div.issuekey.sc-dArhMf.iAoUDz"));
		// Get the list size
		int count = keys.size();
		int flag = 0;
		// Loop on the cells to get ticket with key 'GPS-3'
		for (int i = 0; i < count; i++) {
			String DayText = keys.get(i).getText();

			if (DayText.equalsIgnoreCase(IssueKey)) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			Assert.fail("Ticket not found");
		}
		Logout.LogoutFromProject(driver);

	}

	@DataProvider
	public Object[][] setData() throws IOException {

		Object[][] ObjArray = dataDriven.FormatData("ReadIssue");
		return ObjArray;
	}
}
