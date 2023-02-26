package by.teachmeskills;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    public static final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    public static final String TEXT_WITH_THANKS = "THANK YOU FOR YOUR ORDER";

    @Test
    public void checkoutAfterByBackpack() {
        String checkoutComplete = new LoginPage(driver)
                .open()
                .loginAsStandardUser()
                .addProductToCart(SAUCE_LABS_BACKPACK)
                .openCartPage()
                .goToCheckout()
                .goToCheckoutOverview()
                .goToCheckoutFinish()
                .getTextWithThanks();

        Assertions.assertThat(checkoutComplete)
                .as("Text 'THANK YOU FOR YOUR ORDER' should be displayed")
                .isEqualTo(TEXT_WITH_THANKS);
    }
}
