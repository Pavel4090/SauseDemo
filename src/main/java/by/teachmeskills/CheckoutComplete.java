package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutComplete extends BasePage {

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public String getTextWithThanks() {
        WebElement text = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
        return text.getText();
    }
}
