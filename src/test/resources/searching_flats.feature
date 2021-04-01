Feature: Searching flats
  Scenario: User searches for flats, sends emails and saves offers
    Given User opens page="https://www.victoriadom.pl/"
    And User closes Cookie bar
    And User selects city="Warszawa"
    And User clicks property="Miasteczko Nova Ochota 4"
#    When User clicks on every available flat
    When User reads and saves all details of flats
    Then All data is saved to file




