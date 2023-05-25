@Expenses
Feature: Test the Expenses for Member Tools

  #todo: need a in Utah unit test - maybe a separate test?

  @jft
  Scenario Outline: Create a Check Expense for <unit> and Approve Expense
    Given a <member> logs in to <unit>
    And is on the Expenses page
    When an expense is filled out for  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount> <referenceNumber>
    Then the expense will be processed with  <payee> "submitted" "expense" <addReceipt> <category> <categoryAmount>
    And the user logs out
    When a <differentMember> logs in to <unit>
    And is on the Expenses page
    And the <payee> with the <categoryAmount> is Approved with the <paymentType>
    Then the expense will be processed with  <payee> "PENDING_PRINT" "expense" <addReceipt> <category> <categoryAmount>
    Examples:
      | member   | unit            | payee            | purpose       | paymentType | addReceipt | category | categoryAmount | referenceNumber | differentMember             |
      | "BISHOP" | "Maplewood 2nd" | "Cline, Michael" | "Expense One" | "Check"     | "picture"  | "FSY"    | "858"          | "none"          | "BISHOPRIC_FIRST_COUNSELOR" |


  Scenario Outline: Create an Advanced Payment Expense for <unit> and Approve Expense
    Given a <member> logs in to <unit>
    And is on the Expenses page
    When an expense is filled out for  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount> <referenceNumber>
    Then the expense will be processed with  <payee> "submitted" "expense" <addReceipt> <category> <categoryAmount>
    And the user logs out
    When a <differentMember> logs in to <unit>
    And is on the Expenses page
    And the <payee> with the <categoryAmount> is Approved with the <paymentType>
    Then the expense will be processed with  <payee> "APPROVED" "expense" <addReceipt> <category> <categoryAmount>
    Examples:
      | member   | unit              | payee               | purpose                 | paymentType       | addReceipt | category     | categoryAmount | referenceNumber | differentMember             |
      | "BISHOP" | "Ala Rio Pequeno" | "Gabriel, Fernando" | "Advanced payment test" | "Advance payment" | "none"     | "FSY"        | "6868"         | "none"          | "BISHOPRIC_FIRST_COUNSELOR" |
      | "BISHOP" | "Paroisse de Gex" | "Bergeron, Betty"   | "Gex Ward Test"         | "Advance payment" | "none"     | "Curriculum" | "8675"         | "random"        | "BISHOPRIC_FIRST_COUNSELOR" |