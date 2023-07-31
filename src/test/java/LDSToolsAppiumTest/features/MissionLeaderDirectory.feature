@MissionLeaderDirectory
  Feature: Test Mission Leader directory

#    Mission Pres: olausondj
#    Member: hansenji

#    Returned Missionary: zsgallafent
#    His Mission President: kumfy
#
#    A Current Mission President: perezdomingo
#    His Companion: magdelis1
#
  @MQA-5396 @MQA-2223 @daily @daily3 @smoke @smoke3 @all @all3
  Scenario: Mission President (kumfy) logs in and can view returned missionaries
    Given a member "kumfy" logs in
    When they check their Mission under Directory
    Then they should see a list of their missionaries

  @MQA-5400 @MQA-2223 @all @all4 @daily @daily4
  Scenario: Mission President companion (kumfyid) see all mission
    Given a member "kumfyid" logs in
    When they check their Mission under Directory
    Then they should see a list of their missionaries

  @MQA-5397 @MQA-2223 @all @all1 @daily @daily1
  Scenario: Mission President contacts missionary
    Given a member "kumfy" logs in
    When they select a missionary under their mission
    Then they should have contact information

  @MQA-5398 @MQA-2223 @notValidAnymore
  Scenario: Missionary sign up in Whats New
    Given a member "zsgallafent" logs in
    When the Whats New Page is displayed
    Then the missionary opt in will be displayed


  @MQA-5400 @MQA-2223 @all @all3 @daily @daily3
  Scenario: Mission President viewing a Return Missionary info marked private
    Given a member "kumfy" logs in
    When they select a missionary under their mission
    Then the Returned Missionary info should be marked private


  @MQA-5400 @MQA-2223 @all @all1 @daily @daily1 @jft @jft
  Scenario: Returned Missionary add and remove Mission President access
    Given a returned missionary logs in and Mission Leader is turned off
    When a member "tdlarkin" logs in
    Then the Mission President will not see the Returned Missionary


  @MQA-5399 @MQA-2223 @all @all4 @daily @daily4
  Scenario: Missionary sign up in Settings
    Given a member "zsgallafent" logs in
    When the Settings page is selected
    Then the missionary opt in will be displayed

#  Scenario: Email form check


#  Scenario: Mission President divorce or widow can companion see Returned Missionaries ## Not sure what happens here
#  Scenario: Notification test - part of other tests?
#  Scenario: Full size photos
#  Scenario: New Missionary notification Jeremymunoz2013






