Feature: Sign Up

  Background:
    Given that I enter the conduit site
    And I click on the Sign Up link
    And the system shows me the registration form

  Scenario: Successful registration of a new user
    When I filled out the fields with valid values
    And I click the sign up button
    Then the system displays a successful registration message

  Scenario: Existing user
    When I filled in the fields with existing values
    And I click the sign up button
    Then the system displays the error message indicating that the person already exists

  Scenario: Empty sing up fields
    When I leave the form fields blank
    And I click the sign up button
    Then the system displays error messages corresponding to blank fields

  Scenario Outline: Email existente
    When I fill in the username and password fields with valid data
    And I fill out the email field with mail "<email>"
    And I click the sign up button
    Then the system displays a message indicating that the mail already exists

    Examples:
      | email                      |
      | anamaria.quintero@wolox.co |


