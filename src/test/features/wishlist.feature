@CarGiant
Feature: Car Giant Test

  @Test1
  Scenario Outline: User should be able to login to Car Giant website with valid credentials
    Given User is on homepage
    When  User login with correct credentials
    And   User navigates to home page
    Then  User verifies the title of the page as "<CarGiantPageTitle>"
    And   User Logs out
    Examples:
    | CarGiantPageTitle                             |
    | Cargiant - Buy Online With Free Home Delivery |

  @Test2
  Scenario Outline: User Should be able to create and delete car watchlist
    Given User is on homepage
    When  User login with correct credentials
    And   User navigates to home page
    Then  User verifies the title of the page as "<CarGiantPageTitle>"
    When  User search for the car
    And   User verifies the 'Sort' filter and sort the result by "high to low"
    And   User adds "<Car1>" to watch list
    And   User adds "<Car2>" to watch list
    And   User navigates to 'My Garage' pag
    Then  User verifies whether "<Car1>" is added to the watchlist or not
    And   User verifies whether "<Car2>" is added to the watchlist or not
    When  User removes the added cars from watchlist
    Then  User verifies whether the cars are removed successfully or not
    And   User Logs out
    Examples:
    |CarGiantPageTitle                             | Car1                       |Car2         |
    |Cargiant - Buy Online With Free Home Delivery |Land Rover Range Rover Sport|Mercedes GLS |
