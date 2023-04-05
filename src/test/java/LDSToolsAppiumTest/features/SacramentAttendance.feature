@SacramentAttendance
  Feature: Sacrament Meeting Attendance
    As a Bishopric member
    I want to enter in and view Sacrament Attendance
    As a Ward Council member
    Sacrament Attendance should not be displayed

    @MQA-3183 @all @all1 @smoke @smoke3 @all @daily @daily3 @jft
    Scenario: As a Bishop enter a number and have it saved
      Given a "BISHOP" is on the Sacrament Attendance page
      When "159" is entered in the "First Date Field"
      Then I should see "159" in the "First Date Field"

    @MQA-3184 @all @all4 @all @daily @daily4
    Scenario: As a Ward Clerk enter a number and have it saved
      Given a "WARD_CLERK" is on the Sacrament Attendance page
      When "77" is entered in the "First Date Field"
      Then I should see "77" in the "First Date Field"

    @MQA-3185 @all @nonBishopric @all4 @all @daily @daily4
    Scenario: A Ward Council member should not see Sacrament Attendance
      Given a "ELDERS_QUORUM_PRESIDENT" is on the Reports page
      Then I should not see "Sacrament Attendance"

    @MQA-3186 @all @all2 @all @daily @daily2
    Scenario: Enter Sacrament Attendance using the counter
      Given a "WARD_CLERK" is on the Sacrament Attendance page
      When a "27" is entered using the counter
      Then I should see "27"

    @MQA-3187 @all @androidOnly @all4
    Scenario: In the counter use the next section several times
      Given a "WARD_CLERK" is on the Sacrament Attendance page
      When a 27 35 5 48 is entered using the counter and next section
      Then I should see "115"

    @MQA-3188 @all @all3 @all @daily @daily3
    Scenario: On the Sacrament counter use both plus and minus
      Given a "WARD_CLERK" is on the Sacrament Attendance page
      When a "38" is entered using the counter without saving
      And a "5" is entered in using the minus counter
      Then I should see "33"




#    Scenario: Long press and enter a number from the counter
#
#    Scenario: Use the counter then hit cancel
#
#    Scenario: Show Past Months - check data?
#
#    Scenario: Check graph?
