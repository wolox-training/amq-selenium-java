Feature: favorites

  @SadPath
  Scenario: A comment is made successfully
    Given that I enter the conduit site
    And I hope the page to load
    And captured the number of favorites for the first item on the list
    When I click on the favorites option of the first item in the list
    Then the number of favorites does not change

  @HappyPath
  Scenario: A comment is made successfully
    Given that I enter the conduit site
    And I click on the Sign In link
    And Authenticate me on the site
    When I click on the Global Feed link
    And the system displays the list of items
    And captured the number of favorites for the first item on the list
    When I click on the favorites option of the first item in the list
    Then the number of favorites increases by one
    And is displayed in the Favorited Articles section of the profile
    And It is displayed in the Your Feed section of the main page
