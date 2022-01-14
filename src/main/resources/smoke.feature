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

  Scenario Outline: Check that search results list contain <quantity> items
    Given User opens '<homePage>' page
    When User fill out search field with '<keyWord>'
    Then User checks that search result list contains '<quantity>' of items
    Examples:
      | homePage              | quantity | keyWord |
      | https://www.ebay.com/ | 61       | iphone  |

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



    Examples:
      | homePage              | email             | password |
      | https://www.ebay.com/ | bodacuk@gmail.com | 985236bo |





#  Scenario Outline: Check add product to wishlist
#    Given User opens '<homePage>' page
#    And User checks search field visibility
#    When User makes search by keyword '<keyword>'
#    Then User checks that amount of products in wish list are <amountOfProducts>
#    Examples:
#      | homePage                            | keyword | amountOfProducts |
#      | https://www.canadiantire.ca/en.html | cake    | 36               |