Feature: OrangeHRM Login

Scenario: Orange HRM default login

Given User is on Login page

When User clicks on login button by entering username as "admin" and password as "admin123"

#Then Login is successful
Then Login success is "true"

#And Username is displayed
And Username display is "true"

And Close application


Scenario: Orange HRM invalid login

Given User is on Login page

When User clicks on login button by entering username as "user" and password as "user123"

#Then Login is unsuccessful
Then Login success is "false"

#And Username is not displayed
And Username display is "false"

And Close application