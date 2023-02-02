@OktaLogin
  Feature: Test Login with Okta

    @MQA-6790 @MQA-2214 @all @all4 @daily @daily4 @smoke @smoke4 @jft
    Scenario: Validate login page elements
      When a user opens the app
      Then the elements will be displayed

      #Bug in Android - links are not loading
    @MQA-6791 @MQA-2214 @all @all3 @daily @daily3 @smoke @smoke3
    Scenario: Validate login page links
      When a user opens the app
      Then the links will be valid


    @MQA-6792 @MQA-2214 @all @all2 @daily @daily2
    Scenario Outline: Invalid password <invalidPassword>
      Given a user opens the app
      When user name <userName> is entered
      And a password <invalidPassword> is entered
      Then an invalid password error will be displayed
      Examples:
        | userName       | invalidPassword                                                                                                                                |
        | "cowkids"      | "<login>"                                                                                                                                      |
        | "emhf"         | "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"                                                                             |
        | "btmomm2"      | "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"                                                                      |
        | "HanselS"      | "/password/"                                                                                                                                   |
        | "hmd7715"      | "!@#$%%^&**())__+_!@@!#!$%#@%^*&%&*(^*()(&(&*(%^&$#%@$!#$%$#^#$%^^&*(^%}@#$@%$@#%$#@%#@%#@$%#@%@#^#%^$^%$^#$##$%@#$%#%$$#^#$^**^&^**(*((^%*&*" |
        | "erf1779"      | "select * from directory"                                                                                                                      |
        | "bishopfawson" | " toolstester"                                                                                                                                 |

    @MQA-6793 @MQA-2214 @all @all1 @daily @daily1
    Scenario Outline: Invalid username <invalidUserName> and password <invalidPassword>
      Given a user opens the app
      When user name <invalidUserName> is entered
      And a password <invalidPassword> is entered
      Then an invalid password error will be displayed
      Examples:
        | invalidUserName                                | invalidPassword                         |
        | "sfjksdjissldjskldjslfjslfj"                   | "toolste@#@$#^#$&%*%*&ster"             |
        | "HanSolo"                                      | "<><><><><><><><><>"                    |
        | "This is a bad username test"                  | "This is a bad password test"           |
        | "select * from directory"                      | "^^^^^^^^^^^^"                          |
        | "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" | "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"       |
        | "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" | "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" |

    @MQA-6794 @MQA-2214 @all @all4 @daily @daily4
    Scenario Outline: Invalid 2 factor login
      Given a user opens the app
      When a valid username and password are entered
      And an <invalidTwoFactor> is entered
      Then an invalid two factor error will be displayed
      Examples:
        | invalidTwoFactor |
        | "123456"         |
