@LifeResourcesSample
Feature: Test Life Resources with Samples

  Background:
    Given The sample life resources are created
    Then The sample life resource will be displayed

  @cleanup @jft
  Scenario: A non leader views a Leadership only resource
    Given a "MEMBER1" logs in and is on the Life Resources page
    When a "Sample One" is searched for in Life Resources
    And a "Sample One" is selected
    Then the information will be displayed
      | Please contact your Relief Society or Elders Quorum President for help with this resource |
      | Sample One                                                                                |

  @cleanup
  Scenario: A non leader views a Leadership only resource
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




  Scenario: Delete a LR

  Scenario: View LR - Leadership only - leader and non leader

