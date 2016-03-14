CREATE TABLE User_Accounts(
First_Name VARCHAR(30) NOT NULL,
Last_Name VARCHAR(30) NOT NULL,
Login VARCHAR(255),
Password VARCHAR(255),
Email VARCHAR(60) NOT NULL PRIMARY KEY,
City VARCHAR(40) NOT NULL,
State CHAR(40) NOT NULL,
User_ID INT UNSIGNED,
Games_Won INT(11) NOT NULL,
Games_Lost INT(11) NOT NULL,
Experience INT(11) NOT NULL,
Reliability INT(11) NOT NULL);

INSERT INTO User_Accounts VALUE ('Anh-Khoa', 'Than', NULL, NULL, 'anhkhoa.than@colorado.edu', 'Denver', 'Colorado', NULL, '100', '3', '100', '1000');
INSERT INTO User_Accounts VALUE ('Raymond', 'Duncan', NULL, NULL, 'BossRay@colorado.edu', 'Boulder', 'Colorado', NULL, '1000', '0', '10000', '10000');
INSERT INTO User_Accounts VALUE ('Jose', 'Canizares', NULL, NULL, 'JoseTheHardWorker@colorado.edu', 'Boulder', 'Colorado', NULL, '100', '10', '500', '5000');
INSERT INTO User_Accounts VALUE ('Sayed', 'Sarders', NULL, NULL, 'SayedThePlayer@colorado.edu', 'Littleton', 'Colorado', NULL, '100', '3', '10000000', '600000');



