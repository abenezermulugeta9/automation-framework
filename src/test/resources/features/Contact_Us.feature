@contact-us @regression
Feature: WebDriver University - Contact Us Page

  Background:
    Given I access the webdriver university contact us page

  @contact-us-unique-data
  Scenario: Validate Successful Submission - Unique Data
    When  I enter a unique first name
    And   I enter a unique last name
    And   I enter a unique email address
    And   I enter a unique comment
    And   I click on the submit button
    Then  I should be presented with a successful contact us submission message

  @contact-us-specific-data
  Scenario: Validate Successful Submission - Specific Data
    When  I enter a specific first name John
    And   I enter a specific last name Wick
    And   I enter a specific email address john.wick@email.com
    And   I enter a specific comment 'Selenium is awesome!!!'
    And   I click on the submit button
    Then  I should be presented with a successful contact us submission message