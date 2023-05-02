@Expenses
Feature: Test the Expenses for Member Tools

  #todo: need a in Utah unit test
  @jft
  Scenario Outline: Create an Expense for <unit> and Approve Expense
#    Given a <member> logs in to <unit>
#    And is on the Expenses page
#    When an expense is filled out for  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount> <referenceNumber>
#    Then the expense will be processed with  <payee> <purpose> <paymentType> <addReceipt> <category> <categoryAmount>
#    And the user logs out
    When a <differentMember> logs in to <unit>
    And is on the Expenses page
    And the <payee> with the <categoryAmount> is Approved with the <paymentType>
    Then the expense will be approved
    Examples:
      | member   | unit            | payee              | purpose       | paymentType | addReceipt | category | categoryAmount | referenceNumber | differentMember             |
      | "BISHOP" | "Maplewood 2nd" | "Carroll, Melanie" | "Expense One" | "Check"     | "picture"  | "FSY"    | "858"          | "none"          | "BISHOPRIC_FIRST_COUNSELOR" |
#      | "BISHOP" | "Ala Rio Pequeno" | "Gabriel, Fernando" | "Advanced payment test" | "Advance payment" | "none"     | "FSY"    | "6868"         | "none"          |"BISHOPRIC_FIRST_COUNSELOR" |
#      | "BISHOP" | "Paroisse de Gex" | "Bergeron, Betty" | "Gex Ward Test" | "Advance payment" | "none"     | "Curriculum" | "8675"         | "random"        |"BISHOPRIC_FIRST_COUNSELOR" |

