package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.utils.PropertyManager;
import java.time.Duration;

/**
 * Class that initializes the driver and creates all the instances of the pages that we are creating.
 * @author CSanabria
 */

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected String userEmail = PropertyManager.getAuthValueByKey("userEmail");
    protected String userPassword = PropertyManager.getAuthValueByKey("userPassword");
    protected String nameAccount = PropertyManager.getAccountDetailsByKey("nameAccount");
    protected String webSite = PropertyManager.getAccountDetailsByKey("webSite");
    protected String description = PropertyManager.getAccountDetailsByKey("description");
    protected String phone = PropertyManager.getAccountDetailsByKey("phone");
    protected String nameAccountEdit = PropertyManager.getAccountDetailsByKey("nameAccountEdit");
    protected String webSiteEdit = PropertyManager.getAccountDetailsByKey("webSiteEdit");

    protected Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    protected LoginPage loginPage = new LoginPage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected AccountPage accountPage = new AccountPage(driver);


}
