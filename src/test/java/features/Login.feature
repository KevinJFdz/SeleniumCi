Feature: Login
  @Login
  Scenario: Login successfully
    Given the user is on login section
    When the login enters his credentials
    Then the app should be display the main section