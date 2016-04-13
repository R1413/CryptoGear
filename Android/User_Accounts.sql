CREATE TABLE User_Accounts(
First_Name VARCHAR(30) DEFAULT "",
Last_Name VARCHAR(30) DEFAULT "",
UserName VARCHAR(255) NOT NULL,
Password VARCHAR(255) NOT NULL,
Email VARCHAR(60) NOT NULL,
City VARCHAR(40) DEFAULT "",
Country CHAR(40) DEFAULT "",
User_ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Games_Won INT(40) NOT NULL DEFAULT 0,
Games_Lost INT(40) NOT NULL DEFAULT 0,
Experience INT(40) NOT NULL DEFAULT 0,
Reliability INT(40) DEFAULT 50);

INSERT INTO User_Accounts VALUE (DEFAULT, DEFAULT, 'anhkhoa', '1234', 'anhkhoa.than@colorado.edu', 'Denver', 'USA', NULL, '0', '0', '0', DEFAULT);
INSERT INTO User_Accounts VALUE (DEFAULT, DEFAULT, 'raymond', '1234', 'raymond.duncan@colorado.edu', 'Boulder', 'USA', NULL, '0', '0', '0', DEFAULT);
INSERT INTO User_Accounts VALUE (DEFAULT, DEFAULT, 'joca', '1234', 'jose.canizares@colorado.edu', 'Boulder', 'USA', NULL, '0', '0', '0', DEFAULT);
INSERT INTO User_Accounts VALUE (DEFAULT, DEFAULT, 'sayed', '1234', 'sayed.sarders@colorado.edu', 'Littleton', 'USA', NULL, '0', '0', '0', DEFAULT);

CREATE TABLE Game_Messages(
Ciphertext VARCHAR(140) NOT NULL,
Plaintext VARCHAR(140) NOT NULL,
Message_ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Sender VARCHAR(60) NOT NULL,
Recipient VARCHAR(60) NOT NULL,
Viewed BOOLEAN NOT NULL DEFAULT 0,
Completed BOOLEAN NOT NULL DEFAULT 0);


INSERT INTO Game_Messages VALUE ("This is my encrypted message for Crypto, not Twitter.", "This is my encrypted message for Crypto, not Twitter.", NULL, 'jose.canizares@colorado.edu', 'raymond.duncan@colorado.edu', DEFAULT, DEFAULT);



CREATE TABLE Friend_Table(
Friend_ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Requester VARCHAR(60) NOT NULL,
Receiver VARCHAR(60) NOT NULL,
isFriend BOOLEAN NOT NULL DEFAULT 0);


INSERT INTO Friend_Table VALUE (DEFAULT, 'jose.canizares@colorado.edu', 'radu5022@colorado.edu', DEFAULT);
