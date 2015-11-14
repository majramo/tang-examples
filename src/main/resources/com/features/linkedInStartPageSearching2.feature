Feature: As a user
  In order to connect to a person at LinkedIn
  I want to search that persons name in different browsers
  And make sure I get a list as a result containing the name I searched



  Scenario Outline: Searching a person at LinkedIn Start Page, pass

    Given The user starts <browser>
    And The user visits linkedIn
    When The user searches for <firstName> <lastName>
    Then The result text should include <firstName>
    And The result text should include <lastName>
    And The result page hits should at least be <hits>
    And The user closes the browser



  Examples: Search for different persons
    | browser        | firstName | lastName   | hits  |
#    | LOCAL_FIREFOX  |  Majid    | Aram    | 25    |
