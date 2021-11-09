#Author: sateeshkumar.varma20@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Packt Assessment Sateesh Varma

  @tag1
  Scenario: Verify that all the elements on the page are correct
    Given I am on home page of packt application
    When I verify the elements on homepage
		Then verification should be successfull
		
	@tag1	
	Scenario: Verify that all the options from the Browse menu go to correct pages
		Given I am on home page of packt application
		And I click on "Browse" top menu
		When I select "Python" Book From "Data" category of browse menu
		Then I will be navigated to search result page of "Book" Product and "Data" category for "Python" page
		

