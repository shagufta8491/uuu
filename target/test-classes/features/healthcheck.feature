@ui 
Feature: Test google search is working

@ValidatingHomepage
Scenario: Homepage validation
Given user navigate to the home application url
Then on homepage list of buttons are displayed
| Home           |
| Products       |
| Cart           |
| Signup / Login |
| Test Cases     |
| API Testing    |
| Video Tutorials|
| Contact is     |

@SubscribtionToHomePage
Scenario: Validate automation exercise page
Given User navigate to url
And  User enter email address "shagufta.princess@gmail.com" in input 
And  User click on arrow button
Then User Verify success message "You have been successfully subscribed!" is visible


@Errormsgforinvalidlogin
Scenario Outline: User login with three diffrent not registered emailid and password
Given  User navigate to url
Then user click on signup/login button
When user enter email  "<EmailId>" and "<password>"
And user click on login button
Examples:
| EmailId                         |  password |
| shaguftashaikh@gmail.com        |  shaikh123       |
| shaguftashaikh123@gmail.com     | shagufta123      |
| shagufta8491@gmail.com          |  sshaikh12       | 



@LoginWithValidCredential
Scenario Outline: User login with two different valid emailId and password
Given User navigate to url
And  User click on signup/logiin button
And   User enter valid "<ValidEmailId>" and "<Validpassword>" for logiin
And   User click on logiin button
Then  User verify with "<username>" just after Logged in as button 
Examples:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
| ValidEmailId            | Validpassword | username      |
|  ciwika1748@frandin.com | 23456.Abc    | Ryan Wick     |
|  ciwika1744@frandin.com | 123456.Abc    | James Richard |