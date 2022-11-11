Feature: Login Module API Automation

  Scenario: Verify User login to the application through API and get logtoken
    Given User should add header
    When User should add basic authentication for login
    And User should send "POST" request to login endpoint
    Then User should verify the status code is 200
    And User should verify the login response body firstName present as "Mani" and get the logtoken saved
