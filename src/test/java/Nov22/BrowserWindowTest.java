package Nov22;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserWindowTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyNewTab() {
	        
	        // Store parent window ID
	        String parentWindow = driver.getWindowHandle();
	
	        // Click "New Tab" button
	        driver.findElement(By.id("tabButton")).click();
	
	        // Get all windows
	        Set<String> windows = driver.getWindowHandles();
	
	        // Switch to new tab
	        for (String win : windows) {
	            if (!win.equals(parentWindow)) {
	                driver.switchTo().window(win);
	
	                // Assert heading text
	                String heading = driver.findElement(By.id("sampleHeading")).getText();
	                Assert.assertEquals(heading, "This is a sample page", "Heading mismatch!");
	
	                // Close new tab
	                driver.close();
	            }
	        }
	
	        // Switch back to parent
	        driver.switchTo().window(parentWindow);
	
	        // Assert we are back on browser-windows page
	        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/browser-windows");
	    }
	
}
