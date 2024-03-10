Feature: Total Coverage (SI) Selection

Background: Scenarios Steps till now 
  Given user launch chrome browser
  When User opens URL "https://www.careinsurance.com/product/care-supreme"
  And User enters Mobile number as "9988776655"
  And Click on Calculate premium
  Then Section title should be "Select Family members"
	When Select member one as "spouse" member two as "son" member three as "daughter"
	And Click on continue button 
	Then Age Section title should be "Select the age of each family member"
	When Select self age as "40" spouse age as "35" son age as "10" and daughter age as "12"
	And Click on age countinue button
	Then Pincode Section title should be "Where do you live? Help us with your city pincode"
	When Enter pincode 
	And Enter View Quote button
	Then Buy Now page will open and title should be "Your Quote"
	
Scenario: Pincode Scenario
	When Total Coverage Slider move to select SI as "<SI>"
	Then Total Premium should update
	And close browser
	
	Examples:
	|SI |
	|7  |
	|10 |
	|15 |
	|25 |
	|50 |
	|100|