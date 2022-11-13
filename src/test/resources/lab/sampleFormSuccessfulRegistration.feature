Feature: SampleForm successful registration

  Scenario Outline: Enter Registration Data is shown correctly and after successful validation forwards correctly
	Given I am on registration page

	When I enter the first name "<firstName>"
	Then "<firstName>" is displayed in first name input field

	When I enter the last name "<lastName>"
	Then "<lastName>" is displayed in last name input field

	When I enter birthday "<date>"
	Then "<date>" is displayed in birthday input field

	When I select "<gender>" as gender
	Then "<gender>" is selected as gender

	When I select "<university>" as university
	Then "<university>" is selected as university

	When I select student
	Then student is selected

	When I click sign up
	Then the confirmation page is shown

	Examples:
	  | firstName					| lastName						| date			| gender		| university								|
	  | edith						| sarau							| 01/12/2000	| Female		| Technische Universität Wien			 	|
	  | edith						| sarau							| 01/12/2000	| Female		| Alpen-Adria Universität Klagenfurt	 	|
	  | zzzzzzzzzzzzzzzzzzz			| sarau							| 01/12/2000	| Female		| Alpen-Adria Universität Klagenfurt	 	|
	  | zzzzzzzzzzzzzzzzzzzz		| sarau							| 01/12/2000	| Female		| Alpen-Adria Universität Klagenfurt	 	|
	  | edith						| zzzzzzzzzzzzzzzzzzz			| 01/12/2000	| Female		| Alpen-Adria Universität Klagenfurt	 	|
	  | edith						| zzzzzzzzzzzzzzzzzzzz			| 01/12/2000	| Female		| Alpen-Adria Universität Klagenfurt	 	|
