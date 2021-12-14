package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JcpennyHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.jcpenney.com/");
    }
    @Test
    public void testAddToShippingCart () throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"searchInputId\"]")).sendKeys("xbox");
        driver.findElement(By.xpath("//*[@id=\"typeaheadInputContainer\"]/div/button")).click();
        Thread.sleep(5000);
        //Add to Cart:
        driver.findElement(By.xpath("//*[@id=\"GlobalOptions-AddToCart\"]/button/div/p[2]")).click();
        Thread.sleep(5000);

        String expectedResult = "  1 Item Added";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"atPanelContent\"]/div[1]/div/section/section/section[1]/div[1]/div/div/div[3]/div[1]")).getText();
        System.out.println("Expected Result : " + expectedResult);
        System.out.println("Actual Result : " + actualResult);
        Assert.assertEquals(actualResult, expectedResult, "1 Item Added");
    }

    // 3. Close Browser method
    @AfterMethod
    public void closeBrowser () {
           driver.close();
    }
}





