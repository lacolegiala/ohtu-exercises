Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation is successful with valid username and password
    Given command new is selected
    When  new username "moi" and password "jihhuu97 are entered"
    Then  system will respond with "new user registered"
