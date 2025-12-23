package Nov15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioBtn {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/radio-button");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void raidoBtn() throws InterruptedException {
		WebElement yesOption = driver.findElement(By.id("yesRadio"));
		
		try {
			yesOption.click();
		}catch(Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesOption);
		}
		
		Thread.sleep(500);
		
		WebElement result = driver.findElement(By.xpath("//span[@class='text-success']"));
		
		Assert.assertEquals(result.getText(), "Yes", "Yes button not clicked");
		
		WebElement impressiveOption = driver.findElement(By.id("impressiveRadio"));
		
		try {
			impressiveOption.click();
		}catch(Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", impressiveOption);
		}
		
		Thread.sleep(500);
		
		Assert.assertEquals(result.getText(), "Impressive", "impressive button not selected");
		
	}
	
}
