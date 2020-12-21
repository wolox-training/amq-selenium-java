Feature: Edit - Delete Articles

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authentic me on the site
    And I click on the New Post link
    And I create an article

  @SuccessfulEditArticle
  Scenario: Successful article
    When I click the edit button
    And the system shows me a form to create or edit an article
    And fill in all the fields of the article form
    And click on the Publish Article button
    Then the article is created or edit successfully

  @EmptyFields
  Scenario: Successful article
    When I click the edit button
    And the system shows me a form to create or edit an article
    And the article creation fields are left empty
    And click on the Publish Article button
    Then the system displays the error message indicating that the fields should not be empty

  @SuccessfulDeleteArticle
  Scenario: Successful article
    When I click the delete button
    Then the article was successfully removed

  @SuccessfulGlobalFeedArticle
  Scenario: Successful article
    When I click on the Home link
    And the system displays the Your Feed and Global Feed links
    And I click on the Global Feed link
    Then the article is in the first position of the list

  @SuccessfulMyPostArticle
  Scenario: Successful article
    When I click on the user name
    And the system displays the My Articles and Favorited Articles links
    Then the article is in the first position of the list
