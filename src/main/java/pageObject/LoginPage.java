package pageObject;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElemnets

	@FindBy(xpath = "//div[@id='auth-error-message-box']/div/h4[@class='a-alert-heading']")
	WebElement actualErrortxt;

	@FindBy(id = "ap_email")
	WebElement txtUsernameFiled;

	@FindBy(id = "ap_password")
	WebElement txtPasswordFiled;

	@FindBy(id = "signInSubmit")
	WebElement signBtn;
	
	@FindBy(id="createAccountSubmit")
	WebElement createAccountBtn;

	
	
	// footer
	@FindBy(id = "navFooter")
	WebElement footerlocation;

// Actions Method

	public void enterUsernameData(String userName) {
		wait.until(ExpectedConditions.visibilityOf(txtUsernameFiled)).sendKeys(userName);
		// click continue Button
		driver.findElement(By.id("continue")).click();
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(txtPasswordFiled)).sendKeys(password);
		signBtn.click();
	}

	public String verifyErrorMessage() {
		String actualValue = actualErrortxt.getText();
		return actualValue;
	}

	public void scrollDownToFooter() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", footerlocation);
		Thread.sleep(4000);}
	
	public void openCreateAccountForm() {
		wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
	}
	
	public void validDataForCreateAccount() {
		
	}

}
