package testCases;

import static org.testng.Assert.assertTrue;

import java.awt.dnd.DropTarget;
import java.time.Duration;
import java.util.Iterator;
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

public class CartFuncationality extends BaseTest {

	boolean flag = false;
	HomePage home;
	CartPage cart;
	ProductPage product;

	@BeforeMethod
	public void setupPageObject() {
		home = new HomePage(driver);
		cart = new CartPage(driver);
		product = new ProductPage(driver);
	}

	// Test Case 1 : Verify that products can be added to the cart.
	@Test(priority = 0)
	public void ValidateProductAddedToCart() throws Exception {
		// search product and view list

		product.enterProductPage("Laptop", 1);
		product.addProductIntoCart();

		// Now Switch to main window
		product.backWithParentWindow();
		System.out.println("Switch Window to Parent Window : " + product.moveToParentWindow());
		home.openCartWindow();
		Assert.assertTrue(cart.ValidateProductIntoCartPage(), "Product Not Added in Cart ");

	}

	// Test Case 2 : Check if the cart updates when the same item is added multiple
	// times.
	@Test(priority = 1)
	public void verifyCartProductQuantity() throws Exception {

		flag = cart.checkTwoProductQuantity();

		assertTrue(flag, "Two Product Not Added in Cart");
	}
	
	
	// Test Case 3 : Validate that the cart reflects the correct quantity and total price.
	@Test
	public void verifyProductQuantityAndPrice() throws Exception {
		// Enter the product into the Cart
		ProductPage product = new ProductPage(driver);
		product.enterProductPage("Mobile Phones", 1);
		// check product Price
		String actualPrice = product.getProductPrice();
		System.out.println("actual Price : "+actualPrice);
		product.addProductIntoCart(); //product add in to the Cart
		product.backWithParentWindow();
		product.openCartWindow(); // open Cart Window
		WebElement pricElement = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
		System.out.println(pricElement.getText());
		if (actualPrice.contains(pricElement.getText())) {
			System.out.println("Price Are same");
		}else {
			System.out.println("Price Are different");
		}
		
		
		
	}
	
}
