package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.PropertiesLoader;

import java.util.Properties;

public class LoginPage extends BasePage {

    private static final By USER_NAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR = By.xpath("//h3[@data-test='error']");

    public static final String PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String LOGIN_ERROR = "Epic sadface: Username is required";
    public static final String LOCKED_USER_ERROR = "Epic sadface: Sorry, this user has been locked out.";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        return new LoginPage(driver);
    }

    public void loginAs(String userName, String password) {
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public ProductsPage loginAsStandardUser() {
        loginAs("standard_user", "secret_sauce");
        return new ProductsPage(driver);
    }

    public LoginPage loginAsLockedOutUser() {
        loginAs("locked_out_user", "secret_sauce");
        return new LoginPage(driver);
    }

    public ProductsPage loginAsProblemUser() {
        loginAs("problem_user", "secret_sauce");
        return new ProductsPage(driver);
    }

    public String getErrorText() {
        return driver.findElement(ERROR).getText();
    }
}
