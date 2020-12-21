Feature: Profile

  Background:
    Given that I enter the conduit site
    And I click on the Sign Up link
    And I register as a new user

  @SuccessfulSignUp
  Scenario: edit profile
    When I click on the user name
    And I click the Edit Profile Settings link
    And the system displays the profile edit form
    And the registered userName and Email are correctly displayed
    Then the profile information will be modified

