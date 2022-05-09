@API
  Feature: API tests

    @jft
    Scenario Outline: Check <url> status code for <member>
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member    | url                                 | status    |
        | "BISHOP"  | "user"                              | "Success" |
        | "BISHOP"  | "units"                             | "Success" |
        | "BISHOP"  | "reports?units=39373"               | "Success" |
        | "BISHOP"  | "subscriptions"                     | "Success" |
        | "BISHOP"  | "reports/access"                    | "Success" |
        | "BISHOP"  | "referrals"                         | "Success" |
        | "BISHOP"  | "temples"                           | "Success" |
        | "BISHOP"  | "finances/accounts"                 | "Success" |
        | "BISHOP"  | "calendars?timeZone=America/Denver" | "Success" |
        | "MEMBER1" | "user"                              | "Success" |
        | "MEMBER1" | "units"                             | "Success" |
        | "MEMBER1" | "reports?units=39373"               | "Error"   |
        | "MEMBER1" | "subscriptions"                     | "Success" |
        | "MEMBER1" | "reports/access"                    | "Success" |
        | "MEMBER1" | "referrals"                         | "Success" |
        | "MEMBER1" | "temples"                           | "Success" |
        | "MEMBER1" | "finances/accounts"                 | "Success" |
        | "MEMBER1" | "calendars?timeZone=America/Denver" | "Success" |

    #    @MQA-3518 @all @smoke @all1 @daily @daily2
    @jft
    Scenario Outline: Check <member> rights in the API for Class and Quorum Attendance
      Given a <member> account checks the Class and Quorum Attendance right
      Then the Class and Quorum editable field is <status>
      Examples:
        | member                            | status  |
        | "BISHOP"                          | "true"  |
        | "BISHOPRIC_FIRST_COUNSELOR"       | "true"  |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "true"  |
        | "WARD_CLERK"                      | "true"  |
        | "WARD_EXECUTIVE_SECRETARY"        | "true"  |
        | "ELDERS_QUORUM_PRESIDENT"         | "true"  |
        | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "true"  |
        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "true"  |
#        | "ELDERS_QUORUM_SECRETARY"         | "true"  |
        | "RELIEF_SOCIETY_PRESIDENT"        | "true"  |
        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "true"  |
        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "true"  |
        | "RELIEF_SOCIETY_SECRETARY"        | "true"  |
        | "YOUNG_WOMEN_PRESIDENT"           | "true"  |
        | "YOUNG_WOMEN_FIRST_COUNSELOR"     | "true"  |
        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "true"  |
        | "SUNDAY_SCHOOL_PRESIDENT"         | "true"  |
        | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "true"  |
        | "MEMBER1"                         | "false" |
        | "MEMBER2"                         | "false" |
        | "PRIMARY_PRESIDENT"               | "true"  |
        | "PRIMARY_FIRST_COUNSELOR"         | "true"  |
        | "PRIMARY_SECOND_COUNSELOR"        | "true"  |

#    Lists Tests
    @jft
    Scenario: Check the creation and deleting of lists
      Given a member creates a list
      Then the new list will be displayed
      And the list is deleted
      Then the list will not be displayed


#      Reports
    @jft
    Scenario Outline: Check <member> rights to Reports
      Given a <member> account checks the Reports
      Then the Reports <status> are visible
      Examples:
        | member                            | status  |
        | "BISHOP"                          | "true"  |
        | "BISHOPRIC_FIRST_COUNSELOR"       | "true"  |
#        | "BISHOPRIC_SECOND_COUNSELOR"      | "true"  |
        | "WARD_CLERK"                      | "true"  |
        | "WARD_EXECUTIVE_SECRETARY"        | "true"  |
        | "ELDERS_QUORUM_PRESIDENT"         | "true"  |
#        | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "true"     |
        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "true"  |
        | "ELDERS_QUORUM_SECRETARY"         | "true"  |
        | "RELIEF_SOCIETY_PRESIDENT"        | "true"  |
#        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "true"     |
        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "true"  |
        | "YOUNG_WOMEN_PRESIDENT"           | "true"  |
        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "true"  |
#        | "SUNDAY_SCHOOL_PRESIDENT"         | "true"  |
        | "MEMBER1"                         | "false" |
        | "MEMBER2"                         | "false" |