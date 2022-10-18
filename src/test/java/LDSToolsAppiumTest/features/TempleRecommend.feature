@TempleRecommend
Feature: Test digital Temple Recommends

  #how to check the number to see if it is valid - api?
  #different types check all fields?
  @MQA-6284 @MQA-2216
  Scenario Outline: Show recommend from temples
    Given a <member> logs in and is on the Temples Page
    When Temple Recommend is selected
    Then the recommend will be displayed with <recommendType>
    Examples:
      | member               | recommendType    |
      | RegularRecommendUser | RegularRecommend |
      | LimitedUseUser       | LimitedUse       |
      | NonExpiringUser      | NonExpiring      |
      | LivingUser?          | Living?          |
      | UnknownUser?         | Unknown?         |

  @MQA-6285 @MQA-2216
  Scenario: Synchronize with Temple
    Given a <member> logs in and is on the Temple Recommend Page
    When the Synchronize with Temple Button is pressed
    Then the Synchronize will be verified

  @MQA-6286 @MQA-2216
  Scenario Outline: Expiration reminder On - Off
    Given a <member> logs in and is on the Temple Recommend Page
    When the reminder is turned <reminderStatus>
    Then the reminder will be <reminderStatus>
    Examples:
      | reminderStatus |
      | on             |
      | off            |

  @MQA-6287 @MQA-2216
  Scenario: Show recommend from menu
    Given a <member> logs in and is on the Directory page
    When the menu is selected
    And the Temple recommend button is pressed
    Then the Temple recommend will be displayed

  @MQA-6288 @MQA-2216
  Scenario: Paper recommend
    Given a <member> logs in and is on the Temples Page
    Then the Temple Recommend button will not be displayed


  #manual only with scanner?
  @MQA-6289 @MQA-2216
  Scenario Outline: Scan recommend
    Given a <member> logs in with <device> and is on the Temple Recommend Page
    When the recommend is scanned
    Then The scanner will show the correct information
    Examples:
      | member     | device         |
      | testMember | regular device |
      | testMember | Landscape mode |
      | testMember | tablet         |
      | testMember | Small device   |
      | testMember | Broken Screen  |
      | testMember | Airplane Mode  |
      | testMember | dim screen     |

