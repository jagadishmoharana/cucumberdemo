Feature: Login
Scenario: Login with valid credentials
Given I launch browser and navigate to the login page
When I enter valid username "Admin" into username field
And I enter valid password "admin123" into password field
And I click on login button
Then i successfully login

Scenario: Login with invalid credentials
Given I launch browser and navigate to the login page
When I enter invalid username "Jagadish" into username field
And I enter invalid password "jagadish13" into password field
And I click on login  button to login
Then i should not be successfully login and get an error

Scenario: check Pim page is working or not
Given I launch browser and navigate to the login page
When I enter valid username "Admin" into username field
And I enter valid password "admin123" into password field
And I click on login button
And I click on pim
Then check url contains pim