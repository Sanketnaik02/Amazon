package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ap_customer_name")
	WebElement txtName;

	@FindBy(id = "ap_phone_number")
	WebElement txtMobileNum;

	@FindBy(id = "ap_password")
	WebElement txtPassword;

	@FindBy(id = "continue")
	WebElement verifyMobileNumBtn;

	@FindBy(xpath = "//div[@id='auth-customerName-missing-alert']/div/div")
	WebElement errorTxtName;

	@FindBy(xpath = "//div[@id='auth-phoneNumber-invalid-phone-alert']/div/div")
	WebElement errormobileTxt;

	@FindBy(xpath = "//div[@id='auth-password-missing-alert']/div/div")
	WebElement errorpasswordTxt;

	public void enterValidData() {
		txtName.sendKeys("");
	}

	public void enterInValidData() {
		txtName.sendKeys("");
		txtMobileNum.sendKeys("asdfghjkl");
		txtPassword.sendKeys("");
		verifyMobileNumBtn.click();

	}

	public boolean checkEroorMessageUsername() {
		boolean errorUsernameTxt = wait.until(ExpectedConditions.visibilityOf(errorTxtName)) != null;
		return errorUsernameTxt;
	}

	public boolean checkEroorMessageMobile() {
		boolean errorMobileTxt = wait.until(ExpectedConditions.visibilityOf(errormobileTxt)) != null;
		return errorMobileTxt;
	}

	public boolean checkEroorMessagePassword() {
		boolean errorPasswordTxt = wait.until(ExpectedConditions.visibilityOf(errorpasswordTxt)) != null;
		return errorPasswordTxt;
	}

}
