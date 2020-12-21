Feature: Create articles

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authenticate me on the site

  @HappyPath
  Scenario: Successful article
    When I click on the New Post link
    And the system shows me a form to create or edit an article
    And fill in all the fields of the article form
    And click on the Publish Article button
    Then the article is created or edit successfully

  @BadPath
  Scenario: Successful article
    When I click on the New Post link
    And the system shows me a form to create or edit an article
    And the article creation fields are left empty
    And click on the Publish Article button
    Then the system displays the error message indicating that the fields should not be empty
