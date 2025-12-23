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

public class LinksCheck {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/links");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void linksCheck() throws InterruptedException {
		
		//home link
		WebElement sLink = driver.findElement(By.id("simpleLink"));
		
		try {
			sLink.click();
		}catch(Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", sLink);
		}
		
		//switch to tab
		for(String tab : driver.getWindowHandles()) {
			driver.switchTo().window(tab);
		}
		
		Assert.assertTrue(driver.getCurrentUrl().contains("demoqa"), "Home link not responded");
		
		// Close new tab and return to main
        driver.close();
        for(String tab : driver.getWindowHandles()) {
        	driver.switchTo().window(tab);
        }
        
        
        // api link
         WebElement apiLink =  driver.findElement(By.id("created"));
        
         try {
        	 apiLink.click();
         }catch(Exception e) {
        	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apiLink);
         }
        
        WebElement apiMsg = driver.findElement(By.id("linkResponse"));
        String text = apiMsg.getText();
        
        Assert.assertTrue(text.toLowerCase().contains("status"), "No API response displayed");
        
	}
	
	
	
}
