import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HomePage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver ;
        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("field-keywords")).sendKeys("car accessories");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@data-index=\"4\"]//img")).click();
        Thread.sleep(2000);

        String expectedResult = driver.findElement(By.id("productTitle")).getText();
        System.out.println("This is Ex:"+ expectedResult);
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("sw-gtc")).click();
        Thread.sleep(2000);

        String actualResult =  driver.findElement(By.xpath("//span[@class=\"a-truncate-cut\"]")).getText();
        System.out.println("This is AC:"+ actualResult);

        // Check if expected text ends with ellipsis and adjust the comparison
        if (actualResult.endsWith("…")) {
            actualResult = actualResult.substring(0, actualResult.length() - 1); // remove the ellipsis
            expectedResult = expectedResult.substring(0, actualResult.length()); // truncate actual text to the same length as expected text
        }

        Assert.assertTrue(expectedResult.contains(actualResult),"Assertion of adding element to cart failed");


        driver.findElement(By.xpath("//a[@data-csa-c-content-id=\"nav_cs_gb\"]")).click();
        driver.findElement(By.xpath("//button[@aria-labelledby=\"see-more-departments-label\"]//a[@tabindex=\"-1\"]")).click();
        driver.findElement(By.xpath("//div[@data-csa-c-element-id=\"filter-departments-Grocery & Gourmet Food\"]")).click();
        driver.findElement(By.xpath("//div[@data-csa-c-element-id=\"filter-percentOff-10% off or more\"]")).click();
        driver.findElement(By.xpath("//div[@data-testid=\"B0CSWGJJTD\"]")).click();
        driver.findElement(By.xpath("//span[@id=\"dealsx_atc_btn\"]")).click();







    }

}
