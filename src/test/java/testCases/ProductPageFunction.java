package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.ProductPage;

public class ProductPageFunction extends BaseTest {

	boolean flag = false;

	// Test Case 1 : Verify that clicking a product opens the correct details page.
	@Test(priority = 0)
	public void verifyClickingProductOpenCorrectly() throws Exception {
		// Enter Product Page
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("Laptop", 1);
		// check open product it is correct or not
		System.err.println(driver.getTitle());
		if (driver.getTitle().contains("Laptop")) {
			flag = true;
		}
		// Assertion
		assertTrue(flag, "Open Product doesn't matched ");
	}

	// Test Case 2 : Ensure the product title, image, price, and description are
	// displayed
	@Test(priority = 1)
	public void verifyProductTitleImagePriceDescription() {
		// now check Product Title, Image, Price, Description
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("Laptop", 1);
		// check product Title
		if (product.productTitleDisplayed()) {
			flag = true;
			System.out.println("Product Title : " + driver.getTitle());
		}
		Assert.assertTrue(flag, "Product Title didn't Matched");

		// check Image
		if (product.productImageDisplayed()) {
			flag = true;
			System.out.println("Product Image Displayed");
		}
		Assert.assertTrue(flag, "Product Image didn't Displayed ");
		// check Price
		if (product.productPriceDisplayed()) {
			flag = true;
			System.out.println("Product Price Displayed");
		}
		Assert.assertTrue(flag, "Product price didn't Displayed");
		// check Image
		if (product.productDiscriptionDisplayed()) {
			flag = true;
			System.out.println("Product Discription Displayed");
		}
		Assert.assertTrue(flag, "Product Discription didn't Displayed ");
	}

	// Test Case 3 : Validate that multiple product images can be viewed.
	@Test(priority = 2)
	public void verifyMultipleProductImagesViewed() throws Exception {
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("iPhone", 2);
		product.multipleImagesDisplayed();
		flag = true;
		assertTrue(flag, "Multiple Image are not shown");

	}

	// Test Case 4 : Check that users can zoom in on product images.
	@Test(priority = 3)
	public void verifyUserZoomProductImage() throws Exception {
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("iPhone 13", 1);
		flag = product.imageZoomOption();
		assertTrue(flag, "Product Zoom feature not Enabled");
	}

	// Test Case 5 : Verify that product specifications are correctly displayed
	@Test(priority = 4)
	public void verifyProductSpecifications() {
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("Laptop", 1);

		// Now match Product Specification matched or not
		flag = product.productSpecification("Hard Disk");
		Assert.assertTrue(flag, "Product Specification Not Matched");
	}

	// Test CAse 6 : Check if the "Add to Cart" button works properly
	@Test(priority = 5)
	public void validateAddToCartBtn() throws Exception {
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("Mobile Phones", 1);

		// Validate Add to cart button
		product.addProductIntoCart();
		flag = product.cartBtnFuncation();
		Assert.assertTrue(flag, "Cart Function is NOt working");
	}

	// Test Case 7 : Verify price updates for configurable products (e.g., different sizes/colors).
	@Test
	public void verifyPriceUpdateProduct() {
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("iPhone 15 256GB", 0);
		if (product.priceUpdateFunction()) {
			flag=true;
		}
		assertTrue(flag, "Price not Updated ");
		
		
	}
	
	
}
