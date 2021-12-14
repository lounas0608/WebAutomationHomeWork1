package WebAutomationHomeWork1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WalmartHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {
        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // land on PNC home page
        driver.get("https://www.walmart.com/");
    }
    // 2. Test method
    @Test
    public void testSearchBox() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/div/form/div/input")).sendKeys("laptop");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/div/form/div/input")).submit();
        Thread.sleep(5000);
        String expectedResult = "Results for \"laptops\"";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/main/div/div[2]/div/div/div[1]/div/div/h2")).getText();
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