package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TargetHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.target.com/");
    }
    // 2. Test method
    @Test
    public void testSearchBox() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("kids tablet");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[1]/form/button[2]")).click();
        Thread.sleep(5000);
        String expectedResult = "18 results for “kids tablet”";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div[1]/h2")).getText();
        System.out.println("Expected Result : "+expectedResult);
        System.out.println("Actual Result : "+actualResult);

        Assert.assertEquals(actualResult, expectedResult, "Test fail");
    }

    // 3. Close Browser method
    @AfterMethod
    public void closeBrowser() {
        driver.close();

    }

       }


