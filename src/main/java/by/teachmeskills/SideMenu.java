package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenu extends BasePage {

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        new LoginPage(driver);
    }

    public ProductsPage allItems() {
        driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']")).click();
        return new ProductsPage(driver);
    }

}
