@API
  Feature: API test for Reports

    @MQA-7200 @MQA-6341 @all
    Scenario Outline: Check <url> status code for <member> - Reports
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member   | url                               | status    |
        | "BISHOP" | "reports?units=39373"             | "Success" |
        | "BISHOP" | "reports/access"                  | "Success" |
        | "BISHOP" | "reports"                         | "Success" |
        | "BISHOP" | "reports/sacrament-attendance"    | "Success" |
        | "BISHOP" | "reports/class-quorum-attendance" | "Success" |
        | "BISHOP" | "reports/unit-statistics"         | "Success" |
        | "BISHOP" | "reports/new-members"             | "Success" |
        | "BISHOP" | "reports/ministering-sisters"     | "Success" |
        | "BISHOP" | "reports/ministering-brothers"    | "Success" |
        | "BISHOP" | "reports/members-moved-out"       | "Success" |
        | "BISHOP" | "reports/covenant-path-records"   | "Success" |
        | "BISHOP" | "reports/action-interviews"       | "Success" |
        | "BISHOP" | "reports/my-cool-report"          | "Error"   |
        | "BISHOP" | "ministering"                     | "Success" |
        | "BISHOP" | "ministering/organizations"       | "Success" |
        | "BISHOP" | "covenant-path/user"              | "Success" |
        | "BISHOP" | "covenant-path"                   | "Success" |





