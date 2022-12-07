@API
  Feature: API test for Life Resources

    @jft
    Scenario Outline: Check <url> status code for <member>
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member            | url                                                   | status    |
        | "BISHOP"          | "life-resources"                                      | "Success" |
        | "STAKE_PRESIDENT" | "life-resources"                                      | "Success" |
        | "BISHOP"          | "life-resources/e63ea621-c06c-48a7-b878-991c790f24f8" | "Success" |
        | "BISHOP"          | "life-resources/e63ea621-c06c-48a7-bad-code"          | "Error"   |

    @jft
    Scenario Outline: Verify a Life Resource information
      When a <member> gets the life resources for the <unit>
      Then the <LRtoCheck> <phone> <email> <url> will match
      Examples:
      | member   | unit     | LRtoCheck                                                   | phone          | email                                | url                                                           |
      | "BISHOP" | "502278" | "Addiction Recovery Program"                                | ""             | ""                                   | "https://addictionrecovery.churchofjesuschrist.org/?lang=eng" |
      | "BISHOP" | "502278" | "Houston TX Welfare Development Counseling Services Office" | "281-580-2564" | "HoustonDCS@ChurchofJesusChrist.org" | ""                                                            |

    Scenario Outline: Create a new Life Resource
      Given a <StakeLeadership> creates a <lifeResource>
      Then the <lifeResource> will be correct
      And the <lifeResource> is deleted
      Then the <lifeResource> will be deleted
      Examples:
      | StakeLeadership   | lifeResource      |
      | "STAKE_PRESIDENT" | "lifeResourceOne" |

    Scenario: Create edit and delete Life Resource
      When a <StakeLeadership> creates a <lifeResource>
      Then the <lifeResource> will be correct
      And the <lifeResource> is edited
      Then the <editedLifeResource> will be correct
      And the <editedLifeResource> is deleted
      Then the <lifeResource> will be deleted
      And the <editedLifeResource> will be deleted


