Feature: Delete Articles

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authenticate me on the site
    And I click on the New Post link
    And I create an article

  @HappyPath
  Scenario: Successful article
    When I click the delete button
    Then the article was successfully removed
