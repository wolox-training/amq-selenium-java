Feature: Sign Up

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And the system shows me the login form

  @SuccessfulSignIn
  Scenario: Successful login
    When I fill the email and password fields with existing data
    And I click the sign in button
    Then the system correctly registers the user

  @EmptyFields
  Scenario: Empty sing up fields
    When I leave the login form fields blank
    And I click the sign up button
    Then the system displays error messages corresponding to login blank fields

  @IncorrectLoginFields
  Scenario: Incorrect login fields
    When I fill in the username with valid data
    And I fill in the password with wrong data
    And I click the sign up button
    Then The system displays an error message
