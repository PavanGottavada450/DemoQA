package Dec24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FramesTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/frames");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    
    @Test
    public void verifyFrame1() {

        driver.switchTo().frame("frame1");

        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(text, "This is a sample page");

        driver.switchTo().defaultContent();
    }

    @Test
    public void verifyFrame2() {

        driver.switchTo().frame("frame2");

        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(text, "This is a sample page");

        driver.switchTo().defaultContent();
    }
}
