package by.teachmeskills;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static by.teachmeskills.LoginPage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @Test
    public void checkLoginForStandartUser() {
        ProductsPage productsPage = new LoginPage(driver).open()
                .loginAsStandardUser();
        Assertions.assertThat(productsPage.isOpened())
                .isTrue()
                .as("Products page should be opened after user logged in with valid credentials");
    }

    @Test
    public void checkLoginForLockedUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .loginAsLockedOutUser();
        assertThat(loginPage.getErrorText()).isEqualTo(LOCKED_USER_ERROR)
                .as("The error" + LOCKED_USER_ERROR + "should be displayed if username 'locked_out_user'");
    }

    @Test
    public void checkProblemUser() {
        String productsPage = new LoginPage(driver).open().loginAsProblemUser().getBackPackIMG();

        WebElement imgElement = driver.findElement(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']"));
        String attribute2 = imgElement.getAttribute("src");
        System.out.println(attribute2);
        assertThat(attribute2).as("On product displayed normal products img")
                .isEqualTo(productsPage);
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

    @Test
    public void checkPasswordWithoutLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .loginAs("", "secret_sauce");
        assertThat(loginPage.getErrorText()).isEqualTo(LOGIN_ERROR)
                .as("The error" + LOGIN_ERROR + "should be displayed if username has not been entered");
    }
}
