@Expenses
Feature: Test the Expenses for Member Tools

  @jft
  Scenario Outline: Create an Expense
    Given a <member> logs in to <unit>
    And is on the Expenses page
    When an expense is filled out for  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount>
    Then the expense will be processed with  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount>
    Examples:
      | member   | unit            | payee              | purpose       | paymentType | addReceipt | category | categoryAmount |
      | "BISHOP" | "Maplewood 2nd" | "Carroll, Melanie" | "Expense One" | "Check"     | "picture"  | "FSY"    | "858"          |

