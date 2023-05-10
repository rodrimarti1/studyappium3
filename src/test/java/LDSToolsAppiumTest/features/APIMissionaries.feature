@API
  Feature: API test for Missionaries

    @MQA-7199 @MQA-6341 @all
    Scenario Outline: Check <url> status code for <member> - Missionaries
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member   | url                                     | status    |
        | "BISHOP" | "mission-leaders"                       | "Success" |
        | "BISHOP" | "mission-leaders/returned-missionaries" | "Success" |
        | "BISHOP" | "mission-leaders/missions"              | "Success" |
        | "BISHOP" | "missionaries"                          | "Success" |
        | "BISHOP" | "missionaries/serving"                  | "Success" |
        | "BISHOP" | "missionaries/assigned"                 | "Success" |





