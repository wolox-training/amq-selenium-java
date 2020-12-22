Feature: Sign In

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And the system shows me the login form

  @HappyPath
  Scenario: Successful login
    When I fill the email and password fields with existing data
    And I click the sign in button
    Then the system correctly registers the user

  @SadPath
  Scenario: Empty sing up fields
    When I leave the login form fields blank
    And I click the submit button
    Then the system displays error messages corresponding to login blank fields

  @SadPath
  Scenario: Incorrect login fields
    When I fill in the username with valid data
    And I fill in the password with wrong data
    And I click the submit button
    Then The system displays an error message for invalid data

  @SadPath
  Scenario Outline: Invalid Format email
    When I fill out the email field with mail "<email>"
    And I fill in the password with valid data
    And I click the submit button
    Then The email field is in invalid state
    And The system displays an "<msgError>" error message in the email

    Examples:
      | email                     | msgError                                                                                                                            |
      | anamaria.quinterowolox.co | Incluye un signo \"@\" en la dirección de correo electrónico. La dirección \"anamaria.quinterowolox.co\" no incluye el signo \"@\". |
      | anamaria.quintero@.com    | El signo \".\" está colocado en una posición incorrecta en la dirección \".com\".                                                   |
      | anamaria.quintero@wolox   | Incluye un signo \".\" en la dirección de correo electrónico. La dirección \"anamaria.quintero@wolox\" no incluye el signo \".\".   |
