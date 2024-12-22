package pageObject;

import java.awt.Desktop.Action;
import java.security.PublicKey;
import java.sql.Time;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement cartBtn;

	@FindBy(xpath = "//input[@id='add-to-cart-button' and @type='submit']")
	WebElement productCartBtn;

	@FindBy(css = "#add-to-cart-button")
	WebElement addToCartBtn2;

	@FindBy(xpath = "//img[@id='landingImage']")
	WebElement productImage;

	@FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']/span/span[2]")
	WebElement productPrice;

	@FindBy(xpath = "//div[@id='feature-bullets']/ul")
	WebElement productDiscription;

	@FindBy(css = "li[class='a-spacing-small item imageThumbnail a-declarative']")
	List<WebElement> multipleImages;

	@FindBy(xpath = "//div[@id='zoomWindow']/img")
	WebElement zoomImageSection;

	@FindBy(xpath = "//div[@id='imgTagWrapperId']/img")
	WebElement imageHoverPoint;

	@FindBy(xpath = "//div[@id='corePriceDisplay_desktop_feature_div']/div/span[3]/span[2]/span[@class='a-price-whole']")
	WebElement productPriceLbl;

	@FindBy(xpath = "//li[@id='color_name_0']")
	WebElement firstColor;

	@FindBy(xpath = "//li[@id='color_name_0']")
	WebElement secondColor;
	
	@FindBy(id="nav-cart-count-container")
	WebElement cartWindowBtn;

	// Action Methods
	public void enterProductPage(String searchBox, int numOfProduct) {
		// search product and view list
		HomePage home = new HomePage(driver);
		home.enterSearchbarValue(searchBox);

		// Add prodcut into the Search list
		home.clickProduct(numOfProduct);
		// Manage Multiple Windows
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String firstWindow = it.next();
		String secondWindow = it.next();

		// Switch to the new window
		driver.switchTo().window(secondWindow);
	}

	public void openCartWindow() {
		cartWindowBtn.click();
	}
	
	public void backWithParentWindow() {
		// Manage Multiple Windows
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String firstWindow = it.next();
		String secondWindow = it.next();

		// Switch to the new window
		driver.switchTo().window(firstWindow);

	}

	public void addProductIntoCart() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(10000);
		jse.executeScript("arguments[0].click();", productCartBtn);
//		wait.until(ExpectedConditions.elementToBeClickable(productCartBtn)).click();
		Thread.sleep(2000);
	}

	public String moveToParentWindow() {
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		return parentWindow;
	}

	public String moveToSecondWindow() {
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		return childWindow;
	}

	public boolean productTitleDisplayed() {
		boolean titleStatus = driver.getTitle().isBlank();
		return titleStatus;
	}

	public boolean productImageDisplayed() {
		boolean imageStatus = productImage.isDisplayed();
		return imageStatus;
	}

	public boolean productPriceDisplayed() {
		boolean priceStatus = productPrice.isDisplayed();
		return priceStatus;
	}

	public boolean productDiscriptionDisplayed() {
		boolean discriptionStatus = productDiscription.isDisplayed();
		return discriptionStatus;
	}

	public void multipleImagesDisplayed() throws Exception {
		int count = multipleImages.size();
		if (count > 1) {
			System.out.println("Validation Passed: Multiple product images are available.");
		} else {
			System.out.println("Validation Failed: Less than two product images found.");
		}
		// check image are displayed or not
		for (WebElement image : multipleImages) {
			image.isDisplayed();
			Thread.sleep(2000);
			System.out.println("Image are Displayed :");
		}

	}

	public boolean imageZoomOption() throws Exception {
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(imageHoverPoint));
		act.moveToElement(imageHoverPoint).perform();
		Thread.sleep(4000);
		boolean imageDisplayed = zoomImageSection.isDisplayed();
		return imageDisplayed;
	}

	public boolean productSpecification(String specificationName) {
		boolean flag = false;
		String actualString = driver
				.findElement(By.xpath("//table[@class='a-normal a-spacing-micro']/tbody/tr[5]/td[1]")).getText();
		if (actualString.contains(specificationName)) {
			flag = true;
		}
		return flag;
	}

	public boolean cartBtnFuncation() {
		boolean flag = false;
		WebElement cartLbl1 = driver
				.findElement(By.xpath("//div[@id='attachDisplayAddBaseAlert']//h4[contains(text(),'Added to cart')]"));

		boolean firstElement = cartLbl1.isDisplayed();
		if (firstElement) {
			flag = true;
		} else {
			System.out.println("Cart Function not working");
		}
		return flag;
	}

	public boolean priceUpdateFunction() {
		boolean flag = false;

		String firstProductPrice = productPriceLbl.getText();
		wait.until(ExpectedConditions.elementToBeClickable(firstColor)).click();
		String secondProductPrice = productPriceLbl.getText();
		wait.until(ExpectedConditions.elementToBeClickable(secondColor)).click();
		if (firstProductPrice != secondProductPrice) {
			flag = true;
		}
		return flag;
	}

	public String getProductPrice() {
		String productPrice = productPriceLbl.getText();
		return productPrice;
	}
	
}
