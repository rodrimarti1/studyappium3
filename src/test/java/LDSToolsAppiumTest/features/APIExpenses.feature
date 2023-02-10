@API
Feature: API tests for Expenses

  @jft
  Scenario Outline: Check <url> status code for <member> Expenses
    Given a <member> goes to the <url>
    Then the status should be <status>
    Examples:
      | member    | url                                        | status    |
      | "BISHOP"  | "finances/accounts"                        | "Success" |
      | "BISHOP"  | "finances/participants"                    | "Success" |
      | "BISHOP"  | "finances/expenses"                        | "Success" |
      | "MEMBER1" | "finances/accounts"                        | "Success" |
      | "BISHOP"  | "finances/expenses/117335839?type=EXPENSE" | "Success" |
      | "MEMBER1" | "finances/expenses/117335839?type=EXPENSE" | "Error"   |

    #accountid 8880

  Scenario: Post Put and Delete an Expense
    When an expense is created for "API Automated Test 1"
    Then the expense will be correct for "API Automated Test 1"
    And the expense "API Automated Test 1" will be modified to "API Automated Test 2"
    Then the expense will be correct for "API Automated Test 2"
    And delete the expense "API Automated Test 2"
    Then the expense "API Automated Test 2" will "not be found"

  #One test?
  Scenario: Get an expense
  Scenario: Put an expense
  Scenario: Post an expense
  Scenario: Delete an expense

  Scenario: Get participants
  Scenario: Post participants

  Scenario: Post Subcategories
  Scenario: Post reimbursement

  Scenario: Get receipts
  Scenario: Get accounts?
