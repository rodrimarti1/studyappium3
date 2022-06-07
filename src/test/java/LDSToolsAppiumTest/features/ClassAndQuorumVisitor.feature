@ClassAndQuorumVisitor
  Feature: Test the visitor feature for Class and Quorum


    @MQA-5699 @MQA-2225 @all @all4 @daily @daily4 @smoke @smoke4 @jft
    Scenario: Enter visitors for Class and Quorum
      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
      When "25" is entered in the "Men" in the "1" field
      And the done button is pressed
      Then "25" will be saved in the "Men" "1" field attendance

    @MQA-5700 @MQA-2225 @all @all1 @daily @daily1
    Scenario Outline: Enter in visitor counts for different callings
      Given a <leader> logs in and is on the Class and Quorum Attendance visitors page
      When <visitor> is entered in the <class> in the <weekNumber> field
      And the done button is pressed
      Then <visitor> will be saved in the <class> <weekNumber> field attendance
      Examples:
        | leader                     | visitor | class         | weekNumber |
        | "ELDERS_QUORUM_PRESIDENT"  | "3"     | "Men"         | "1"        |
        | "RELIEF_SOCIETY_PRESIDENT" | "23"    | "Women"       | "2"        |
        | "YOUNG_WOMEN_PRESIDENT"    | "8"     | "Young Women" | "3"        |
        | "RELIEF_SOCIETY_PRESIDENT" | "30"    | "Women"       | "4"        |
        | "PRIMARY_PRESIDENT"        | "1"     | "Children"    | "5"        |
        | "SUNDAY_SCHOOL_PRESIDENT"  | "17"    | "Young Women" | "3"        |

      #Todo: needs work
    Scenario: Enter visitors then cancel
      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
      When "25" is entered in the "Children" in the "1" field
      And the cancel button is pressed
      Then "0" will be saved in the "Children" "1" field attendance

    #Todo: needs work
    Scenario Outline: Visitor rights for different callings
      Given a <leader> logs in and is on the Class and Quorum Attendance visitors page
      Then the visitor <class> will be displayed
      And the visitor <noClass> will not be displayed
      Examples:
        | leader                     | class                                      | noClass                                |
        | "ELDERS_QUORUM_PRESIDENT"  | "Men"                                      | "Women,Young Women,Children,Young Men" |
        | "BISHOP"                   | "Women,Young Women,Children,Young Men,Men" | "none"                                 |
        | "RELIEF_SOCIETY_PRESIDENT" | "Women"                                    | "Men,Young Women,Children,Young Men"   |
        | "YOUNG_WOMEN_PRESIDENT"    | "Young Women"                              | "Men,Women,Children,Young Men"         |



#    No error on ios or android there is a but in on this
#    Scenario: Enter very large number in the visitors
#      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
#      When "100200300400" is entered in the "Children"
#      Then an error will be displayed


#    Scenario: Enter invalid digits into the visitor
#      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
#      When "TEST" is entered under "Children" in the "1" field
#      Then an error will be displayed