@Expenses
Feature: Test the Expenses for Member Tools

  @jft
  Scenario Outline: Create an Expense for <unit>
    Given a <member> logs in to <unit>
    And is on the Expenses page
    When an expense is filled out for  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount> <referenceNumber>
    Then the expense will be processed with  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount>
    Examples:
      | member   | unit              | payee               | purpose                 | paymentType       | addReceipt | category | categoryAmount | referenceNumber |
      | "BISHOP" | "Maplewood 2nd"   | "Carroll, Melanie"  | "Expense One"           | "Check"           | "picture"  | "FSY"    | "858"          | "none"          |
      | "BISHOP" | "Ala Rio Pequeno" | "Gabriel, Fernando" | "Advanced payment test" | "Advance payment" | "none"     | "FSY"    | "6868"         | "none"          |
#      | "BISHOP" | "Paroisse de Gex" | "Bergeron, Betty" | "Gex Ward Test" | "Advance payment" | "none"     | "Curriculum" | "8675"         | "random"        |

