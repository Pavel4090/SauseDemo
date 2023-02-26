package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private static final String FIRST_NAME = "Pavel";
    private static final String LAST_NAME = "Ivanov";
    private static final String ZIP_CODE = "12345";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverview goToCheckoutOverview() {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(FIRST_NAME);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(LAST_NAME);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(ZIP_CODE);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        return new CheckoutOverview(driver);
    }
}
