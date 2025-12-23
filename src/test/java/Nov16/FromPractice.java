package Nov16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FromPractice {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/automation-practice-form");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void form() {
		WebElement name = driver.findElement(By.id("firstName"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", name);
		name.sendKeys("pavan");
		
		driver.findElement(By.id("lastName")).sendKeys("gottavada");
		driver.findElement(By.id("userEmail")).sendKeys("pavan@gmail.com");
		
		//radiobtn
		WebElement radioBtn = driver.findElement(By.id("gender-radio-1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioBtn);
		
		//mobile number
		driver.findElement(By.id("userNumber")).sendKeys("9874563210");
		
		//dataofbrith
		driver.findElement(By.id("dateOfBirthInput")).click();
		
		WebElement yearD = driver.findElement(By.className("react-datepicker__year-select"));
		Select dropDowny = new Select(yearD);
		dropDowny.selectByValue("1990");
		
		WebElement monthD = driver.findElement(By.className("react-datepicker__month-select"));
		Select dropDownM = new Select(monthD);
		dropDownM.selectByValue("1");
		
		driver.findElement(By.className("react-datepicker__day--013")).click();
		
		//subjects
		WebElement sub = driver.findElement(By.id("subjectsInput"));
		sub.click();
		sub.sendKeys("Math");
		sub.sendKeys(Keys.ENTER);
		
		  // STATE (dynamic dropdown)
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);
		
	}
	
}
