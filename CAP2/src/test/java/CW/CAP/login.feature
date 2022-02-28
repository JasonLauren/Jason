Feature: login scenario

Scenario Outline: login
Given open chrome
When user enters in loginpage
Then enters "<uname>" and "<pwd>"
Then User click on conatacts tab
Then select new contact button
Then enters user details
|fname  |lname |  email|
|krishna6|Madasu6|madasurishna22@gmail.com6| 
|krishna7|Madasu7|madasurishna22@gmail.com7| 
|krishna8|Madasu8|madasurishna22@gmail.com8| 
|krishna9|Madasu9|madasurishna22@gmail.com9| 

Then logout FreeCRM
Examples:
|		uname      		|		pwd		|
|madasurishna22@gmail.com|Jason/2079|
