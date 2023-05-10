@API
  Feature: API test for Temples

    @MQA-7198 @MQA-6341 @all
    Scenario Outline: Check <url> status code for <member> - Temples
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member   | url                 | status    |
        | "BISHOP" | "temples"           | "Success" |
        | "BISHOP" | "temples/schedules" | "Success" |
        | "BISHOP" | "referrals"         | "Success" |
        | "BISHOP" | "temple-recommend"  | "Success" |





