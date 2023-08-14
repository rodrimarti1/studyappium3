@PrayerRoll
Feature: Prayer Roll tests


  @MQA-3180 @all @smoke @smoke1 @all1 @all @daily @daily1 @jft
  Scenario:  As a member I want to enter a name into the Prayer Roll
    Given a member is on their Temple Page
    When the prayer roll button is pressed
    Then I should see the prayer roll page
    And the member enters in a name
    Then the name should be submitted

  @MQA-3181 @all @all2 @all @daily @daily2
  Scenario: As a member I want to enter several names into the Prayer Roll
    Given a member is on the prayer roll page
    When the member enters in five names
    Then the name should be submitted

  @MQA-3182 @all @all2 @all @daily @daily3
  Scenario: As a member I want to cancel entering in names for the prayer roll
    Given a member is on the prayer roll page
    When the member enters in five names then cancels
    Then the names should not be submitted

#  Scenario: As a member test the max length of prayer roll (Android - 60)
#  Scenario: As a member test that every temple sends names to the assigned temple
