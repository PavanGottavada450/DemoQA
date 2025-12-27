package Dec27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ModalDialogsTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demoqa.com/modal-dialogs");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyModalDialog() {
		
		driver.findElement(By.id("showSmallModal")).click();
		
		WebElement modalBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
	
		Assert.assertEquals(modalBody.getText(), "This is a small modal. It has very less content");
		
		driver.findElement(By.id("closeSmallModal")).click();
	}
	
	
	
}
