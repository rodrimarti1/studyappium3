@ClassAndQuorum
  Feature: Class and Quorum Attendance tests

    @MQA-3517 @MQA-2225 @all @all1 @daily @daily2 @jft
    Scenario Outline: As a leader I should have access to Class and Quorum Attendance reports
      Given a <leader> logs in and is on the Class and Quorum Attendance page
      When a <memberRecord> is searched for
      Then the class and quorum attendance <memberRecord> will be displayed
      And the attendance <can> be edited
      Examples:
        | leader                     | memberRecord      | can    |
        | "BISHOP"                   | "Bryson, David"   | "true" |
#        | "BISHOPRIC_SECOND_COUNSELOR"      | "Bryson, David"   | "true" |
#        | "BISHOPRIC_SECOND_COUNSELOR"      | "Bryson, David"   | "true" |
#        | "WARD_CLERK"                      | "Bryson, David"   | "true" |
#        | "WARD_EXECUTIVE_SECRETARY"        | "Bryson, David"   | "true" |
        | "ELDERS_QUORUM_PRESIDENT"  | "Bryson, David"   | "true" |
##      | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "Bryson, David"    | "true"     |
#        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "Bryson, David"   | "true" |
#        | "ELDERS_QUORUM_SECRETARY"         | "Bryson, David"   | "true" |
        | "RELIEF_SOCIETY_PRESIDENT" | "Dunford, Rachel" | "true" |
##        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Borden, Shirley" | "true" |
#        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Borden, Shirley" | "true" |
        | "YOUNG_WOMEN_PRESIDENT"    | "Estrada, Alexis" | "true" |
#        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "Bryson, David"   | "true" |
#        | "SUNDAY_SCHOOL_PRESIDENT"         | "Bryson, David"   | "true" |
#      | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "Bryson, David"             | "true"     | No Sunday School First Counselor
#      | "WARD_MISSION_LEADER"             | "Bryson, David"             | "true"     | No Ward Mission Leader for this Ward right now



    @MQA-3519 @all @smoke @smoke2 @all1 @daily @daily2
    Scenario: As a Bishopric member I should be able to mark a members attendance
      Given a member of the bishopric logs in and is on the Class and Quorum Attendance page
      When week one is marked attended
      Then week one will have a check mark

    @MQA-3520 @all @all1 @daily @daily3
    Scenario: As a Bishopric member I should have access to the filters in Class and Quorum Attendance
      Given a member of the bishopric logs in and is on the Class and Quorum Attendance page
      When filters is selected
      Then a list of classes will be displayed
      When I select a class
      Then The class list will be displayed

    @MQA-3520 @all @all1 @daily @daily4
    Scenario: Check attendance from individual users page
      Given a member of the bishopric logs in and is on the Class and Quorum Attendance page
      When a member record is selected
      Then the individual attendance should be displayed

    @MQA-3522 @all @all1 @daily @daily1
    Scenario Outline: As a leader I should be able to search for members in Class and Quorum Attendance
      Given a <leader> logs in and is on the Class and Quorum Attendance page
      When a <memberRecordElder> is searched for
      Then the member <memberRecordElder> will <willElder> be displayed
      When a <memberRecordRS> is searched for
      Then the member <memberRecordRS> will <willRS> be displayed
      When a <memberRecordAaronic> is searched for
      Then the member <memberRecordAaronic> will <willAaronic> be displayed
      When a <memberRecordYW> is searched for
      Then the member <memberRecordYW> will <willYW> be displayed
      When a <memberRecordPrimary> is searched for
      Then the member <memberRecordPrimary> will <willPrimary> be displayed
      Examples:
        | leader                     | memberRecordElder | willElder | memberRecordRS   | willRS  | memberRecordAaronic | willAaronic | memberRecordYW     | willYW  | memberRecordPrimary | willPrimary |
        | "BISHOP"                   | "Bryson, David"   | "true"    | "Carter, Tanya" | "true"  | "Crumby, Traevon"   | "true"      | "Chappell, Audrey" | "true"  | "Sosa, Kailey"      | "true"      |
        | "ELDERS_QUORUM_PRESIDENT"  | "Bryson, David"   | "true"    | "Carter, Tanya" | "false" | "Crumby, Traevon"   | "false"     | "Chappell, Audrey" | "false" | "Sosa, Kailey"      | "false"     |
        | "RELIEF_SOCIETY_PRESIDENT" | "Bryson, David"   | "false"   | "Carter, Tanya" | "true"  | "Crumby, Traevon"   | "false"     | "Chappell, Audrey" | "false" | "Sosa, Kailey"      | "false"     |
        | "YOUNG_WOMEN_PRESIDENT"    | "Bryson, David"   | "false"   | "Carter, Tanya" | "false" | "Crumby, Traevon"   | "false"     | "Chappell, Audrey" | "true"  | "Sosa, Kailey"      | "true"      |
#        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "Bryson, David"       | "false"    |  "Adams, Maegan Fudge" | "false" | "Crumby, Traevon"      | "false"      |"Chappell, Audrey" | "true"    | "Sosa, Kailey"       | "true"      |
#        | "SUNDAY_SCHOOL_PRESIDENT"         | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"      | "true"       |"Chappell, Audrey" | "true"    | "Sosa, Kailey"       | "false"      |
#        | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"      | "true"       |"Chappell, Audrey" | "true"    | "Sosa, Kailey"       | "false"      |
#        | "BISHOPRIC_SECOND_COUNSELOR"      | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"      | "true"       |"Chappell, Audrey" | "true"    | "Sosa, Kailey"       | "true"       |
#        | "BISHOPRIC_SECOND_COUNSELOR"      | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"      | "true"       |"Chappell, Audrey" | "true"    | "Sosa, Kailey"       | "true"       |
#        | "WARD_CLERK"                      | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"      | "true"       |"Chappell, Audrey" | "true"    | "Sosa, Kailey"       | "true"       |
#        | "WARD_EXECUTIVE_SECRETARY"        | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"      | "true"       |"Chappell, Audrey" | "true"    | "Sosa, Kailey"       | "true"       |
##        | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "false" | "Crumby, Traevon"      | "false"      |"Chappell, Audrey" | "false"   | "Sosa, Kailey"       | "false"      |
#        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "false" | "Crumby, Traevon"      | "false"      |"Chappell, Audrey" | "false"   | "Sosa, Kailey"       | "false"      |
#        | "ELDERS_QUORUM_SECRETARY"         | "Bryson, David"       | "true"     |  "Adams, Maegan Fudge" | "false" | "Crumby, Traevon"      | "false"      |"Chappell, Audrey" | "false"   | "Sosa, Kailey"       | "false"      |
##        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Bryson, David"       | "false"    |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"      | "false"      |"Chappell, Audrey" | "false"   | "Sosa, Kailey"       | "false"      |
#        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Bryson, David"       | "false"    |  "Adams, Maegan Fudge" | "true"  | "Crumby, Traevon"       | "false"      |"Chappell, Audrey" | "false"   | "Sosa, Kailey"       | "false"      |





#    Scenario: Filter tests - By calling?
#    Scenario: Check graph - ?
#    Scenario: Stake member?