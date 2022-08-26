@ListsWithSample
  Feature: Test the Lists functionality of Member Tools

    Background:
      Given a list with sample setup user signs in
      And is on the list page with sample


    @MQA-5718 @MQA-2215 @all @all2 @daily @daily2 @jft
    Scenario: Delete a list
      When the list "Delete This List" is deleted
      Then the list "Delete This List" will be deleted

    @MQA-5719 @MQA-2215 @all @all3 @daily @daily3
    Scenario: Delete a member from a list
      When a member "Steven Boat" is deleted from "My Member List"
      Then the member "Steven Boat" will be deleted from "My Member List"

#      @MQA-5721 @MQA-2215 @all @all1 @daily @daily1 @jft
    #TODO: Rotate doesn't work anymore need to find an alternative.
    Scenario: Rotate lists
      When the device is rotated
      Then the information for the lists setup will be visible

    @MQA-5722 @MQA-2215 @all @all2 @daily @daily2
    Scenario: Change the name of a list
      When a list name is changed
      Then the list name will be updated



