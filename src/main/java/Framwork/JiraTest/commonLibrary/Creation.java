package Framwork.JiraTest.commonLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Creation {
	/*
	 * Create new Ticket and the needed fields
	 */
	public static void CreateTicket(WebDriver driver, String RequestType, String Summary, String Year, String Month,
			String Day, String Description, String Blocks, String Priority) throws InterruptedException {

		/*
		 * Choosing the ticket type The best practice here is to write the first letters
		 * and loop on the options using the class name or ID but the problem that each
		 * option has a different class name and ID
		 */
		driver.findElement(By.id("request-or-issue-type-field-field")).sendKeys(RequestType);
		driver.findElement(By.id("ask-a-question-16")).click();

		// Add the ticket Summary
		driver.findElement(By.id("summary")).sendKeys(Summary);

		// choose the due date (28 August 2022)
		// Click on calendar button
		driver.findElement(By.id("duedate-trigger")).click();

		// choose year (click till you reach year 2022
		String dateTitle = driver.findElement(By.className("title")).getText().toString();
		while (!dateTitle.contains(Year)) {
			// replacing space in the class name because selenium cannot read compound class
			driver.findElement(By.cssSelector("td.button.nav:nth(2)")).click();
		}
		// choose Month (click till you reach month August
		while (!dateTitle.contains(Month)) {
			driver.findElement(By.cssSelector("td.button.nav:nth(1)")).click();
		}

		/*
		 * select all elements that have class contains day as each day has different
		 * class name example : 'day day-6', day day-7
		 */
		List<WebElement> days = driver.findElements(By.xpath("td[contains(@class,'day')]"));
		// Get the list size
		int count = days.size();
		// Loop on the days to select day 28
		for (int i = 0; i < count; i++) {
			String DayText = days.get(i).getText();

			if (DayText.equalsIgnoreCase(Day)) {
				days.get(i).click();
				break;
			}
		}

		// Add the description
		driver.findElement(By.id("description-wiki-edit")).sendKeys("Description");

		// Add blocks using static drop down
		Select blocks = new Select(driver.findElement(By.id("issuelinks-linktype")));
		blocks.selectByVisibleText(Blocks);
		/*
		 * Choosing the priority The best practice here is to write the first letters
		 * and loop on the options using the class name or ID but the problem that each
		 * option has a different class name and ID
		 */
		driver.findElement(By.id("priority-field")).sendKeys(Priority);
		driver.findElement(By.id("high-20")).click();
	}
}
