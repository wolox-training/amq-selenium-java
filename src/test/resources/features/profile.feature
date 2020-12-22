Feature: Profile

  Background:
    Given that I enter the conduit site
    And I click on the Sign Up link
    And I register as a new user

  @HappyPath
  Scenario: edit profile
    When I click on the user name
    And I click the Edit Profile Settings link
    And the system displays the profile edit form
    And the registered userName and Email are correctly displayed
    Then the profile information will be modified
    And I click the submit button
    And the username is updated in the navigation bar
    And updated information persists in fields

  @SadPath
  Scenario: Empty profile fields
    When I click on the user name
    And I click the Edit Profile Settings link
    And the system displays the profile edit form
    And the registered userName and Email are correctly displayed
    And clear required fields
    And I click the submit button
    Then the system displays error messages corresponding to blank fields


  @SadPath
  Scenario Outline: Invalid Format email profile
    When I click on the user name
    And I click the Edit Profile Settings link
    And the system displays the profile edit form
    And the registered userName and Email are correctly displayed
    And clear required fields
    And I fill out the email field with mail "<email>"
    And I click the submit button
    Then The email field is in invalid state
    And The system displays an "<msgError>" error message in the email

    Examples:
      | email                     | msgError                                                                                                                            |
      | anamaria.quinterowolox.co | Incluye un signo \"@\" en la dirección de correo electrónico. La dirección \"anamaria.quinterowolox.co\" no incluye el signo \"@\". |
      | anamaria.quintero@.com    | El signo \".\" está colocado en una posición incorrecta en la dirección \".com\".                                                   |
      | anamaria.quintero@wolox   | Incluye un signo \".\" en la dirección de correo electrónico. La dirección \"anamaria.quintero@wolox\" no incluye el signo \".\".   |
