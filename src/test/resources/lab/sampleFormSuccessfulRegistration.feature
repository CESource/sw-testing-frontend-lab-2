Feature: SampleForm successful registration

  Background:
	Given I am on registration page


  Scenario Outline: Enter Registration Data Successfully
	When I enter the first name "<term>"
	Then "<term>" is displayed in input field

	Examples:
	| term			|header			|
	| Edith			| You entered	|
	| Chili			| You entered	|
