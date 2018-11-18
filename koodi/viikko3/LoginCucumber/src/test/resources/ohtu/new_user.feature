Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  username "pekka2" and password "akkepakke3" are given
        Then  system will respond with "new user registered"
    
    Scenario: creation fails with already taken username and valid password
        Given command new user is selected
        When  username "pekka" and password "akkep" are given
        Then  system will respond with "new user not registered"

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  username "az" and password "akkepakke3" are given
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new user is selected
        When  username "pekka3" and password "za" are given
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and password enough long but consisting of only letters
        Given command new user is selected
        When  username "pekka4" and password "akkepakkee" are given
        Then  system will respond with "new user not registered"

    Scenario: can login with successfully generated account
        Given command new user is selected
        When  username "eero" and password "salainen1" are given
        And   command login is selected
        When  username "eero" and password "salainen1" are given
        Then  system will respond with "logged in"  