package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.RegisterPage;

public class LoginAndRegistration extends BaseTest {

	boolean flag = false;
	public HomePage home;
	LoginPage login;
	RegisterPage register;

//	// Initialize Page Objects in @BeforeMethod to ensure the driver is ready
	@BeforeMethod
	public void setUpPageObjects() {

		home = new HomePage(driver); // Pass initialized driver to HomePage
		login = new LoginPage(driver); // Pass initialized driver to LoginPage
		register = new RegisterPage(driver);// Pass initialized driver to RegisterPage

	}

	// test case one
	// 1. Verify that a registered user can successfully log in with valid
	// credentials.
	@Test
	public void validateRegisteredUserSuccessfullyLogin() {
		// click on sign window
//		HomePage home = new HomePage(driver); // Pass initialized driver to HomePage
//		LoginPage login = new LoginPage(driver); // Pass initialized driver to LoginPage
		home.openLoginWindow();
		// Enter Valid Data
		// Username Data
		login.enterUsernameData(prop.getProperty("validUserIDAndNumber"));
		// Password data
		login.enterPassword(prop.getProperty("validPassword"));
		String id = "nav-link-accountList-nav-line-1";
		String actualName = driver.findElement(By.id(id)).getText();
		System.out.println(actualName);
		if (actualName.contains("Sanket")) {
			flag = true;
		}
		Assert.assertTrue(flag, "Login Credintial failed");

	}

	// Test Case 2
	@Test
	public void validateErrorMessageForInvalidCredentials() {

		// click on sign window
		home.openLoginWindow();
		// Enter Valid Data
		// Username Data
		login.enterUsernameData(prop.getProperty("inValidUserIDAndNumber"));
		//
		String actualMessage = login.verifyErrorMessage();
		System.out.println("Error message : " + actualMessage);
		String expectedMessage = "Incorrect";
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
		}
		// Validate via Asseration
		Assert.assertTrue(flag, "Login filed Error Message not matched");
	}

	// test Case 3
	@Test
	public void validateUnregisteredUserCannotLogin() throws Exception {

		// click on sign window
		home.openLoginWindow();
		// Enter Valid Data
		// Username Data
		login.enterUsernameData(prop.getProperty("inValidUserIDAndNumber"));
		//
		String actualMessage = login.verifyErrorMessage();
		System.out.println("Error message : " + actualMessage);
		String expectedMessage = "Incorrect";
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
		}
		// Validate via Asseration
		Assert.assertTrue(flag, "Login filed Error Message not matched");
	}

	// test Case 4
	@Test
	public void validatePasswordFieldTest() {

		// open Login Window
		home.openLoginWindow();
		// enter valid username
		login.enterUsernameData(prop.getProperty("validUserIDAndNumber"));

		// check password type
		String type = driver.findElement(By.id("ap_password")).getAttribute("type");
		if (type.contains("password")) {
			flag = true;
			System.out.println("Test Case Passed Password is Masked Field");
		} else {
			System.out.println("Test Case is Failed");
		}
		Assert.assertTrue(flag, "Test case failed because Password field is not Masked");
	}

	// Test Case 5
	@Test
	public void verifyNewUserCanRegisterWithValidData() {
		// Open Create Account Form
		home.openLoginWindow();
		login.openCreateAccountForm();
		register.enterInValidData();
		Assert.assertTrue(register.checkEroorMessageUsername());
		Assert.assertTrue(register.checkEroorMessageMobile());
		Assert.assertTrue(register.checkEroorMessagePassword());

	}

	// Test Case 6
	@Test
	public void validateUserLogOutFunction() {
		validateRegisteredUserSuccessfullyLogin();
		home.userLogout();
		String acutalSignInOption = driver.findElement(By.xpath("//div[@class='a-box-inner a-padding-extra-large']/h1"))
				.getText();
		if (acutalSignInOption.contains("Sign")) {
			flag = true;
		}
		assertTrue(flag, "SignIn Option Not showing user not LogOut");
	}
	
	
}
