@Lists
  Feature: Test the Lists functionality of Member Tools

    Background:
      Given a list user signs in
      And is on the list page

    @MQA-5711 @MQA-2215 @all @all1 @daily @daily1 @smoke @smoke1
    Scenario: Create a list and add a member to the list
      When I add a List "New Automated List"
      And members are added to the list
        | barker, susan |
      Then the "New Automated List" with the members should be displayed.

    @MQA-5712 @MQA-2215 @all @all2 @daily @daily2
    Scenario: Create a list and add multiple members
      When I add a List "Test List 1"
      And members are added to the list
        | barker, susan       |
        | lambert, audrey     |
        | lambert, jacqueline |
        | lambert, john       |
        | boat, steven        |
        | dunford, rachel     |
      Then the "Test List 1" six members should be displayed on the list

    @MQA-5714 @MQA-2215 @all @all3 @daily @daily3
    Scenario: Max out a list name
      When I add a List "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
      And members are added to the list
        | barker, susan |
      Then the "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" with the members should be displayed.

    @MQA-5715 @MQA-2215 @all @all4 @daily @daily4
    Scenario: Create a list with odd characters
      When I add a List "!@#$%^&*(){}[]~~//??.,<>;;;;;"
      And members are added to the list
        | barker, susan |
      Then the "!@#$%^&*(){}[]~~//??.,<>;;;;;" with the members should be displayed.

    @MQA-5716 @MQA-2215 @all @all1 @daily @daily1
    Scenario: Create a list with ampersands
      When I add a List "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"
      And members are added to the list
        | barker, susan |
      Then the "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" with the members should be displayed.

    @MQA-5718 @MQA-2215 @all @all2 @daily @daily2
    Scenario: Delete a list
      And sample lists are setup
      When the list "Delete This List" is deleted
      Then the list "Delete This List" will be deleted

    @MQA-5719 @MQA-2215 @all @all3 @daily @daily3
    Scenario: Delete a member from a list
      And sample lists are setup
      When a member "Steven Boat" is deleted from "My Member List"
      Then the member "Steven Boat" will be deleted from "My Member List"

    @MQA-5720 @MQA-2215 @jft
    Scenario: Create a list with a large number of members
      When a list is created with a large number of members
      Then the large number list will be created

    @MQA-5721 @MQA-2215
    Scenario: Rotate lists
      And sample lists are setup
      When the device is rotated
      Then the information for the lists setup will be visible

    @MQA-5722 @MQA-2215
    Scenario: Change the name of a list
      And sample lists are setup
      When a list name is changed
      Then the list name will be updated



