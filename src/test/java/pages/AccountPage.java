package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class to handle the HTML locators and action methods of the page of the AccountPage
 * @author CSanabria
 */

public class AccountPage {

    private By accountTab = By.xpath("//one-app-nav-bar-item-root[@data-target-selection-name=\"sfdc:TabDefinition.standard-Account\"]");
    //public By newAccountBtn = By.xpath("//ul[@data-aura-class=\"oneActionsRibbon forceActionsContainer\"]//child::li[1]");
    private By newAccountBtn = By.xpath("//li[@data-target-selection-name=\"sfdc:StandardButton.Account.New\"]");
    //FIELDS FORMS
    private By nameAccountField = By.xpath("//input[@name=\"Name\"]");
    private By webSiteField = By.xpath("//input[@name=\"Website\"]");
    private By saveBtn = By.xpath("//button[@class='slds-button slds-button_brand' and @name='SaveEdit']");
    private By typeComboBox = By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']");
    private By optComboBox = By.xpath("//span[@title='Socio']");
    private By descriptionField = By.xpath("//lightning-textarea[@class='slds-form-element_stacked slds-form-element']//child::div");
    private By phoneField = By.xpath("//input[@name=\"Phone\"]");
    //ALERT
    private By msmConfirmation = By.xpath("//span[@class=\"toastMessage slds-text-heading--small forceActionsText\"]");
    //EDIT ACCOUNT
    private By accountToEdit = By.xpath("//a[contains(@title,\"Ice Cream\")]");
    private By editBtn = By.xpath("//button[@name=\"Edit\"]");



    private WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAccountsTab(){
        driver.findElement(getAccountTab()).click();
    }

    public void clickNewAccountBtn(){
        driver.findElement(getNewAccountBtn()).click();
    }

    public void fillOutAccountDetails(String nameAccount, String webSite, String description, String phone){
        driver.findElement(getNameAccountField()).clear();
        driver.findElement(getNameAccountField()).sendKeys(nameAccount);
        driver.findElement(webSiteField).clear();
        driver.findElement(webSiteField).sendKeys(webSite);
        driver.findElement(getTypeComboBox()).click();
        driver.findElement(optComboBox).click();
        driver.findElement(descriptionField).click();
        driver.findElement(descriptionField).sendKeys(description);
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);

    }

    public void sendTheForm(){
        driver.findElement(saveBtn).click();
    }

    public String accountSuccessfullyCreated(){
        String msmConfirmation2 = driver.findElement(getMsmConfirmation()).getText();
        System.out.println(msmConfirmation2);
        return msmConfirmation2;
    }

    public void selectAccountToEdit(){
        driver.findElement(getAccountToEdit()).click();
    }

    public void clickEditBtn(){
        driver.findElement(getEditBtn()).click();
    }


    public By getAccountTab() {
        return accountTab;
    }

    public By getNewAccountBtn() {
        return newAccountBtn;
    }

    public By getNameAccountField() {
        return nameAccountField;
    }

    public By getMsmConfirmation() {
        return msmConfirmation;
    }

    public By getAccountToEdit() {
        return accountToEdit;
    }

    public By getEditBtn() {
        return editBtn;
    }

    public By getTypeComboBox() {
        return typeComboBox;
    }
}
