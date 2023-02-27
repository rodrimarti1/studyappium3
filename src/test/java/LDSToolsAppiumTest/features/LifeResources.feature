@LifeResources
Feature: Test Life Resources

  @MQA-6683 @MQA-6682 @notValidAnymore
  Scenario: Life Resource check correct data
    Given a "MEMBER1" logs in and is on the Life Resources page
    When a "Addiction Recovery Program" is selected
    Then the information will be displayed
      | Church Resource                                             |
      | Addiction                                                   |
      | Mental Health                                               |
      | Addiction Recovery Program                                  |
      | https://addictionrecovery.churchofjesuschrist.org/?lang=eng |

  @MQA-6684 @MQA-6682 @notValidAnymore
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


    #Manually Only For Now
  #Todo: iOS is not seeing the elements correctly. Need appium 2.0?
  @MQA-6685 @MQA-6682
  Scenario: Create a Life Resource
    Given a "STAKE_PRESIDENT" logs in and is on the Life Resources page
    When a Life Resource is created "Appium Test One"
    And a "Appium Test One" is searched for in Life Resources
    Then the Life Resource "Appium Test One" will be displayed

      #Todo: iOS is not seeing the elements correctly. Need appium 2.0?
  @MQA-6686 @MQA-6682
  Scenario: Edit a Life Resource
    Given a "STAKE_PRESIDENT" logs in and is on the Life Resources page
    When a Life Resource is Edited "Appium Test One" to "Appium Test EDITED"
    And a "Appium Test EDITED" is searched for in Life Resources
    Then the information will be displayed
      | Appium Test EDITED                            |
      | 888-818-4484                                  |
      | WEL-EC-Houston@ChurchofJesusChrist.org        |
      | 8625 Cypress Creek Parkway, Houston TX 77070" |
      | Sandra Marie Holmes                           |
      | Employment Resource Center Manager            |

        #Lots of different categories - use an API test to test all?
  #Todo: iOS cannot select a category, Appium sees the element but cannot click on it.
  @MQA-6687 @MQA-6682
  Scenario Outline: Select different categories
    Given a <member> logs in and is on the Life Resources page
    When a <category> is selected in Life Resources
    Then the Life Resource <categoryResource> will be displayed
    And the Life Resource <notDisplayed> will not be displayed
    Examples:
      | member   | category    | categoryResource             | notDisplayed                                         |
      | "BISHOP" | "Addiction" | "Addiction Recovery Program" | "Finding Strength in the Lord: Emotional Resilience" |

    #Todo: iOS cannot select a distance, Appium sees the element but cannot click on it.
    #This may not work on simulator. OR need to set sim to local address?
    #Distances: All, 5.0, 10, 25, 50, 100
  @MQA-6688 @MQA-6682
  Scenario Outline: Select different distances
    Given a <member> logs in and is on the Life Resources page
    When the <distance> is selected in Life Resources
    Then the Life Resource <distanceResource> will be displayed
    Examples:
      | member   | distance   | distanceResource |
      | "BISHOP" | "25 miles" | "Some resource"  |

  #Todo: iOS cannot select a distance or category, Appium sees the element but cannot click on it.
    #Combine the top 3 tests at once... May want to rethink on how to do this.
  @MQA-6689 @MQA-6682
  Scenario: Distance Category and Search?
    Given a <member> logs in and is on the Life Resources page
    When a <distance> <category> and <LifeResource> is selected
    Then the <LifeResource> will be displayed




