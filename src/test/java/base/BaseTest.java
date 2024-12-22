package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeMethod
	public void broswerStart() throws Exception {
		prop = new Properties();
		try (FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/utilities/config.properties")) {
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("baseURL"));
		driver.manage().deleteAllCookies(); // Deletes all the cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if (driver.getPageSource().contains("captcha")) {
			System.out.println("CAPTCHA detected! Please solve it manually.");
			Thread.sleep(4000); // Wait for 30 seconds for manual resolution
			WebElement clickBtn =
			driver.findElement(By.xpath("//a[@onclick='window.location.reload()']"));
			clickBtn.click();
			System.out.println("CAPTCHA solve it.");
//			js.executeScript("arguments[0].click();", clickBtn);

		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
