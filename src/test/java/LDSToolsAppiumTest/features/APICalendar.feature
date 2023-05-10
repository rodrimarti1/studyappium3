@API
  Feature: API test for Calendars

    @MQA-7197 @MQA-6341 @all
    Scenario Outline: Check <url> status code for <member> - Calendars
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member    | url                                                                            | status    |
        | "MEMBER1" | "calendars?timeZone=America/Denver"                                            | "Success" |
        | "BISHOP"  | "calendars?timeZone=America/Denver"                                            | "Success" |
        | "BISHOP"  | "calendars/events?start=2022-09-01T00%3A12%3A28Z&end=2022-12-01T00%3A12%3A28Z" | "Success" |
        | "BISHOP"  | "calendars/compile"                                                            | "Success" |
        | "BISHOP"  | "calendars/colors?building=false"                                              | "Success" |
        | "BISHOP"  | "calendars/colors?building=true"                                               | "Success" |
        | "BISHOP"  | "calendars/colors/names?building=false"                                        | "Success" |
        | "BISHOP"  | "calendars/colors/names?building=true"                                         | "Success" |
        | "BISHOP"  | "calendars?timeZone=$#@%@#%@#^@^%"                                             | "Error"   |





