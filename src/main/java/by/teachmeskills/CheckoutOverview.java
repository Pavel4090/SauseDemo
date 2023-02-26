package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview extends BasePage {

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public CheckoutComplete goToCheckoutFinish() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        return new CheckoutComplete(driver);
    }
}
