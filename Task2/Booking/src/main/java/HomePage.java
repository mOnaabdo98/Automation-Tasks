import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
    protected WebDriver driver;
    private By fromCity = By.xpath("//div[@id=\"fromCity_chosen\"]//span");
    private By fromCitySelected = By.xpath("//ul[@class=\"chosen-results\"]//li[@data-option-array-index=\"112\"]");

    private By toCity = By.xpath("//div[@id=\"toCity_chosen\"]//span");
    private By toCitySelected = By.xpath("//ul[@class=\"chosen-results\"]//li[@data-option-array-index=\"13\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromCity() throws InterruptedException {
        // From City
        WebElement fromCityElement = driver.findElement(fromCity);
        fromCityElement.click();
        Thread.sleep(3000);

        WebElement fromCitySelectedElement = driver.findElement(fromCitySelected);
        fromCitySelectedElement.click();
        Thread.sleep(2000);


        // TO City
        WebElement toCityElement = driver.findElement(toCity);
        toCityElement.click();
        Thread.sleep(2000);

        WebElement toCitySelectedElement = driver.findElement(toCitySelected);
        toCitySelectedElement.click();
        Thread.sleep(2000);

    }
}