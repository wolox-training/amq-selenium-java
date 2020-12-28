Feature: comments

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authenticate me on the site

  @HappyPath
  Scenario: A comment is made successfully
    When I click on the Global Feed link
    And the system displays the list of items
    And click on an article title in the list
    And the system opens the article information
    And write a comment to the article
    And I click post comment
    Then the new comment is added to the article
    And the author and the date of the comment are displayed
    And the comment is removed

  @HappyPath
  Scenario: Blank comment
    When I click on the Global Feed link
    And the system displays the list of items
    And click on an article title in the list
    And the system opens the article information
    And write a blank comment to the article
    And I click post comment
    Then the system displays the error message by blank comment
