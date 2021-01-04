Feature: Follow user

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authenticate me on the site

  @HappyPath
  Scenario: Follow user successfully
    When I click on the Global Feed link
    And the system displays the list of items
    And find a different user
    When I click the follow-unfollow user button
    Then button text changes by unfollowing user
    And The articles of the user followed are listed in the Your Feed section

  @HappyPath
  Scenario: Unfollow user successfully
    When I click on the Global Feed link
    And the system displays the list of items
    And find a different user
    When I click the follow-unfollow user button
    Then button text changes by following user
    And Articles of the unfollowed user are removed from the Your Feed section
