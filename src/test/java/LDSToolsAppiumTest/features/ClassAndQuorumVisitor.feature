@ClassAndQuorumVisitor
  Feature: Test the visitor feature for Class and Quorum

#    Smoke test?\
    @jft
    Scenario: Enter visitors for Class and Quorum
      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
      When "25" is entered in the "Men" in the "1" field
      Then "25" will be saved in the "Men" "1" field attendance

#      need the different classes and callings - tough to do without seeing it
    #Children Young Women Young Men Women Men
    Scenario Outline: Enter in visitor counts for different callings
      Given a <leader> logs in and is on the Class and Quorum Attendance visitors page
      When <visitor> is entered in the <class> in the <weekNumber> field
      Then <visitor> will be saved in the <class> <weekNumber> field attendance
      Examples:
        | leader                     | visitor | class   | weekNumber |
        | "ELDERS_QUORUM_PRESIDENT"  | "5"     | "Men"   | "1"        |
        | "RELIEF_SOCIETY_PRESIDENT" | "17"    | "Women" | "3"        |

    Scenario: Enter visitors then cancel
      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
      When "25" is entered in the "Children" then the cancel button is pressed
      Then the visitors "Children" will be blank

    Scenario: Enter invalid digits into the visitor
      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
      When "TEST" is entered under "Children" in the "1" field
      Then an error will be displayed

    Scenario: Enter very large number in the visitors
      Given a "BISHOP" logs in and is on the Class and Quorum Attendance visitors page
      When "100200300400" is entered in the "Children"
      Then an error will be displayed