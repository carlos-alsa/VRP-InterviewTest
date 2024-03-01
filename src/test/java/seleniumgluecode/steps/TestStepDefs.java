package seleniumgluecode.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.PropertyManager;
import seleniumgluecode.TestBase;

import java.time.Duration;

/**
 * Test implementation class
 * @author CSanabria
 */

public class TestStepDefs extends TestBase {

    //----------------------------------------------------- Background ------------------------------------------------------------//

    @Given("The user logs in correctly in Salesforce page")
    public void the_user_logs_in_correctly_in_salesforce_page() {
        loginPage.sendCredentials(userEmail, userPassword);
    }
    @And("the user is in the home page")
    public void the_user_is_in_the_home_page() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getPageTitleLocator()));
        Assert.assertTrue(homePage.isHomePage());
    }
    @And("the user goes to account page")
    public void the_user_goes_to_account_page() {
        accountPage.clickAccountsTab();
    }


    //------------------------------------------------- Create New Account ------------------------------------------------------------//

    @When("user clicks new button")
    public void user_clicks_new_button() {
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.getNewAccountBtn()));
        accountPage.clickNewAccountBtn();
    }
    @And("fill the fields required")
    public void fill_the_fields_required(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountPage.getNameAccountField()));
        accountPage.fillOutAccountDetails(nameAccount,webSite, description,phone);
    }
    @And("user sends the form")
    public void user_sends_the_form() {
        accountPage.sendTheForm();
    }

    @Then("the new account was successfully created")
    public void the_new_account_was_successfully_created() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountPage.getMsmConfirmation()));
        Assert.assertEquals("Se creó Cuenta " + "\"" + nameAccount + "\".",accountPage.accountSuccessfullyCreated());
    }


    //------------------------------------------------- Edit Account ------------------------------------------------------------//

    @When("user selects the account to edit")
    public void user_selects_the_account_to_edit() {
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.getAccountToEdit()));
        accountPage.selectAccountToEdit();
    }
    @And("edit the form fields")
    public void edit_the_form_fields() {
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.getEditBtn()));
        accountPage.clickEditBtn();
    }

    @And("user sends the form edited")
    public void user_sends_the_form_edited() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountPage.getNameAccountField()));
        accountPage.fillOutAccountDetails(nameAccountEdit,webSiteEdit, description,phone);
        accountPage.sendTheForm();
    }

    @Then("the account was successfully edited")
    public void the_account_was_successfully_edited() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountPage.getMsmConfirmation()));
        Assert.assertEquals("Se guardó Cuenta " + "\"" + nameAccountEdit + "\".",accountPage.accountSuccessfullyCreated());
    }

}
