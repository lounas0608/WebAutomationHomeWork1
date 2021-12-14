package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.google.com/");
    }
    // 2. Test method
    @Test
    public void testSearchNySoftLlc() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input")).sendKeys("NY Soft Services LLC");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")).submit();
        Thread.sleep(5000);
        String expectedResult = "New York Software Services LLP";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).getText();
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
