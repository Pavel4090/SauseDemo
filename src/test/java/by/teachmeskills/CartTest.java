package by.teachmeskills;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    final String productName = "Sauce Labs Backpack";
    final String productName1 = "Sauce Labs Onesie";

    @Test
    public void checkProductPriceInTheCart() {
        ProductsPage productsPage = new LoginPage(driver).open()
                .loginAsStandardUser()
                .addProductToCart(productName);
        String expectedPrice = productsPage.getProductPrice(productName);
        String actualPrice = productsPage.openCartPage()
                .getProductPrice(productName);

        Assertions.assertThat(actualPrice).as("Product should be added with correct price")
                .isEqualTo(expectedPrice);
    }

    @Test
    public void useSideMenu() {
        String text = "Sauce Labs Backpack";

        String sideMenu = new LoginPage(driver)
                .open()
                .loginAsStandardUser()
                .addProductToCart(productName1)
                .openCartPage()
                .openSideMenu()
                .allItems()
                .getTitleProductPage();


        Assertions.assertThat(sideMenu)
                .as("Product page should be displayed")
                .isEqualTo(text);
    }
}
