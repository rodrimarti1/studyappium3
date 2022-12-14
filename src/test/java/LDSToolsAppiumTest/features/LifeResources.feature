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

    #Stake Pres
  #Todo: iOS is not seeing the elements correctly. Need appium 2.0?
  Scenario: Create a Life Resource
    Given a "STAKE_PRESIDENT" logs in and is on the Life Resources page
    When a Life Resource is created "Appium Test One"
    And a "Appium Test One" is searched for in Life Resources
    Then the Life Resource "Appium Test One" will be displayed

    #Todo: iOS not seeing the elements correctly
  Scenario: Edit a LR

  Scenario: Delete a LR
  Scenario: Create a LR - Leadership only

        #Lots of different categories - use an API test to test all?
  #Todo: iOS cannot select a category, Appium sees the element but cannot click on it.
  Scenario Outline: Select different categories
    Given a <member> logs in and is on the Life Resources page
    When a <category> is selected in Life Resources
    Then the Life Resource <categoryResource> will be displayed
    And the Life Resource <notDisplayed> will not be displayed
    Examples:
      | member   | category    | categoryResource             | notDisplayed                                         |
      | "BISHOP" | "Addiction" | "Addiction Recovery Program" | "Finding Strength in the Lord: Emotional Resilience" |

    #todo: distance is not working yet
    #This may not work on simulator. OR need to set sim to local address?
    #Distances: All, 5.0, 10, 25, 50, 100
  Scenario Outline: Select different distances
    Given a <member> logs in and is on the Life Resources page
    When the <distance> is selected in Life Resources
    Then the Life Resource <distanceResource> will be displayed
    Examples:
      | member   | distance   | distanceResource |
      | "BISHOP" | "25 miles" | "Some resource"  |

 #todo: distance is not working yet
    #Combine the top 3 tests at once... May want to rethink on how to do this.
  Scenario: Distance Category and Search?
    Given a <member> logs in and is on the Life Resources page
    When a <distance> <category> and <LifeResource> is selected
    Then the <LifeResource> will be displayed




