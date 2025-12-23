package Nov16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicProperties {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demoqa.com/dynamic-properties");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void enableButtonTest() {
		
		// enable button
		WebElement enableBtn = driver.findElement(By.id("enableAfter"));
		wait.until(ExpectedConditions.elementToBeClickable(enableBtn));
		
		Assert.assertTrue(enableBtn.isEnabled(), "enable in 5 seconds not enabled");
		
	}
	
	@Test
	public void colourChangeBtn() throws InterruptedException {
		WebElement btn = driver.findElement(By.id("colorChange"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
		
		String oldColour = btn.getCssValue("color");
		
		Thread.sleep(10000);
		
		String newColour = btn.getCssValue("color");
		
		 Assert.assertNotEquals(oldColour, newColour, "❌ Button color did NOT change");
	}
	
}
