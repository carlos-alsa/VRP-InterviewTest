package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class to handle the HTML locators and action methods of the page of the HomePage
 * @author CSanabria
 */

public class HomePage {

    private By pageTitleLocator = By.xpath("//span[@title=\"Servicio\"]");

    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isHomePage(){
        return driver.findElement(getPageTitleLocator()).isEnabled();
    }

    public By getPageTitleLocator() {
        return pageTitleLocator;
    }
}
