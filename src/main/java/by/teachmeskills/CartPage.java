package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final String PRODUCT_IN_THE_CART_LOCATOR = "//div[text()='%s']/ancestor::div[@class='cart_item']";
    private final String PRODUCT_PRICE_LOCATOR = PRODUCT_IN_THE_CART_LOCATOR + "//div[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice(String productName) {
        By fullLocator = By.xpath(String.format(PRODUCT_PRICE_LOCATOR, productName));
        return driver.findElement(fullLocator).getText();
    }

    public CheckoutPage goToCheckout() {
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        return new CheckoutPage(driver);
    }

    public SideMenu openSideMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        return new SideMenu(driver);
    }

}
