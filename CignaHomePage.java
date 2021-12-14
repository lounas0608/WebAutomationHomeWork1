package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CignaHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.cigna.com/");
    }
    // 2. Test method
    @Test
    public void testContactUsUnderInformation() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"search-desktop\"]")).sendKeys("Dental");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"ssi-includes\"]/div/header/div[2]/nav[1]/div/ul/li[4]/form/div/div/span/button")).click();
        Thread.sleep(5000);

        // Verify expected result and actual result match
        String expectedResult = "Dental";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"main-template\"]/div[1]/strong")).getText();
        System.out.println("Expected Result : " + expectedResult);
        System.out.println("Actual Result : " + actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Test fail");
    }

    // 3. Close Browser method
    @AfterMethod
    public void closeBrowser() {
        driver.close();












        }
    }


