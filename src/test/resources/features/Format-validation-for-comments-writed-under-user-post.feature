Feature: Validating comments emails for all posts written by specific user

  Scenario: Searching the user by name and validating all emails format for comments under his posts
    Given system administrator is searching for user following "Delphine"
    When system administrator is searching for all user posts
    Then system administrator validates all email from comments under posts written by user