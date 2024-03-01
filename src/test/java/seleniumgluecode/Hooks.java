package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Logger;

/**
 * Class for actions to be performed before and after the tests
 */

public class Hooks {

    private static ChromeDriver driver;
    private String TYPE_DRIVER = "webdriver.chrome.driver";
    private String PATH_DRIVER = "./src/test/resources/chromedriver/chromedriver.exe";
    private String URL = "https://business-dream-3139.my.salesforce.com/";
    private Logger log = Logger.getLogger(Hooks.class.getName());

    @Before
    public void setUp(){
        System.setProperty(TYPE_DRIVER,PATH_DRIVER);
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
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
