Feature: Create and View Customer

  Scenario Outline: User creates a new customer.
    Given user can create a new customer
    And user sends attributes customer id <customerId>, email id <emailId>, name <name> and date of birth <dateOfBirth>
    Then user should be able to see the newly created customer

    Examples:
    | customerId | emailId            | name | dateOfBirth |
    | 5          | Alexander@infy.com | Alex | 2005-06-21  |
    | 6          | John@infy.com      | John | 1970-12-01  |
