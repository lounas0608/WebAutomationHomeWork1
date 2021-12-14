package WebAutomationHomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PncBankHomePage {

        WebDriver driver;

        // 1. setUpBrowserMethod
        @BeforeMethod
        public void setUpBrowser() {
                String chromeDriverPath = "BrowserDrives/Windows/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", "BrowserDrives/Windows/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                // land on PNC home page
                driver.get("https://www.pnc.com/");
        }

        // 2. Test method
        @Test
        public void testSearchBox() throws InterruptedException {
                driver.findElement(By.xpath("//*[@id=\"experiencefragment-92a084ed3e\"]/div/div/div[1]/button")).click();
                driver.findElement(By.xpath("//*[@id=\"navSearchField\"]")).sendKeys("checking accounts");
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id=\"navSearchForm\"]/div/div[2]/input")).click();
                Thread.sleep(5000);
                String expectedResult = "2614 results returned for \"checking accounts\"";
                String actualResult = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div[2]/div/div/div/div[1]/div/div/div/div[1]/p")).getText();
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





