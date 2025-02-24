
@tag
Feature: Admin Login
  I want to use this template to validate Admin Login

  @tag1
  Scenario: Check Admin Login with valid inputs
    Given i open browser with the url "http://orangehrm.qedgetech.com"
    Then i should see login page 
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    When i click logout
    When i close browser
    
    @tag2
    Scenario Outline: Check Admin Login with invalid inputs
      Given i open browser with the url "http://orangehrm.qedgetech.com"
      Then i should see login page 
      When i enter username as "abc"
      And i enter password as "xyz"
      And i click login
      Then i should see error message
      When i close browser
      
    Examples:
    
    |username||password|
     |Admin||xyz|
     |xyz||Qedge123|
      |xyz||Qedge123|
    
    
  
 
      