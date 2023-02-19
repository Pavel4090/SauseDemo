package by.teachmeskills;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void checkProductPriceInTheCart() {
        final String productName = "Sauce Labs Backpack";
        ProductsPage productsPage = new LoginPage(driver).open()
                .loginAsStandardUser()
                .addProductToCart(productName);
        String expectedPrice = productsPage.getProductPrice(productName);
        String actualPrice = productsPage.openCartPage()
                .getProductPrice(productName);

        Assertions.assertThat(actualPrice).as("Product should be added with correct price")
                .isEqualTo(expectedPrice);
    }
}
