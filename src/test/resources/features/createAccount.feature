@Smoke
Feature: Create account
  As Salesforce user
  I want to create a new account
  To manage my customers

  Background:
    Given The user logs in correctly in Salesforce page
    And the user is in the home page
    And the user goes to account page

  Scenario: Create an account successfully
    When user clicks new button
    And fill the fields required
    And user sends the form
    Then the new account was successfully created

  Scenario: Edit an account successfully
    When user selects the account to edit
    And edit the form fields
    And user sends the form edited
    Then the account was successfully edited