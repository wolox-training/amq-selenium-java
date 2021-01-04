Feature: User detail

  Background:
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authenticate me on the site

  @HappyPath
  Scenario: User detail successfully
    When I click on the Global Feed link
    And the system displays the list of items
    And find a different user
    And the system displays the user's detail
    Then the user's articles are listed in the My articles section
    And the favorite articles are listed in the Favorite Articles section if it is the case
