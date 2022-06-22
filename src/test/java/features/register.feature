@test
  Feature: Registrstion
    Scenario: As a user,I should be able to register successfully

      Given I am on registeration page
      When I enter required registration details
      Then I should able to registered successfully