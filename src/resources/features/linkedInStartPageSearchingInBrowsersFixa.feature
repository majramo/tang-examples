Feature: Searching at LinkedIn Start Page
  This feature checks that we're able to search at LinkedIn start page.


  Scenario Outline: Searching LinkedIn Start Page in different browsers

    Given The user starts <browser>
    And The user visits linkedIn
    When The user searches for <firstName> <lastName>
    Then The result text should include <firstName>
    Then The result text should include <lastName>
    Then The result page hits should at least be <hits>
    Then The user closes the browser



  Examples: Search browser person
    | browser | firstName | lastName   | hits  |
    | Chrome  |  Majid    | Aram       | 3    |
    | Firefox |  Frank    | Lindholm   | 3     |
    | Firefox |  Stefan   | Lundin     | 25    |
    | Chrome  |  Joakim   | Sundström  | 4     |
    | Firefox |  Tobias   | Fransson   | 8     |

