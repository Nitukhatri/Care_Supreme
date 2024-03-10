
Feature: Mobile number verification

@Regression
Scenario Outline:  Invalid Mobile number scenerio
	Given user launch chrome browser
  When User opens URL "https://www.careinsurance.com/product/care-supreme" 
  And User enters Mobile number as "<Mobile Number>" 
  And Click on Calculate premium 
  Then Error Message should be "Please enter a valid mobile number" 
  And close browser

Examples:
 |Mobile Number |
 |00000					|
 |11111					|
 |22222					|
 |33333					|
 |44444					|
 |55555					|
 
@Sanity
Scenario:  Valid Mobile number scenerio
	Given user launch chrome browser
  When User opens URL "https://www.careinsurance.com/product/care-supreme" 
  And User enters Mobile number as "9988776655" 
  And Click on Calculate premium 
  Then Section title should be "Select Family members" 
  And close browser
  
  