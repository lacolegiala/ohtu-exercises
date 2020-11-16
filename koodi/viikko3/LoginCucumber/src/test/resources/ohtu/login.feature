Feature: User can log in with valid username/password-combination

    Scenario: user can login with correct password
       Given command login is selected
       When  username "pekka" and password "akkep" are entered
       Then  system will respond with "logged in"

    Scenario: user can not login with incorrect password
      Given command login is selected
      When  username "pekka" and wrong password "appek888" are entered
      Then  system will respond with "wrong username or password"

    Scenario: nonexistent user can not login to
      Given command login is selected
      When  username "forbiden" and password "20202020" are entered
      Then  system will respond with "wrong username or password"

    Scenario: can login with successfully generated account
      Given user "eero" with password "salainen1" is created
      And   command login is selected
      When  username "eero" and password "salainen1" are entered
      Then  system will respond with "logged in"
