@Expenses
  Feature: Test the Expenses for Member Tools

    #need to delete the default expenses on a clean up.
    #setup a bunch of expenses for testing
    #todo: setup other units - stake level?
    Background: Create Expenses for testing
      Given the setup expense for the api is run
      Then the default expenses will be setup

    #Approve tab
    #Other leaders to approve Stake Pres?
    @MQA-6456 @MQA-4817 @jft
    Scenario Outline: Expenses to Review to Approve Expenses
      Given a <leader> logs in and is on the Expenses page
      When an <expensePayee> with the <expenseAmount> is Reviewed with the <paymentType>
      Then the expense with <expensePayee>, <expenseAmount> and <paymentType> will be under Expenses to Approve
      And the user logs out
      When a <differentLeader> logs in and is on the Expenses page
      And the <expensePayee> with the <expenseAmount> is Approved with the <paymentType>
      Then the expense will be approved
      Examples:
        | leader   | expensePayee      | expenseAmount | paymentType | differentLeader |
        | "BISHOP" | "Stelter, Sharon" | "$53.99"      | "Check"     | "WARD_CLERK"    |
#        | "WARD_CLERK" | "Martinez Salguero, Cesar Leonel" | "$67.43"      | "Check"     | "BISHOPRIC_SECOND_COUNSELOR" |



    #for automation hard code one of the created expenses? or search for expense?
    #Just change the category do not submit?
    @MQA-6457 @MQA-4817
    Scenario: Approve Expenses change the category
      Given a "BISHOP" logs in and is on the Expenses page
      When a category is changed
      Then the category will be changed

      #add a category and do not submit
    #Todo: add several categories and submit
    @MQA-6458 @MQA-4817
    Scenario: Approve Expenses add categories
      Given a "BISHOP" logs in and is on the Expenses page
      When a category is added
      Then the category will be added to the expense

      #delete and add categories or just delete to see what happens?
    @MQA-6459 @MQA-4817
    Scenario: Approve Expenses delete all categories
      Given a "BISHOP" logs in and is on the Expenses page
      When all categories are deleted
      Then some error - waring?

      #May not be able to automate
    @MQA-6460 @MQA-4817
    Scenario: Approve Expenses view receipt
      Given a "BISHOP" logs in and is on the Expenses page
      When the receipt button is selected
      Then the receipt will be displayed

    @MQA-6461 @MQA-4817
    Scenario: Approve Expenses add attachment
      Given a "BISHOP" logs in and is on the Expenses page
      When an attachment is added
      Then the attachment is added to the expense

    @MQA-6462 @MQA-4817
    Scenario: Approve Expenses Reject Expenses
      Given a "BISHOP" logs in and is on the Expenses page
      When and expense is rejected
      Then the expense will be rejected


    #Todo: search for names, amounts, categories? not sure on all of the fields to search on
    @MQA-6463 @MQA-4817
    Scenario: Approve Expenses Search field
      Given a "BISHOP" logs in and is on the Expenses page
      When an expense is searched
      Then the expense will be displayed


      #    Add Button
    #same as payment requests?
    Scenario: Add an expense?

    #Summary tab
    #probably add a search to summary check
    @MQA-6464 @MQA-4817
    Scenario: Expenses Summary tab check expense
      Given  a "BISHOP" logs in and is on the Summary page
      When an expense is selected
      Then the expense information will be correct

    Scenario: Advanced Payment
    Scenario: Utah Unit - state tax?
    Scenario: Paroisse de Gex




    #Rejected tab
    #todo need api test to populate the rejected list
    @MQA-6465 @MQA-4817
    Scenario: Check the items in the Rejected list
      Given  a "BISHOP" logs in and is on the Rejected page
      Then the rejected expenses will be listed

    @MQA-6466 @MQA-4817
    Scenario: Select a rejected item and verify the information
      Given  a "BISHOP" logs in and is on the Rejected page
      When an expense is selected
      Then the expense information will be correct with a Rejection reason

    @MQA-6467 @MQA-4817
    Scenario: Delete rejected expense
      Given  a "BISHOP" logs in and is on the Rejected page
      When an expense is selected
      And the expense is deleted
      Then the rejected expense will be deleted


    @MQA-6468 @MQA-4817
    Scenario Outline: Expenses add new payee
      Given a "BISHOP" logs in and is on the Expenses page
      When a payee is added with <payeeName> <mobilePhone> <homePhone> <email> <country> <address1> <address2> <city> <state> <countyOrDistrict> <postalCode>
      Then the payee will be created with <payeeName> <mobilePhone> <homePhone> <email> <country> <address1> <address2> <city> <state> <countyOrDistrict> <postalCode>
      Examples:
        | payeeName   | mobilePhone  | homePhone | email           | country         | address1       | address2 | city          | state  | countyOrDistrict | postalCode |
        | "Test User" | "8018675309" | ""        | "test@test.com" | "United States" | "8871 S 500 W" | ""       | "West Jordan" | "Utah" | ""               | "84084"    |




#      Scenario: link user test
