Feature: test feature

  @Run
  Scenario: new scenario
    Given user navigates to 'Login' page
    And user inputs 'l33tbird@gmail.com' in the 'username' field
    And user inputs the saved 'password' in the 'password' field
    When user clicks 'login' button
    Then 'Overview' page is displayed