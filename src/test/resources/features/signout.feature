Feature: Sign Out

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authenticate me on the site

  @HappyPath
  Scenario: Successful log out by Settings link
    When I click on the Settings link
    And the system displays the profile edit form
    Then I click on the log out button
    And the sign in option is displayed again

  @HappyPath
  Scenario: Successful log out by Profile Settings link
    When I click on the user name
    And I click the Edit Profile Settings link
    And the system displays the profile edit form
    Then I click on the log out button
    And the sign in option is displayed again
