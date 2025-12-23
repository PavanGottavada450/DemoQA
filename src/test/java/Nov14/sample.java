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

public class sample {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/text-box");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void fillTextBoxForm() throws InterruptedException {
		driver.findElement(By.id("userName")).sendKeys("pavan");
		driver.findElement(By.id("userEmail")).sendKeys("pavan@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("hyderabad");
		driver.findElement(By.id("permanentAddress")).sendKeys("Eluru");
		
		WebElement submitBtn = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		submitBtn.click();

		Thread.sleep(1000);
		
		String outputName = driver.findElement(By.id("name")).getText();
//        String outputEmail = driver.findElement(By.id("email")).getText();

        Assert.assertTrue(outputName.contains("pavan"));
//        Assert.assertTrue(outputEmail.contains("gottavadapavan"));
	}
	
	
}
