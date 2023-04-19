@AdditionalUnit
  Feature: Test the Additional Unit Functionality

    @MQA-7107 @MQA-2217
    Scenario Outline: Add an additional unit
      Given a "USER" logs in
      And is on the Update page
      When an additional unit is added by <unitType>
      Then the additional unit will be displayed
      Examples:
        | unitType         |
        | "Centinela Ward" |
        | "21628"          |
        | "mbthomas74"     |

    @MQA-7108 @MQA-2217
    Scenario Outline: Test location for additional unit
      Given a "USER" logs in
      And is on the Update page
      When an additional unit is selected
      And <locationType> selected
      Then a list of units <willOrWillNot> be displayed
      Examples:
        | locationType            | willOrWillNot |
        | "Allow Once"            | "will"        |
        | "Allow While Using App" | "will"        |
        | "Don't Allow"           | "will not"    |

    @MQA-7109 @MQA-2217
    Scenario: Favorites for additional units
      Given a "USER" logs in
      And is on the Update page
      When a favoirite is selected
      Then the favorite will be displayed

    @MQA-7110 @MQA-2217
    Scenario: Recent units for additional units
      Given a "USER" logs in
      And is on the Update page
      When several additional units are selected
      Then the units will be displayed in Recent Units


