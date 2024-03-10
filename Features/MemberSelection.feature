Feature: Member Selection

Background: Steps common for All Scenarios
    Given user launch chrome browser
    When User opens URL "https://www.careinsurance.com/product/care-supreme"
    And User enters Mobile number as "9988776655"
    And Click on Calculate premium
    Then Section title should be "Select Family members"
 
@Sanity 
Scenario: Four Member Positive Scenario 
 	When Select member one as "spouse" member two as "son" member three as "daughter"
	And Click on continue button 
	Then Age Section title should be "Select the age of each family member"

@Regression
Scenario Outline: Not allowed Relationship combinations

#Given Section title should be "Select Family members"
	When Select member one "<Member>" 
	And Select member two "<MemberRelationship>"
	And Click on continue button 
	Then Combination Error message should be "Relationship combination not allowed"
	And close browser

Examples: 
	|Member |MemberRelationship|
	|self		|father						 |
	|self		|mother						 |
	|self		|father-in-law		 |
	|self		|mother-in-law		 |
	|spouse	|father						 |
	|spouse	|mother						 |
	|spouse	|father-in-law		 |
	|spouse	|mother-in-law		 |
	|father	|father-in-law		 |
	|father	|mother-in-law		 |
	|mother	|father-in-law		 |
	|mother	|mother-in-law		 |

@Regression
Scenario Outline: Allowed Relationship combinations

#Given Section title should be "Select Family members"
	When Select member one "<Member>" 
	And Select member two "<MemberRelationship>"
	And Click on continue button 
	Then Age Section title should be "Select the age of each family member"
	And close browser

Examples: 
	|Member		 			|MemberRelationship |
	|self			 			|spouse							|
	|mother		 			|father							|
	|father-in-law	|mother-in-law			|



