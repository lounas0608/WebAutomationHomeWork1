package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CnnHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.cnn.com/");
    }
    // 2. Test method
    @Test
    public void testSearchNewsArticleOnCnn() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"menuButton\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"header-search-bar\"]")).sendKeys("QA Engineer");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[2]/div/div[1]/form/button/div[1]")).click();
        Thread.sleep(5000);
        String expectedResult = "WhatsApp founder: Food stamps to billionaire";
        String actualResult= driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[2]/div/div[3]/div[4]/div[2]/h3/a")).getText();
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