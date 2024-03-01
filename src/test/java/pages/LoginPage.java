package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class to handle the HTML locators and action methods of the page of the Login
 * @author CSanabria
 */

public class LoginPage {

    private By userField = By.id("username");
    private By passwdField = By.id("password");
    private By logInBtn = By.id("Login");

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void sendCredentials(String user, String passwd){
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwdField).sendKeys(passwd);
        driver.findElement(logInBtn).click();
    }

}
