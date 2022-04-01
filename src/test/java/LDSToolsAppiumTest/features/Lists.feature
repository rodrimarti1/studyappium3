@Lists
  Feature: Test the Lists functionality of Member Tools

    @jft
    Scenario: Create a list and add members to the list
      Given a user is logged in and on the Lists page
      When I add a List "New Automated List"
      And members are added to the list
        | "lovell, heather" |
      Then the "New Automated List" with the members should be displayed.


    Scenario: Create a list and add multiple members
      Given  a user is logged in and on the Lists page
      When I add a List "Test List 1"
      And members are added to the list
        | "lovell, heather" |
        | "lovell, kyler"   |
        | "carter, earon"   |
        | "carter, genie"   |
        | "carter, tanya"   |
        | "casas, sarai"    |
      Then the "Test List 1" six members should be displayed on the list


