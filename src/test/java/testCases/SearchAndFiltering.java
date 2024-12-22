package testCases;

import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.HomePage;

public class SearchAndFiltering extends BaseTest {

	boolean flag = false;
	HomePage home;
	WebDriverWait wait;

	// Initialize Page Objects in @BeforeMethod to ensure the driver is ready
	@BeforeClass
	public void setUpPageObjects() {

		home = new HomePage(driver); // Pass initialized driver to HomePage
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// Test Case 1 : 9. Verify that the search bar accepts input and returns results
	// for valid terms.
	@Test
	public void verifyValidInputInSearchbar() {
		// Enter in search valid Input Eg. (Computer, Mobile Phones)
		String SearchValue = "Laptop";
		home.enterSearchbarValue(SearchValue);
		// validate the Input results
		String actualInputValue = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
		if (actualInputValue.contains(SearchValue)) {
			flag = true;
		}
		assertTrue(flag, "Input Search Value Didn't not matched");
	}

	// Test Case 2 : Check for no results when an invalid product is searched.

	@Test
	public void verifyInvalidInputInSearchbar() {
		// Enter Invalid Input in searchBar
		home.enterSearchbarValue("nonexistentproduct12345");
		// Validate Invalid input
		WebElement errorMsg = driver.findElement(By.xpath("//h2[@class='rhf-sign-in-title']"));
		boolean ErrorMsg = wait.until(ExpectedConditions.visibilityOf(errorMsg)).isDisplayed();
//		if (!ErrorMsg) {
//			Assert.assertTrue(ErrorMsg, "test Case Failed ");
//		}
	}
	
	
	
	

}
