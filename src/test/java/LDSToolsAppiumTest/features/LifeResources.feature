@LifeResources
Feature: Test Life Resources


  Scenario: Life Resource check correct data
    Given a "MEMBER1" logs in and is on the Life Resources page
    When a "Addiction Recovery Program" is selected
    Then the information will be displayed
      | Church Resource                                             |
      | Addiction                                                   |
      | Mental and Emotional Health                                 |
      | Addiction Recovery Program                                  |
      | https://addictionrecovery.churchofjesuschrist.org/?lang=eng |


  Scenario: Search for a Life Resource
    Given a "MEMBER1" logs in and is on the Life Resources page
    When a "Houston Texas Employment Resource Center" is searched for in Life Resources
    And a "Houston Texas Employment Resource Center" is selected
    Then the information will be displayed
      | Houston Texas Employment Resource Center      |
      | 888-818-4484                                  |
      | WEL-EC-Houston@ChurchofJesusChrist.org        |
      | 8625 Cypress Creek Parkway, Houston TX 77070" |
      | Sandra Marie Holmes                           |
      | Employment Resource Center Manager            |
#      | Church Resource                               |

    #Lots of different categories - use an API test to test all?
  @jft
  Scenario Outline: Select different categories
    Given a <member> logs in and is on the Life Resources page
    When a <category> is selected in Life Resources
    Then the Life Resource <categoryResource> will be displayed
    And the Life Resource <notDisplayed> will not be displayed
    Examples:
      | member   | category    | categoryResource             | notDisplayed                                         |
      | "BISHOP" | "Addiction" | "Addiction Recovery Program" | "Finding Strength in the Lord: Emotional Resilience" |


    #This may not work on simulator. OR need to set sim to local address?
    #Distances: All, 5.0, 10, 25, 50, 100
  Scenario Outline: Select different distances
    Given a <member> logs in and is on the Life Resources page
    When the <distance> is selected in Life Resources
    Then the Life Resource <distanceResource> will be displayed
    Examples:
      | member   | distance   | distanceResource |
      | "BISHOP" | "25 miles" | "Some resource"  |


    #Combine the top 3 tests at once... May want to rethink on how to do this.
  Scenario: Distance Category and Search?
    Given a <member> logs in and is on the Life Resources page
    When a <distance> <category> and <LifeResource> is selected
    Then the <LifeResource> will be displayed

    #May include more info fields for Category and distance
    #Different callings get different resources?
  Scenario Outline: Select items and verify
    Given a <member> logs in and is on the Life Resources page
    When a <LifeResource> is slected
    Then the correct <LifeResourceInfo> will be displayed
    Examples:
      | member   | LifeResource                 | LifeResourceInfo                                              |
      | "BISHOP" | "Addiction Recovery Program" | "https://addictionrecovery.churchofjesuschrist.org/?lang=eng" |


    #Stake Pres
    Scenario: Create a LR
    Scenario: Edit a LR
    Scenario: Delete a LR
    Scenario: Create a LR - Leadership only
