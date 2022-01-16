Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check that home page contain all required fields
    Given User opens '<homePage>' page
    Then User checks search field visibility
    And User checks search button visibility
    And User checks company logo visibility
    And User checks shop by category dropDown list visibility
    And User checks advertisement banner visibility
    And User checks explore popular brands button visibility
    And User checks explore popular category button visibility
    And User checks sign in button visibility
    And User checks register button visibility
    And User checks help and contact button visibility
    And User checks top navigation bar visibility
    And User checks cart button visibility
    And User checks popup cart is empty visibility

    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario Outline: Check that advanced search page contain all required fields
    Given User opens '<homePage>' page
    When User clicks on advanced search button
    Then User checks first search  button visibility
    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario Outline: Check that search results list contain <quantity> items
    Given User opens '<homePage>' page
    When User fill out search field with '<keyWord>'
    Then User checks that search result list contains '<quantity>' of items
    Examples:
      | homePage              | quantity | keyWord |
      | https://www.ebay.com/ | 63       | iphone  |

  Scenario Outline: Check that user is able to add chosen item to cart
    Given User opens '<homePage>' page
    And User fill out search field with '<keyWord>'
    And  User chooses network category on search results page
    When User chooses first product from list on search result page
    And User clicks add to cart button
    Then User checks that product is added to cart

    Examples:
      | homePage              | keyWord |
      | https://www.ebay.com/ | iphone  |

  Scenario Outline: Check that user is able to sort search results by model category
    Given User opens '<homePage>' page
    And User fill out search field with '<keyWord>'
    When User chooses network category
    And User chooses iPhone model
    Then User check that all products in search list contains products with '<word>' from chosen category

    Examples:
      | homePage              | keyWord | word     |
      | https://www.ebay.com/ | iphone  | iphone 7 |

  Scenario Outline: Check that user is able to delete product from  cart
    Given User opens '<homePage>' page
    And User fill out search field with '<keyWord>'
    And  User chooses network checkBox category on search results page
    When User chooses product from list on search result page
    And User clicks add to cart button on product page
    And User clicks remove button
    Then User checks that product cart is empty
    Examples:
      | homePage              | keyWord |
      | https://www.ebay.com/ | iphone  |


  Scenario Outline: Check that user is able to sign in existing account
    Given User opens '<homePage>' page
    And User clicks on sign in button
    When User fill out username field with '<email>' username
    And User clicks continue button
    And User fill out password field with '<password>'
    And User clicks on sign in button on sign in page
    Then User verify that sign in button contains '<loginName>' on home page

    Examples:
      | homePage              | email             | password | loginName |
      | https://www.ebay.com/ | bodacuk@gmail.com | 985236bo | Богдан    |

  Scenario Outline: Check that user error message appears when user enters the wrong login when sign-in to account
    Given User opens '<homePage>' page
    And User clicks on sign in button
    When User fill out username field with incorrect '<email>' username
    And User clicks on sign in button on sign in page
    Then User verify that '<errorMessage>' appeared on login page

    Examples:
      | homePage              | email            | errorMessage |
      | https://www.ebay.com/ | bodacukgmail.com | not a match  |

  Scenario Outline: Check that user error message appears when user enters the wrong password when sign-in to account
    Given User opens '<homePage>' page
    And User clicks on sign in button
    When User fill out username field with incorrect '<email>' username
    And User clicks on sign in button on sign in page
    And User fill out password field with '<password>'
    And User clicks on sign in button on sign in page
    Then User verify that '<errorMessage>' appeared on login page



    Examples:
      | homePage              | email             | password     | errorMessage |
      | https://www.ebay.com/ | bodacuk@gmail.com | 456445464564 | not a match  |

  Scenario Outline: Check that user is able add to watch list product
    Given User opens '<homePage>' page
    And User fill out search field with '<keyWord>'
    And  User chooses network checkBox category on search results page
    When User chooses product from list on search result page
    And User clicks add to watchList button on product page
    And User fill out username field with incorrect '<email>' username
    And User clicks on sign in button on sign in page
    And User fill out password field with '<password>'
    And User clicks on sign in button on sign in page

    Examples:
      | homePage              | keyWord | email             | password |
      | https://www.ebay.com/ | iphone  | bodacuk@gmail.com | 985236bo |




