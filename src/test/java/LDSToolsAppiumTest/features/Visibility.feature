@Visibility
  Feature: Test visibility setting in directory

    #Do a different feature file with sample to check all API settings quickly?

    #A User changes settings - HOW LONG BEFORE YOU CAN?
    #Logout before changes are updated - automatic update? No automatic update - what happens?
    #Check with
    #Ward Leadership
    #Ward Member - no leader
    #Stake Leadership
    #Stake Member
    #Spouse or child
    #Check Web LCR? Directory? Maps?
    #Don't see vis update again

    #Default in Europe still "Stake and ward organization presidencies"

    #Check all buttons and info

    Scenario: New install visibility pop up checker
      Given a "katanajeanw" logs in to the visibility pop up page
      When Your Information Visibility page is displayed
      Then the Your Information Visibility information will be correct
      When your personal information page is displayed
      Then the personal information will be correct for "Allen, Katana Jean"
      When your Data settings page is displayed
      Then the Data settings page information will be correct

      #Check all buttons and info
    @jft
    Scenario: New install visibility settings checker
      Given the proxy "katanajeanw" logs in
      And is on the Directory Page
      When the visibility settings are displayed for "Allen, Katana Jean"
      Then the visibility information will be correct for "Allen, Katana Jean"


    #Manual only?
    Scenario: Check visibility setting on upgrade
      Given a "USER" is on the shipping verstion
      When they upgrade the app
      Then the visibility information will be correct



    #Api tests to check?
    #Check GUI settings are correct
    #Login with other callings - this will be slow.
    Scenario Outline: Visibility pop up Edit Visibility
      Given a "USER" logs in to the visiblity page
      When the Acknowledge button is pressed
      And the <nameBirthdayAndAge> <photo> <phone> <email> <householdPhoto> <address> are set
      Then the visiblity will be correct
      Examples:
        | nameBirthdayAndAge                         | photo                                      | phone                                      | email                                      | householdPhoto                             | address                                    |
        | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            |
        | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             |
        | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" |
        | "Default"                                  | "Default"                                  | "Default"                                  | "Default"                                  | "Default"                                  | "Default"                                  |
        | "Ward Members"                             | "Stake Members"                            | "Ward Members"                             | "Stake Members"                            | "Ward Members"                             | "Stake Members"                            |

    Scenario Outline: Set all of the visibility settings
      Given a "USER" logs in to the visibility page
      When the Acknowledge button is pressed
      And the All Settings are set to <visibilitySetting>
      Then the visiblity will be correct
      Examples:
        | visibilitySetting                          |
        | "Stake Members"                            |
        | "Ward Members"                             |
        | "Stake and ward organization presidencies" |

      #Add more Examples
    Scenario Outline: Visibility pop up Edit data settings
      Given a "USER" logs in to the visiblity page
      When the Data Settings page is displayed
      And the data settings are set to <automaticUpdate> <updateWiFi> <memberPhotos> <otherPhotos>
      Then the data settings will be <automaticUpdate> <updateWiFi> <memberPhotos> <otherPhotos>
      Examples:
        | automaticUpdate | updateWiFi | memberPhotos | otherPhotos |
        | "on"            | "on"       | "on"         | "on"        |
        | "off"           | "off"      | "off"        | "off"       |


    #Api tests to check?
    #Check GUI settings are correct
    #Login with other callings - this will be slow.
    Scenario Outline: Edit Visibility from Directory
      Given a "USER" logs in
      And is on the member Directory page
      When the Edit Button is pressed
      And the <nameBirthdayAndAge> <photo> <phone> <email> <householdPhoto> <address> are set
      Then the visiblity will be correct
      Examples:
        | nameBirthdayAndAge                         | photo                                      | phone                                      | email                                      | householdPhoto                             | address                                    |
        | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            | "Stake Members"                            |
        | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             | "Ward Members"                             |
        | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" | "Stake and ward organization presidencies" |
        | "Default"                                  | "Default"                                  | "Default"                                  | "Default"                                  | "Default"                                  | "Default"                                  |
        | "Ward Members"                             | "Stake Members"                            | "Ward Members"                             | "Stake Members"                            | "Ward Members"                             | "Stake Members"                            |


      #Parent update kids
    Scenario Outline: Head of Household can update household members visibility settings
      Given a "USER" logs in
      And is on the member Directory page
      When the visiblity settings are set to "Stake and ward organization presidencies" for a <memberOfHousehold>
      Then the visiblity will be correct
      Examples:
        | memberOfHousehold            |
        | "Child Member"               |
        | "Under 18 - not accountable" |

    Scenario: Child cannot update their own visibility settings
      Given a "CHILD" logs in
      And is on the member Directory page
      When visibility is accessed
      Then visibility cannot be set


    #This may not work no but be in the future
    Scenario: a child member in multiple households
      Given a child is a member of multiple households
      When the visibility settings are changes
      Then the settings will be changed for one household?


      #Add contact info privacy
    Scenario: Add contact info with privacy settings
      Given a "USER" logs in
      And is on the member Directory page
      When the add contact is selected
      Then only the visible setting will be added to the contact

      #Clipboard
    Scenario: Verify the copy options for visibility
      Given a "LEADER" logs in
      And is on the member Directory page
      When a private visiblity settings is copied
      Then the setting will no be copied?

      #Upgrade set privacy before
    Scenario: Upgrade from an older vesion with privacy settings
      Given a "USER" has an older version installed
      When the app is upgraded
      Then the visibility settings will be correct


      #Delete works
    Scenario: Make sure deleting the phone and email works
      Given a "USER" logs in
      And is on the member Directory page
      When the phone and email are deleted
      Then the phone and email will be deleted for all members

      #Household phone email gone
    Scenario: Make sure the household phone and email are gone
      Given a "USER" logs in
      And is on the member Directory page
      When a member is selected
      Then the household phone and email fields will be removed.


      #Ministering can see - Future
      #Out of unit - only primary parent? Next year.