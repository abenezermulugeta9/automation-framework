@login
Feature: WebDriver University - Login Page

  # common scenario steps
  Background:
    Given I access the the WebDriver University login page

  # valid username and password
  Scenario: Validate Successful Login
    When  I enter a username 'webdriver'
    And   I enter a password webdriver123
    And   I click on the login button
    Then  I should be presented with a successful login message

  # valid username and invalid password
  Scenario: Validate Unsuccessful Login
    When  I enter a username 'webdriver'
    When  I enter a password invalidUserPass
    And   I click on the login button
    Then  I should be presented with a failed login message