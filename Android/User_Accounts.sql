CREATE TABLE User_Accounts(
First_Name VARCHAR(30) DEFAULT "",
Last_Name VARCHAR(30) DEFAULT "",
Username VARCHAR(255) NOT NULL,
Password VARCHAR(255) NOT NULL,
Email VARCHAR(60) NOT NULL,
City VARCHAR(40) DEFAULT "",
Country CHAR(40) DEFAULT "",
User_ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Games_Won INT(40) NOT NULL DEFAULT 0,
Games_Lost INT(40) NOT NULL DEFAULT 0,
Experience INT(40) NOT NULL DEFAULT 0,
Reliability INT(40) DEFAULT 50,
BG_Color VARCHAR(6) NOT NULL DEFAULT "FFFFFF");

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
INSERT INTO Game_Messages VALUE ("Lxc't pj cj cyx kxf!", "Let's go to the rec!", NULL, 'test@gmail.com', 'pujantandukar.2015@gmail.com', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("Lxc't pj cj cyx kxf!", "Let's go to the rec!", NULL, 'anth1748@colorado.edu', 'pujantandukar.2015@gmail.com', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'anth1748@colorado.edu', 'pujantandukar.2015@gmail.com', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'sayed.sarders@colorado.edu', 'pujantandukar.2015@gmail.com', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'pujantandukar.2015@gmail.com', 'jose.canizares@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'pujantandukar.2015@gmail.com', 'sayed.sarders@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'anth1748@colorado.edu', 'sayed.sarders@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'radu5022@colorado.edu', 'sayed.sarders@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'radu5022@colorado.edu', 'anth1748@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'jose.canizares@colorado.edu', 'anth1748@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'sayed.sarders@colorado.edu', 'anth1748@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'pujantandukar.2015@gmail.com', 'anth1748@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'radu5022@colorado.edu', 'jose.canizares@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'anth1748@colorado.edu', 'jose.canizares@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'sayed.sarders@colorado.edu', 'jose.canizares@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'anth1748@colorado.edu', 'radu5022@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'sayed.sarders@colorado.edu', 'radu5022@colorado.edu', DEFAULT, DEFAULT);
INSERT INTO Game_Messages VALUE ("aolyl pz h mpul spul iladllu aol ubtlyhavy huk aol kluvtpuhavy", "there is a fine line between the numerator and the denominator", NULL, 'jose.canizares@colorado.edu', 'radu5022@colorado.edu', DEFAULT, DEFAULT);


CREATE TABLE Friend_Table(
Friend_ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Requester VARCHAR(60) NOT NULL,
Receiver VARCHAR(60) NOT NULL,
isFriend BOOLEAN NOT NULL DEFAULT 0);

INSERT INTO Friend_Table VALUE (DEFAULT, 'anth1748@colorado.edu', 'jose.canizares@colorado.edu', DEFAULT);

INSERT INTO Friend_Table VALUE (DEFAULT, 'test@gmail.com', 'radu5022@colorado.edu', DEFAULT);
INSERT INTO Friend_Table VALUE (DEFAULT, 'anth1748@colorado.edu', 'radu5022@colorado.edu', DEFAULT);
ALTER TABLE User_Accounts ADD BG_Color VARCHAR(60) NOT NULL DEFAULT "FFFFFF";
UPDATE User_Accounts SET BG_Color = '936C6C' WHERE (Email = 'jose.canizares@colorado.edu' OR Username = 'jose.canizares@colorado.edu');
