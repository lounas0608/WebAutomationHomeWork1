package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GitHubHomePage {
    WebDriver driver;

    // 1. setUpBrowserMethod
    @BeforeMethod
    public void setUpBrowser() {

        String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Land on Target Home Page
        driver.get("https://www.github.com/");
    }
        @Test
        public void testSignIn () throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("lounas.ayouni@gmail.com");
           // Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ninja2409!");
          //  Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[12]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id=\"repos-container\"]/ul/li[6]/div/div/a")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div[7]/div[2]/span/a")).click();
            Thread.sleep(5000);
            String expectedResult = "Automation";
            String actualResult = driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div[1]/div[2]/div/strong")).getText();
            System.out.println("Expected Result : " + expectedResult);
            System.out.println("Actual Result : " + actualResult);
            Assert.assertEquals(actualResult, expectedResult, "Test fail");
        }

        // 3. Close Browser method
        @AfterMethod
        public void closeBrowser () {
         //   driver.close();
        }
    }



