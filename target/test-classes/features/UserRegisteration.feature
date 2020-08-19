Feature: User Registration
  Scenario Outline: Register To website
    Given user in the registration page
    When add Registeration data "<fname>", "<lname>","<email>","<pswd>"
    And  click Register
    Then User registered and logged in successfully
  
  Examples:
  |fname|lname|email|pswd|
  |mohamed|Elgamal|test@3ddx.com|123456|

  