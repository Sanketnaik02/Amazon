package pageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement btnSignLogin;

	@FindBy(id = "nav-item-signout")
	WebElement btnSignOut;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBarTxt;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchBarBtn;

	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement cartBtn;

	@FindBy(xpath = "//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']")
	List<WebElement> productList;

// Action Method
	public void openLoginWindow() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSignLogin)).click();
//		btnSignLogin.click();	
	}

	// logout function
	public void userLogout() {
		Actions act = new Actions(driver);
		act.moveToElement(btnSignLogin).perform();
		wait.until(ExpectedConditions.elementToBeClickable(btnSignOut)).click();
	}

	// Input searchBar Value
	public void enterSearchbarValue(String text) {
		searchBarTxt.sendKeys(text);
		searchBarBtn.click();
	}

	// Open Cart Page
	public void openCartWindow() {
		cartBtn.click();
	}

	// Add to product in the Cart
	public void clickProduct(int productNum) {

		List<WebElement> productList = driver
				.findElements(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']"));
		productList.get(productNum).click();

	}

	// Window Handle
	public String moveToParentWindow() {
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindowId = it.next();
		System.out.println("This is Parent Window ID :" + parentWindowId);
		return parentWindowId;
	}

	public String twoWindowHandle() {
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		System.out.println("parent window " + childWindowId);
		return childWindowId;
	}

}
