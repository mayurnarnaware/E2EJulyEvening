Feature: QA Click Login

Scenario Outline: QA Click login DDT Test

Given Launch QA Click application
And Click on Login to land on sign in page

When User tries to login with username as <username> and password as <password>

Then login is unsuccessful
And Close browser
Examples:
|username	|password	|
|a@b.com	|11111		|
|c@d.com	|12222		|
|g@h.com	|13333		|
|i@j.com	|14444		|