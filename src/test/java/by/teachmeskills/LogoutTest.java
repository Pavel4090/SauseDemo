package by.teachmeskills;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutWithSideMenu() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open().loginAsStandardUser().openSideMenu().logout();
    }
}
