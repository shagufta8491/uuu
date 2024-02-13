@ui 
Feature: Test google search is working

@NaviagteToURL
Scenario: Validate automation exercise page
Given User navigate to url

@subscriptionInHomePage
Scenario: User is able to open the browser, navigate to the url and verify subsciption in home page
Given User Scroll down to footer of the page
When  After scrooling down user is able to see "SUBSCRIPTION" keyword 
And  User enter email address "shagufta.princess@gmail.com" in input 
And  User click on arrow button
Then User Verify success message "You have been successfully subscribed!" is visible
