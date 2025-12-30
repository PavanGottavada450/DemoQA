package Dec29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePickerTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/date-picker");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void dateTest() throws InterruptedException {
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		
		driver.findElement(By.id("datePickerMonthYearInput")).clear();
		Thread.sleep(5000);
//        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("04/10/2000");
//        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.ENTER);
        
     // Fetch value and assert
        String dateValue = driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
        Assert.assertEquals(dateValue, "");
        
	}
	
}
