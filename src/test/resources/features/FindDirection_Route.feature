#Author: your.email@your.domain.com
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
@FindBestDirection
Feature: Validate the details while finding the routes
  Use this test case to validate the coordinates of the location,
  then validate the results shown while finding the routes. 

  @ValidateLocation&Routes
  Scenario: Validate Search & Find Route functionality
  	Given I am on the Home page of Google Map website
    When I search location
    And I click on Search button
    Then I should get correct co-ordinates
    And I click on Direction button
  	And I click on icon
  	|Icon	|
  	|Car 	|
  	And I enter starting point
  	And I enter destination location
  	And I click on DirectionSearch button
  	Then I should see list of routes
    And Print the route details in a .txt file
    

