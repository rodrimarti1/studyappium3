@PaymentRequests
Feature: Payment Requests - be able to submit a payment from Member Tools

  @MQA-4818 @MQA-4817 @daily @daily1 @smoke @smoke1 @all
  Scenario Outline: As a member enter in a new payment request
    Given a <member> is on the Finance page
    When a payment request is filled out for <payee> <purpose> <account> <addReceipt> <category> <categoryAmount>
    Then the payment request should be processed with information of <member> <payee> <purpose> <account> <addReceipt> <category> <categoryAmount>
    Examples:
      | member   | payee    | purpose    | account | addReceipt | category | categoryAmount |
      | "BISHOP" | "myself" | "Test One" | "test"  | "picture"  | "FSY"    | "555"          |
#      | "ELDERS_QUORUM_PRESIDENT"  | "myself" | "EQ Pres Test"          | "test"  | "picture"  | "Elders Quorum"  | "8365"         |
#      | "RELIEF_SOCIETY_PRESIDENT" | "myself" | "RS Pres Test"          | "test"  | "picture"  | "Relief Society" | "11653"        |
#      | "YOUNG_WOMEN_PRESIDENT"    | "myself" | "Young Women Pres Test" | "test"  | "picture"  | "Young Women"    | "3319"         |

  @MQA-4819 @MQA-4817 @broken
  Scenario: As a member add a payment request with multiple categories
    Given a "BISHOP" is on the Finance page
    When a payment request is filled out with the categories and amounts of "Activities" "1234" "Primary" "4321" "Sunday School" "45893"
    Then the payment request will show the multiple categories

  @MQA-4820 @MQA-4817 @all @daily @daily3
  Scenario: As a member edit a payment request
    Given a "BISHOP" is on the Finance page and has a payment request that is not finished
    When an unfinished payment request is selected
    Then the member will finish the payment request

  @MQA-4821 @MQA-4817 @all @daily @daily4 @jft
  Scenario: Enter in very large purpose
    Given a "BISHOP" is on the Finance page
    When "Look,  strange women lying on their backs in ponds handing out swords... that's no basis for a system of government. Supreme executive power derives from a mandate from the masses, not from  some farcical aquatic ceremony. Look,  strange women lying on their backs in ponds handing out swords... that's no basis for a system of government. Supreme executive power derives from a mandate from the masses, not from  some farcical aquatic ceremony." is entered in the purpose
#    When "Small test should fail" is entered in the purpose
    Then Some purpose error should happen

#  Scenario: Too large of amount
#    Given a "BISHOP" is on the Finance page
#    When 500,000,000,000 is entered in as a category amount
#    Then Some error should happen
#
#  Scenario: Start payment request then remove
#    Given a "BISHOP" is on the Finance page
#    When a payment request is started then canceled
#    Then the payment request should show up on the payment request page
#
#  #  This may not be possible
#  Scenario: Try to enter an Invalid amount
#    Given a "BISHOP" is on the Finance page
#    When $#@%^&%$&#$^%$@ is entered in as a category amount
#    Then Some error should happen

#  Scenario: As a leader check status of payment request?