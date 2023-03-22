@QuarterlyReport
  Feature: Test Quarterly Report and Report Submission

    @MQA-7009 @MQA-2225 @all @all4 @daily @daily4 @smoke @smoke4 @jft
    Scenario: Verify Quarterly Report info Bishop
      Given a "BISHOP" logs in
      And is on the Quarterly Report page
      When the Quarterly Report info is received for "39373"
      Then the Quarterly Report info will match

    #Who can submit?
    #Need a way to test when QR is not due
    #Undo a QR submission?
    #verify info with api?
    Scenario: Submit Quarterly Report info
      Given a "WARD_CLERK" logs in
      And is on the Quarterly Report page
      When a Quarterly Report is submitted
      Then the Quarterly Report will be sent

    @MQA-7010 @MQA-2225 @all @all3 @daily @daily3
    Scenario: Stake member verify info
      Given a "STAKE_PRESIDENT" logs in
      And is on the Quarterly Report page
      Then a unit is selected the info will be correct
        | MacGregor,221562          |
        | Braes Bayou,230324        |
        | Hermann Park,354538        |
        | Houston 1st,140732        |
        | Houston 2nd,167002        |
        | Houston 9th,239372        |
        | Maplewood 2nd,39373       |
        | Memorial Park 1st,157007  |
        | Memorial Park 2nd,2023806 |
        | West University,2099969   |


      #Not sure about this. I don't want to send a bunch of reminders out, maybe just verify that it is possible
    Scenario: Stake member send reminder
      Given a "STAKE_PRESIDENT" logs in
      And is on the Quarterly Report page
      When the "STAKE UNIT" is changed in the unit selector
      And Send Reminder is pressed
      Then A Reminder can be sent


    Scenario: offline mode?