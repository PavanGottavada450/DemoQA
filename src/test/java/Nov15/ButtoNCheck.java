package Nov15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtoNCheck {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/buttons");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void buttoncheck() {
		
		Actions action = new Actions(driver);
		
		//doubleClick
		WebElement doubleBtn = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(doubleBtn).perform();
		
		WebElement doubleClickMsg = driver.findElement(By.id("doubleClickMessage"));
		Assert.assertEquals(doubleClickMsg.getText(), "You have done a double click");
		
		//RightClick
		WebElement RightClickBtn = driver.findElement(By.id("rightClickBtn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RightClickBtn);
		action.contextClick(RightClickBtn).perform();
		
		WebElement RightClickMsg = driver.findElement(By.id("rightClickMessage"));
		Assert.assertEquals(RightClickMsg.getText(), "You have done a right click");
		
		
		//DynamicClick
		WebElement DynamicClick = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		try {
			DynamicClick.click();
		}catch(Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", DynamicClick);
		}
		
		WebElement DynamicClickMsg = driver.findElement(By.id("dynamicClickMessage"));
		Assert.assertEquals(DynamicClickMsg.getText(), "You have done a dynamic click");
	}
	
}
