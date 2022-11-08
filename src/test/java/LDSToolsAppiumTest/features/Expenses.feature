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
    @jft
    Scenario Outline: Expenses to Review to Approve Expenses
      Given a <leader> logs in and is on the Expenses page
      When an <expensePayee> with the <expenseAmount> is Reviewed with the <paymentType>
      Then the expense with <expensePayee>, <expenseAmount> and <paymentType> will be under Expenses to Approve
      And the user logs out
      When a <differentLeader> logs in and is on the Expenses page
      And the <expensePayee> with the <expenseAmount> is Approved with the <paymentType>
      Then the expense will be approved
      Examples:
        | leader   | expensePayee             | expenseAmount | paymentType | differentLeader |
        | "BISHOP" | "Stelter, Sharon Siniva" | "$53.99"      | "Check"     | "WARD_CLERK"    |


    #for automation hard code one of the created expenses? or search for expense?
    #Just change the category do not submit?
    Scenario: Approve Expenses change the category
      Given a "BISHOP" logs in and is on the Expenses page
      When a category is changed
      Then the category will be changed

      #add a category and do not submit
    #Todo: add several categoires and submit
    Scenario: Approve Expenses add categories
      Given a "BISHOP" logs in and is on the Expenses page
      When a category is added
      Then the category will be added to the expense

      #delete and add categories or just delete to see what happens?
    Scenario: Approve Expenses delete all categories
      Given a "BISHOP" logs in and is on the Expenses page
      When all categories are deleted
      Then some error - waring?

      #May not be able to automate
    Scenario: Approve Expenses view receipt
      Given a "BISHOP" logs in and is on the Expenses page
      When the receipt button is selected
      Then the receipt will be displayed

    Scenario: Approve Expenses add attachment
      Given a "BISHOP" logs in and is on the Expenses page
      When an attachment is added
      Then the attachment is added to the expense

    Scenario: Approve Expenses Reject Expenses
      Given a "BISHOP" logs in and is on the Expenses page
      When and expense is rejected
      Then the expense will be rejected


    #Todo: search for names, amounts, categories? not sure on all of the fields to search on
    Scenario: Approve Expenses Search field
      Given a "BISHOP" logs in and is on the Expenses page
      When an expense is searched
      Then the expense will be displayed


      #    Add Button
    #same as payment requests?
    Scenario: Add an expense?

    #Summary tab
    #probably add a search to summary check
    Scenario: Expenses Summary tab check expense
      Given  a "BISHOP" logs in and is on the Summary page
      When an expense is selected
      Then the expense information will be correct



    #Rejected tab
    #need api test?
    Scenario: Check the items in the Rejected list
    Scenario: Select a rejected item and verify the information




    #Make this a Scenario Outline: with all of the different fields - name, mobile phone, home phone etc... ?
    Scenario: Expenses add a payee
      Given a "BISHOP" logs in and is on the Expenses page
      When a payee is added
      Then the payee will be created

      # Create an out of unit payee?
      # Add a payment request for an out of unit member?
    Scenario: Add an out of unit payee
      Given a "BISHOP" logs in and is on the Expenses page



#      Scenario: link user test
