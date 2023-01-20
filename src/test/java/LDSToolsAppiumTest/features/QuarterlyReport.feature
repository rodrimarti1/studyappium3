@QuarterlyReport
  Feature: Test Quarterly Report and Report Submission


    Scenario: Verify Quarterly Report info
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

    @jft
    Scenario Outline: Stake member verify info
      Given a "STAKE_PRESIDENT" logs in
      And is on the Quarterly Report page
      Then a <unitName> is selected for <unitNumber> the info will be correct
      Examples:
        | unitName    | unitNumber |
        | "MacGregor" | "221562"   |

      #Not sure about this. I don't want to send a bunch of reminders out, maybe just verify that it is possible
    Scenario: Stake member send reminder
      Given a "STAKE_PRESIDENT" logs in
      And is on the Quarterly Report page
      When the "STAKE UNIT" is changed in the unit selector
      And Send Reminder is pressed
      Then A Reminder can be sent


    Scenario: offline mode?