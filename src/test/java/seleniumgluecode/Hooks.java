package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.utils.PropertyManager;
import java.util.logging.Logger;

/**
 * Class for actions to be performed before and after the tests
 */

public class Hooks {
    private static ChromeDriver driver;
    private final String baseUrl = PropertyManager.getAuthValueByKey("URL");
    private final Logger log = Logger.getLogger(Hooks.class.getName());

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        log.info("");

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static ChromeDriver getDriver(){
        return driver;
    }

}
