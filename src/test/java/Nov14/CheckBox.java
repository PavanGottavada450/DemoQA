package Nov14;

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

public class CheckBox {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/checkbox");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void checkBox() throws InterruptedException {
		WebElement homeCheckBox = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
		
		try {
			homeCheckBox.click();
		}catch(Exception e) {
			((JavascriptExecutor) driver).executeScript("argument[0].click();", homeCheckBox);
		}
		
		Thread.sleep(500);
		
		WebElement result = driver.findElement(By.id("result"));
		
		String output = result.getText();
		
		Assert.assertTrue(output.toLowerCase().contains("home"), "Home checkBox not Selected!");
		
	}
	
}
