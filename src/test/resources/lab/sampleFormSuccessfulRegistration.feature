Feature: SampleForm successful registration

  Scenario: Enter Registration Data Successfully
	Given I am on registration page

	When I enter the first name "Edith"
	Then "Edith" is displayed in first name input field

	When I enter the last name "Sarau"
	Then "Sarau" is displayed in last name input field

	When I enter birthday "01/12/2000"
	Then "01/12/2000" is displayed in birthday input field

	When I select "Female" as gender
	Then "Female" is selected as gender

	When I select "Universität Wien „Alma Mater Rudolphina“" as university
	Then "Universität Wien „Alma Mater Rudolphina“" is selected as university

	When I select student
	Then student is selected

	When I click sign up
	Then the confirmation page is shown
