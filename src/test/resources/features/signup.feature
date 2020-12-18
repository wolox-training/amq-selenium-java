Feature: Sign Up

  Background:
    Given that I enter the conduit site
    And I click on the Sign Up link
    And the system shows me the registration form

  @SuccessfulSignUp
  Scenario: Successful registration of a new user
    When I filled out the fields with valid values
    And I click the submit button
    Then the system correctly registers the user

  @EmptyFields
  Scenario: Empty sing up fields
    When I leave the form fields blank
    And I click the submit button
    Then the system displays error messages corresponding to blank fields

  @ExistingEmail
  Scenario Outline: Existing email
    When I fill in the username and password fields with valid data
    And I fill out the email field with mail "<email>"
    And I click the submit button
    Then the system displays a message indicating that the mail already exists

    Examples:
      | email                      |
      | anamaria.quintero@wolox.co |

  @ExistingUser
  Scenario Outline: Existing user
    When I filled in the fields with existing values "<username>"
    And I click the submit button
    Then the system displays the error message indicating that the person already exists
    Examples:
      | username |
      | amquinte |

  @InvalidFormat
  Scenario Outline: Invalid Format email
    When I fill in the username and password fields with valid data
    And I fill out the email field with mail "<email>"
    And I click the submit button
    Then The email field is in invalid state
    And The system displays an "<msgError>" error message in the email

    Examples:
      | email                     | msgError                                                                                                                            |
      | anamaria.quinterowolox.co | Incluye un signo \"@\" en la dirección de correo electrónico. La dirección \"anamaria.quinterowolox.co\" no incluye el signo \"@\". |
      | anamaria.quintero@.com    | El signo \".\" está colocado en una posición incorrecta en la dirección \".com\".                                                   |
      | anamaria.quintero@wolox   | Incluye un signo \".\" en la dirección de correo electrónico. La dirección \"anamaria.quintero@wolox\" no incluye el signo \".\".   |

  @ShortPass
  Scenario Outline: Short password
    When I fill in the username and email fields with valid data
    And I fill out the password field with mail "<password>"
    And I click the submit button
    Then The system displays an error message for the short pass

    Examples:
      | password |
      | 158      |

  @HiddenPass
  Scenario Outline: Hidden password
    When I fill in the username and email fields with valid data
    And I fill out the password field with mail "<password>"
    Then In the html code the password is not written

    Examples:
      | password |
      | woloxer  |
