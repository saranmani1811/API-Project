Feature: UpdateProfilePicture Module API Automation

  Scenario: Verify update profile picture in the application through API
    Given User should add headers including multipart-form_data
    When User should pass form-data
    And User should send "POST" request to UpdateProfilePic endpoint
    Then User should verify the status code is 200
    And User should verify the updateProfilePic response body message matches "Profile updated Successfully"
