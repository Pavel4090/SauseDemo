package by.teachmeskills;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static by.teachmeskills.LoginPage.PASSWORD_ERROR;

public class LoginTest extends BaseTest{
    @Test
    public void checkLoginForStandartUser() {
        ProductsPage productsPage = new LoginPage(driver).open()
                .loginAsStandardUser();
        Assertions.assertThat(productsPage.isOpened())
                .isTrue()
                .as("Products page should be opened after user logged in with valid credentials");
    }

    @Test
    public void checkLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .loginAs("standard_user", "");
        assertThat(loginPage.getErrorText()).isEqualTo(PASSWORD_ERROR)
                .as("The error \"" + PASSWORD_ERROR +
                        "\" should be displayed if password has not been entered");

    }
}
