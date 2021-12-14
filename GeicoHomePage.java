package WebAutomationHomeWork1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeicoHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.geico.com/");
    }
    // 2. Test method
    @Test
    public void testContactUsUnderInformation() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"primary-header\"]/div[2]/ul/li[4]/a/span[5]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"primary-navigation\"]/div[4]/div/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedResult = "Contact Us";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"primary-navigation\"]/div[4]/div/div/div[3]/div[2]/h3/a")).getText();
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
