package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[@class='a-text-normal']/span/span[@class='a-truncate-cut']")
	WebElement cartProductLbl;

	@FindBy(xpath = "//span[@data-action='quantity']/span/div/div[2]/span[@data-a-selector='value']")
	WebElement productQuantity;

// Action Methods
	public boolean ValidateProductIntoCartPage() {
		driver.navigate().refresh();
		return wait.until(ExpectedConditions.visibilityOf(cartProductLbl)).isDisplayed();
	}

	public boolean checkTwoProductQuantity() throws Exception {
		boolean flag = false;
		ProductPage pr = new ProductPage(driver);
		pr.enterProductPage("laptop", 1);
		pr.addProductIntoCart();
		driver.navigate().refresh();
		pr.addProductIntoCart();
		pr.backWithParentWindow();
		HomePage home = new HomePage(driver);
		home.openCartWindow();
		String proudctCount = productQuantity.getText();
		if (proudctCount.contains("2")) {
			flag = true;
		}
		return flag;
	}
}