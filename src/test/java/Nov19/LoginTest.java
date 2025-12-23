package Nov19;

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

public class LoginTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demoqa.com/login");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "loginData", dataProviderClass = ExcelUtil.class)
	public void Login(String username, String password) throws InterruptedException {
		
		WebElement ele = driver.findElement(By.id("userName"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		
		ele.sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
//		Thread.sleep(5000);
		wait.until(ExpectedConditions.urlContains("profile"));
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
		
		
		driver.findElement(By.id("submit")).click();
	}
	
}
