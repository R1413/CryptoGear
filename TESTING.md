####Who:
José Cañizares, Anh-Khoa Than, Sayed Sarder, Raymond Duncan <br>
####Title:
Crypto <br>
####Vision:
To help more people understand how encryption works. <br>
####Automated Tests:
<br>
####User Acceptance Tests:
Use Case ID: UC-01<br>
Use Case Name: Email regex test<br>
Description: The user is met with a login screen. They should enter an email and password<br>

Users: Website Users <br>
Pre-conditions: User on login screen<br>
Post-Conditions: User on index screen (temporarily)<br>
Frequency of Use: Anytime a user wants to log into the website<br>

Flow of Events<br>

	Actor Actions
		1) User navigates to the login webpage 
		2) The user enters a username and password
		3) User then submits the request by clicking the login button

	System Responses
		1)
		2)
		3) If the system checks for a valid email before testing it against values in the database

	Comments
		1)
		2)
		3)

Test Pass? Y/N : Y<br>
Notes and Issues:<br>



Use Case ID: UC-02<br>
Use Case Name: Username and password matching<br>
Description: The when the user enters a username and password into the login screen, it checks whether the user already exists<br>

Users: Website Users<br>
Pre-conditions: User on the login screen<br>
Post-Conditions: User logged in and on the profile page<br>
Frequency of Use: Anytime the user logs in<br>

Flow of Events<br>

	Actor Actions
		1) User navigates to the login webpage 
		2) The user enters a username and password
		3) User then submits the request by clicking the login button
		4) The system checks the validity of the username

	System Responses
		1)
		2)
		3) 
		4) Upon receiving the username and password, if the username is valid, it queries the database and checks for a match. If one exists, it'll redirect the user to their profile page

	Comments
		1)
		2)
		3)
		4) Currently the database is not running. For now, to simulate it a username password combo is hard coded

Test Pass? Y/N : Y<br>
Notes and Issues:<br>
Sample hard coded username and password (sample@colorado.edu , samplePassword )
<br>

Use Case ID: UC-03<br>
Use Case Name: Password Retrieval<br>
Description: When the user forgets their password, the automated system sends the password back to them<br>

Users: Website Users<br>
Pre-conditions: User on the login screen<br>
Post-Conditions: User logged in and on the profile page<br>
Frequency of Use: Anytime the user forgets password when logging in<br>

Flow of Events<br>

	Actor Actions
		1) User navigates to the login webpage 
		2) The user enters a username and password
		3) System returns invalid message and prompts the user if they want their password to be sent to them
		4) User answers security question, and the system looks through the database and checks for correct answer
		5) If the answer given by user is matched, system sends password

	System Responses
		1)
		2)
		3) Returns invalid
		4) System query database
		5) System sends passsword

	Comments
		1)
		2)
		3)
		4) For now, system asks for email
		5) Method for sending password not yet decided

Test Pass? Y/N : N/A<br>
Notes and Issues:<br>
Not yet tested, will be in the near future
<br>
