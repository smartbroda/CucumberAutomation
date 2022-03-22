Feature: SearchByOwner
  In order to search by owner
  As an applicant
  I want to be able to find a valid owner

  Background:
    Given I navigate to Search by owner page

  @RunThis
  Scenario: Check search by owner form is available
    Then I validate details on Search by owner page


  @result-click
  Scenario: User clicks link on results page
    When I search by entering postcode "NP10 8QQ" on Search by owner page
    Then I click on result link to progress to results finders page
