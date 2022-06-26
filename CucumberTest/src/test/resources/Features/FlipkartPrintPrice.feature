Feature: 

  @xyz
  Scenario: Compose and send the mail through an exsiting gmail account
    Given user visits gmail login page
    And user logins with valid username and valid password
    When user composes an email with subject and some body text
    Then the email appears in the sent folder of gmail
