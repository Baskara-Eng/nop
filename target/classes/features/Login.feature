
@nopLogin
@severity=blocker

Feature: Login Feature
  Scenario Outline: Login with valid credentials
    Given user launch application
    When user enters emailId as "<username>"
    And user enters password as "<password>"
    And user clicks on login button
    Then login succssful 
    And user navigate to dashboard page
    Examples: 
     |username|password|
     |admin@yourstore.com|admin|