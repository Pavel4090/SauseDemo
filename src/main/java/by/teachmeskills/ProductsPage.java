package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By PRODUCTS_TITLE = By.xpath("//span[text()='Products']");
    private final By CART = By.id("shopping_cart_container");
    private final By ALL_PRODUCTS = By.xpath("//div[@class='inventory_item']");

    private final String PRODUCT_IN_THE_CART_LOCATOR = "//div[text()='%s']/ancestor::div[@class='cart_item']";
    private final String PRODUCT_CARD_LOCATOR = "//div[text()='%s']/ancestor::div[@class='inventory_item']";
    private final String ADD_TO_CART_BUTTON_LOCATOR = PRODUCT_CARD_LOCATOR + "//button[text()='Add to cart']";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(PRODUCTS_TITLE).isDisplayed();
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(ALL_PRODUCTS);
    }

    public ProductsPage addProductToCart(String productName) {
        By fullLocator = By.xpath(String.format(ADD_TO_CART_BUTTON_LOCATOR, productName));
        driver.findElement(fullLocator).click();
        return this;
    }

    public CartPage openCartPage() {
        driver.findElement(CART).click();
        return new CartPage(driver);
    }

    public SideMenu openSideMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        return new SideMenu(driver);
    }

    public String getProductPrice(String productName) {
        String PRODUCT_PRICE_LOCATOR = PRODUCT_CARD_LOCATOR + "//div[@class='inventory_item_price']";
        By fullLocator = By.xpath(String.format(PRODUCT_PRICE_LOCATOR, productName));
        return driver.findElement(fullLocator).getText();
    }

    public String getTitleProductPage() {
        WebElement title = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        System.out.println(title.getText());
        return title.getText();
    }

    public String getBackPackIMG() {
        WebElement elementIMG = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
        String attribute1 = elementIMG.getAttribute("src");
        System.out.println(attribute1);
        return attribute1;
    }
}
