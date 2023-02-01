@OktaLogin
  Feature: Test Login with Okta


    Scenario: Validate login page elements
      When a user opens the app
      Then the elements will be displayed

    @jft
    Scenario: Validate login page links
      When a user opens the app
      Then the links will be valid

    Scenario Outline: Invalid password
      Given a user opens the app
      When a <userName> is entered
      And a <invalidPassword> is entered
      Then an error will be displayed
      Examples:
        | userName    | invalidPassword                                                                                                                                |
        | "zmaxfield" | "<login>"                                                                                                                                      |
        | "zmaxfield" | "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"                                                                             |
        | "zmaxfield" | "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"                                                                      |
        | "zmaxfield" | "/password/"                                                                                                                                   |
        | "zmaxfield" | "!@#$%%^&**())__+_!@@!#!$%#@%^*&%&*(^*()(&(&*(%^&$#%@$!#$%$#^#$%^^&*(^%}@#$@%$@#%$#@%#@%#@$%#@%@#^#%^$^%$^#$##$%@#$%#%$$#^#$^**^&^**(*((^%*&*" |
        | "zmaxfield" | "select * from directory"                                                                                                                      |
        | "zmaxfield" | " toolstester"                                                                                                                                 |

    Scenario Outline: Invalid username and password
      Given a user opens the app
      When a <invalidUserName> is entered
      And a <invalidPassword> is entered
      Then an error will be displayed
      Examples:
        | invalidUserName                                | invalidPassword                         |
        | "sfjksdjissldjskldjslfjslfj"                   | "toolste@#@$#^#$&%*%*&ster"             |
        | "HanSolo"                                      | "<><><><><><><><><>"                    |
        | "This is a bad username test"                  | "This is a bad password test"           |
        | "select * from directory"                      | "^^^^^^^^^^^^"                          |
        | "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" | "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"       |
        | "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" | "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" |

    Scenario Outline: Invalid 2 factor login
      Given a user opens the app
      When a valid username and password are entered
      And an <invalidTwoFactor> is entered
      Then an error will be displayed
      Examples:
        | invalidTwoFactor |
        | "123456"         |
