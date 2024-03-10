Feature: Member Age Selection

Background: Steps common Scenarios
  Given user launch chrome browser
  When User opens URL "https://www.careinsurance.com/product/care-supreme"
  And User enters Mobile number as "9988776655"
  And Click on Calculate premium
  Then Section title should be "Select Family members"
	When Select member one as "spouse" member two as "son" member three as "daughter"
	And Click on continue button 
	Then Age Section title should be "Select the age of each family member"

@Sanity 
Scenario: Select Members Age

When Select self age as "40" spouse age as "35" son age as "10" and daughter age as "12"
And Click on age countinue button
Then Pincode Section title should be "Where do you live? Help us with your city pincode"
And close browser