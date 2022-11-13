Feature: SampleForm validation errors

  Background:
	Given I am on registration page

  Scenario Outline: firstName and lastName validation errors
	When I enter the first name "<firstName>"
	When I enter the last name "<lastName>"
	When I enter birthday "<date>"
	When I select "<gender>" as gender
	When I select "<university>" as university
	When I select student
	When I click sign up

	Then throws error

	Examples:
	| firstName					| lastName						| date			| gender		| university												|
	| 							| sarau							| 01/12/2000	| Female		| Universität Wien „Alma Mater Rudolphina“ 					|
	| 123						| sarau							| 01/12/2000	| Female		| Universität Wien „Alma Mater Rudolphina“ 					|
	| `!%&[						| sarau							| 01/12/2000	| Female		| Universität Wien „Alma Mater Rudolphina“ 					|
	| edith						| 								| 01/12/2000	| Female		| Universität Wien „Alma Mater Rudolphina“ 					|
	| edith						| 123							| 01/12/2000	| Female		| Universität Wien „Alma Mater Rudolphina“ 					|
	| edith						| `!%&[							| 01/12/2000	| Female		| Universität Wien „Alma Mater Rudolphina“ 					|
	| zzzzzzzzzzzzzzzzzzzzz		| sarau							| 01/12/2000	| Female		| Alpen-Adria Universität Klagenfurt	 					|

	Scenario Outline: Gender is not set
	  When I enter the first name "<firstName>"
	  When I enter the last name "<lastName>"
	  When I enter birthday "<date>"
	  When I select "<university>" as university
	  When I select student
	  When I click sign up

	  Then throws error

	  Examples:
		| firstName		| lastName		| date			| university								|
		| edith			| sarau			| 01/12/2000	| Universität Wien „Alma Mater Rudolphina“ 	|

  Scenario Outline: university not set
	When I enter the first name "<firstName>"
	When I enter the last name "<lastName>"
	When I enter birthday "<date>"
	When I select "<gender>" as gender
	When I select student
	When I click sign up

	Then throws error

	Examples:
	  | firstName		| lastName		| date			| gender		|
	  | edith			| sarau			| 01/12/2000	| Female		|

  Scenario Outline: date not set
	When I enter the first name "<firstName>"
	When I enter the last name "<lastName>"
	When I select "<gender>" as gender
	When I select "<university>" as university
	When I select student
	When I click sign up

	Then throws error

	Examples:
	  | firstName		| lastName			| gender		| university								|
	  | edith			| sarau				| Female		| Universität Wien „Alma Mater Rudolphina“ 	|

  Scenario Outline: person is too young (typed)
	When I enter the first name "<firstName>"
	When I enter the last name "<lastName>"
	When I select "<gender>" as gender
	When I type birthday "<date>"
	When I select "<university>" as university
	When I select student
	When I click sign up

	Then throws error

	Examples:
	  | firstName			| lastName		| date			| gender		| university								|
	  | edith				| sarau			| 13/11/2022	| Female		| Universität Wien „Alma Mater Rudolphina“ 	|


