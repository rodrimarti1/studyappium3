@LifeResourcesSample
Feature: Test Life Resources with Samples

  Background:
    Given The sample life resources are created
    Then The sample life resource will be displayed

  @cleanup @MQA-6690 @MQA-6682 @all @all4 @daily @daily4
  Scenario: A non leader views a Leadership only resource
    Given a "MEMBER1" logs in and is on the Life Resources page
    When a "Sample One" is searched for in Life Resources
    And a "Sample One" is selected
    Then the information will be displayed
      | Please contact your Relief Society or elders quorum president for help with this resource |
      | Sample One                                                                                |


  @cleanup @MQA-6691 @MQA-6682 @all @all1 @daily @daily1
  Scenario: A leader views a Leadership only resource
    Given a "BISHOP" logs in and is on the Life Resources page
    When a "Sample One" is searched for in Life Resources
    And a "Sample One" is selected
    Then the information will be displayed
      | Share resource details only as needed. Not intended for public visibility |
      | Sample One                                                                |
      | 3740 W Market Center Dr, Riverton, UT 84065                               |
      | Sample one description                                                    |
      | Sample Notes                                                              |
      | 999-888-7777                                                              |
      | https://www.google.com                                                    |



  @cleanup @MQA-6692 @MQA-6682 @all @all2 @daily @daily2 @jft
  Scenario: A Stake Leader deletes a Life Resource
    Given a "STAKE_PRESIDENT" logs in and is on the Life Resources page
    When a "Sample Two" is searched for in Life Resources
    And a "Sample Two" is selected
    And the delete button is pressed
    Then the "Sample Two" will be deleted



