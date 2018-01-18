
@version=customTestTag

Feature: Verify eligibility to apply for a credit card

  Background:
    Given the customer navigates to the CapitalOne credit card eligibility check website

  Scenario: The one where customer fills in all the fields and submits
    When he enters valid data for all the fields
    And he clicks CheckNow
    Then he will be redirected to the page with positive results on eligibilty check

  Scenario: The one where customer fills in only the mandatory fields and submits
    When he enters valid data for only the mandatory fields
    And he clicks CheckNow
    Then he will be redirected to the page with positive results on eligibilty check

  Scenario: The one where customer leaves the mandatory fields empty and submits
    When he clicks CheckNow
    Then validation errors will be highlighted in red for all the mandatory fields

  Scenario Outline: The one where customer fills in invalid first name and emailID and submits
    When he enters first name "<name>" and emailID "<emailID>"
    And he clicks CheckNow
    Then validation errors will be highlighted in red for the name and emaiID fields

    Examples:
    |name|  emailID     |
    |12&%|test.gmail.com|

  Scenario Outline: The one where customer fills in invalid DOB and submits
    When he selects date of birth with date "<date>" month "<month>" and year "<year>"
    And he clicks CheckNow
    Then a pop-up is displayed checking if the customer is 18 years or over

    Examples:
      |date |month|year|
      |11   |Jan  |2014|

  Scenario: The one where customer fills in invalid postcode
    When he fills in invalid postcode "S12345"
    And he clicks FindAddress
    Then a validation error will be highlighted in red for the postcode field
