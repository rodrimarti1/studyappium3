@ProgressRecord
  Feature: Progress Record tests - Used to be Missionary Progress Record

    @MQA-5156 @MQA-2225 @smoke @smoke4 @all @all4 @daily @daily4
    Scenario Outline: SMOKE as a leader I should have access to the New Members under Progress Record
      Given a <leader> logs in and is on the Progress Record Page
      When a <memberRecord> is selected under the New Members tab
      Then the <memberRecord> will be displayed
      And the members record <can> be edited
      Examples:
        | leader   | memberRecord       | can    |
        | "BISHOP" | "Forred, Kingston" | "true" |


    @MQA-3193 @MQA-2225
    Scenario Outline: As a leader I should have access to the New Members under Progress Record
      Given a <leader> logs in and is on the Progress Record Page
      When a <memberRecord> is selected under the New Members tab
      Then the <memberRecord> will be displayed
      And the members record <can> be edited

      @all @all3 @all @daily @daily3
      Examples:
        | leader                     | memberRecord       | can     |
        | "BISHOP"                   | "Forred, Kingston" | "true"  |
        | "ELDERS_QUORUM_PRESIDENT"  | "Forred, Kingston" | "true"  |
        | "RELIEF_SOCIETY_PRESIDENT" | "Forred, Kingston" | "true"  |
        | "YOUNG_WOMEN_PRESIDENT"    | "Forred, Kingston" | "false" |

      @all @all3 @all
      Examples:
        | leader                            | memberRecord       | can     |
        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "Forred, Kingston" | "false" |
        | "SUNDAY_SCHOOL_PRESIDENT"         | "Forred, Kingston" | "false" |
        | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "Forred, Kingston" | "false" |
        | "WARD_MISSION_LEADER"             | "Forred, Kingston" | "true"  |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "Forred, Kingston" | "true"  |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "Forred, Kingston" | "true"  |
        | "WARD_CLERK"                      | "Forred, Kingston" | "true"  |
        | "WARD_EXECUTIVE_SECRETARY"        | "Forred, Kingston" | "true"  |
        | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "Forred, Kingston" | "false" |
        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "Forred, Kingston" | "false" |
        | "ELDERS_QUORUM_SECRETARY"         | "Forred, Kingston" | "false" |
        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Forred, Kingston" | "false" |
        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Forred, Kingston" | "false" |

    @MQA-5157 @MQA-2225 @all @all3 @daily @daily3
    Scenario Outline: As a STAKE leader I should have access to the New Members under Progress Record
      Given a <leader> logs in to <unit>
      And is on the Progress Record page
      When a <memberRecord> is selected under the New Members tab for <singleUnit>
      Then the <memberRecord> will be displayed
      And the members record <can> be edited
      Examples:
        | leader            | memberRecord     | can     | unit           | singleUnit   |
        | "STAKE_PRESIDENT" | "Young, Kenneth" | "false" | "Auburn Hills" | "Wellington" |




    @MQA-3194 @MQA-2225
    Scenario Outline: As a leader I should have access to the People Being Taught under Progress Record
      Given a <leader> logs in and is on the Progress Record Page
      When a <memberRecord> is selected under the People Being Taught tab
      Then the <memberRecord> for People Being Taught will be displayed
      And the members record for People Being Taught <can> be edited

      @daily @daily1
      Examples:
        | leader                     | memberRecord   | can     |
        | "BISHOP"                   | "Erwin, Lacey" | "true"  |
        | "ELDERS_QUORUM_PRESIDENT"  | "Erwin, Lacey" | "true"  |
        | "RELIEF_SOCIETY_PRESIDENT" | "Erwin, Lacey" | "true"  |
        | "YOUNG_WOMEN_PRESIDENT"    | "Erwin, Lacey" | "false" |

      @all @all1
      Examples:
        | leader                            | memberRecord   | can     |
        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "Erwin, Lacey" | "false" |
        | "SUNDAY_SCHOOL_PRESIDENT"         | "Erwin, Lacey" | "false" |
        | "WARD_MISSION_LEADER"             | "Erwin, Lacey" | "true"  |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "Erwin, Lacey" | "true"  |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "Erwin, Lacey" | "true"  |
        | "WARD_CLERK"                      | "Erwin, Lacey" | "true"  |
#        | "WARD_EXECUTIVE_SECRETARY"        | "Erwin, Lacey"   | "true"  |
        | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "Erwin, Lacey" | "false" |
        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "Erwin, Lacey" | "false" |
        | "ELDERS_QUORUM_SECRETARY"         | "Erwin, Lacey" | "false" |
        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Erwin, Lacey" | "false" |
        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Erwin, Lacey" | "false" |

    @MQA-5158 @MQA-2225 @all @all4 @daily @daily4 @jft
    Scenario Outline: As a STAKE leader I should have access to the People Being Taught under Progress Record
      Given a <leader> logs in selects a <unit> and is on the Progress Record Page
      When a <memberRecord> is selected under the People Being Taught tab
      Then the <memberRecord> for People Being Taught will be displayed
      And the members record for People Being Taught <can> be edited
      Examples:
        | leader            | memberRecord | can     | unit     |
        | "STAKE_PRESIDENT" | "Bamba, Moe" | "false" | "Newton" |
#        | "STAKE_PRESIDENT_FIRST_COUNSELOR"  | "Corum, Will"      | "false" | "Newton"       |
#        | "STAKE_PRESIDENT_SECOND_COUNSELOR" | "Cesar"            | "false" | "Hutchinson"   |
#        | "STAKE_CLERK"                      | "Casas, Charlotte" | "false" | "Pratt"        |
#        | "STAKE_EXECUTIVE_SECRETARY"        | "Thrash, Tori"     | "false" | "Auburn Hills" |


#    Scenario: As a BISHOP check the quick card for New Members
#      Given a "BISHOP" logs in and is on the Progress Record Page
#      When the New Members tab is selected
#      Then the members quick card information should be displayed





#    Todo: no way to check if the box is checked or not in Android and iOS
#  #  Check from Member Record page and check from details?
#    Scenario: As a leader edit the Sacrament Meeting Attendance for a member record
#      Given a leader has a member record open
#      When a blank Sacrament Meeting Attendance date is selected
#      Then the date should be checked
#      And a checked Sacrament Meeting Attendance date is selected
#      Then the date should be cleared
#

#
#    Scenario: As a leadership calling check the quick card for People Being Taught
#      Given a leader is on the Progress Record page
#      When the People Being Taught tab is selected
#      Then the members quick card information should be displayed
#
#    Scenario: As a leader edit the Lesson Progression - Principles Taught same thing?
#      Given a leader is on the Progress Record page
#      When a member is selected
#      Then then the edit button for Lesson Progression should be diplayed
#      And when a lesson is selected
#      Then the lesson box should turn green
#
#  #    Should this check all the edit buttons?
#      #****** not in JIRA yet **********
#    Scenario: As a ward council view only Lesson Progression
#      Given a ward council member is on the Progress Record page
#      When a member is selected
#      Then the edit button should not be displayed
#
#    Scenario: Friends in the Church in Stake
#      Given a ward council member is on the Progress Record page
#      When a member is selected
#      And a friend from the stake is added to the member
#      Then the friend should be displayed
#
#    Scenario: Friends in the Church outside of Stake
#      Given a ward council member is on the Progress Record page
#      When a member is selected
#      And a friend from outside of the stake is added to the member
#      Then the friend should be displayed

#    Scenario: Priesthood Ordinations
#    Scenario: Calling
#    Scenario: Ministering Assignments
#    Scenario: Ministering Brothers Sisters?
#    Scenario: Prepare a Family name for the Temple
#    Scenario: Baptisms for Deceased Ancestor
#    Scenario: Temple Ordinances
#    Scenario: Self-Reliance Class
#    Scenario: Filter?
#    Scenario: Alerts? # This might need to be a feature file on its own.
#    Scenario: API tests
#    Scenario: Get to the members Progress Record from the Directory
#    Scenario: Login as progress record member check My Covenant Path

#    Scenario: Check callings that should not have access to Progress record






