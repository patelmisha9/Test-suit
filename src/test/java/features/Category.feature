Feature: category

  @test @allpages
  Scenario Outline: User should be navigate to different category on home page
    Given I am on homepage
    When I click on "<pages_name>" link from top header menu
    Then I should be able to successfully navigated to related "<pages_url>" category page
    Examples:
      | pages_name    | pages_url                             |
      | Computers     | https://demo.nopcommerce.com/computers|
      | Electronics   | https://demo.nopcommerce.com/electronics|
      | Apparel       | https://demo.nopcommerce.com/apparel    |
      | Books         | https://demo.nopcommerce.com/books      |
      | Jewelry       | https://demo.nopcommerce.com/jewelry    |
      | Gift Cards    | https://demo.nopcommerce.com/gift-cards |