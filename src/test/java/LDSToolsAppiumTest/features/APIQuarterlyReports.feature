@API
  Feature: API test for Quarterly Reports

    @MQA-6724 @MQA-6341 @all @jft
    Scenario Outline: Check <url> status code for <member>
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member            | url                              | status    |
        | "BISHOP"          | "reports/quarterly-report"       | "Success" |
        | "STAKE_PRESIDENT" | "reports/quarterly-report"       | "Success" |
        | "STAKE_PRESIDENT" | "quarterly-reports"              | "Success" |
        | "BISHOP"          | "quarterly-reports"              | "Success" |
        | "BISHOP"          | "quarterly-reports/39373/2022/4" | "Success" |
        | "MEMBER1"         | "quarterly-reports/39373/2022/4" | "Error"   |
        | "BISHOP"          | "quarterly-reports/GOATS/2022/4" | "Error"   |





