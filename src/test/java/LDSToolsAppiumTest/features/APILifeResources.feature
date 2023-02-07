@API
  Feature: API test for Life Resources

    @MQA-6669 @MQA-6341 @all @jft
    Scenario Outline: Check <url> status code for <member>
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member            | url                                                   | status    |
        | "BISHOP"          | "life-resources"                                      | "Success" |
        | "STAKE_PRESIDENT" | "life-resources"                                      | "Success" |
        | "BISHOP"          | "life-resources/e63ea621-c06c-48a7-b878-991c790f24f8" | "Success" |
        | "BISHOP"          | "life-resources/e63ea621-c06c-48a7-bad-code"          | "Error"   |

    @MQA-6670 @MQA-6341 @all
    Scenario Outline: Verify a Life Resource information
      When a <member> gets the life resources for the <unit>
      Then the <LRtoCheck> <phone> <email> <url> will match
      Examples:
      | member   | unit     | LRtoCheck                                                   | phone          | email                                | url                                                           |
      | "BISHOP" | "502278" | "Addiction Recovery Program"                                | ""             | ""                                   | "https://addictionrecovery.churchofjesuschrist.org/?lang=eng" |
      | "BISHOP" | "502278" | "Houston TX Welfare Development Counseling Services Office" | "281-580-2564" | "HoustonDCS@ChurchofJesusChrist.org" | ""                                                            |

    @MQA-6671 @MQA-6341 @all
    Scenario Outline: Create a new Life Resource
      Given a <StakeLeadership> creates a <lifeResource> in the <unit>
      Then the <lifeResource> will be correct
      And the <lifeResource> is deleted
      Then the <lifeResource> will be deleted
      Examples:
      | StakeLeadership   | lifeResource      | unit    |
      | "STAKE_PRESIDENT" | "lifeResourceOne" | "502278"|

    @MQA-6672 @MQA-6341 @all
    Scenario: Create edit and delete Life Resource
      When a "STAKE_PRESIDENT" creates a "lifeResourceTwo" in the "502278"
      Then the "lifeResourceTwo" will be correct
      And the "lifeResourceTwo" is edited
      Then the "editedLifeResource" will be correct
      And the "editedLifeResource" is deleted
      Then the "lifeResourceTwo" will be deleted
      And the "editedLifeResource" will be deleted


