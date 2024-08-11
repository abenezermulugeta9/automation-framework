@login
Feature: WebDriver University - Login Page

  Scenario Outline: Validate Login - <validationMessage>
    Given I access the the WebDriver University login page
    When  I enter a username '<username>'
    When  I enter a password <password>
    And   I click on the login button
    Then  I should be presented with a <validationMessage> login message

    Examples:
      | username   | password     | validationMessage    |
      | webdriver  | webdriver123 | validation succeeded |
      | webdriver  | webdriver1   | validation failed    |
      | webdriver1 | webdriver123 | validation failed    |
      | webdriver1 | webdriver1   | validation failed    |
