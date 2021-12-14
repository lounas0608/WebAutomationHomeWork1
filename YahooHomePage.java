package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YahooHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.yahoo.com/");
    }
    // 2. Test method
    @Test
    public void testSearchUpdates() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"root_7\"]")).click();
        Thread.sleep(5000);
        String expectedResult = "New York";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"New_York_state\"]/td[1]")).getText();
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


