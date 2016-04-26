<?php

/*
 * Vivo Applications
 *
 * PHP for when versus.php sends a message request.
 */

include("global.php");
ensure_logged_in();
main();

/* Handles the method calling and basic computations of the php file. */
function main() {
    if (!empty($_POST["type"])) {
        $type = $_POST["type"];
        $sender = $_SESSION["name"];

        if ($type == "load_profile_info") {
            load_profile_info($sender);
        } else if ($type == "edit_firstname") {
            $new_firstname = $_POST["new_firstname"];
            edit_firstname_in_db($new_firstname, $sender);
        } else if ($type == "edit_lastname") {
            $new_lastname = $_POST["new_lastname"];
            edit_lastname_in_db($new_lastname, $sender);
        } else if ($type == "edit_username") {
            $new_username = $_POST["new_username"];
            edit_username_in_db($new_username, $sender);
        } else if ($type == "edit_city") {
            $new_city = $_POST["new_city"];
            edit_city_in_db($new_city, $sender);
        } else if ($type == "edit_country") {
            $new_country = $_POST["new_country"];
            edit_country_in_db($new_country, $sender);
        } else if ($type == "edit_color") {
            $new_color = $_POST["new_color"]; 
            change_settings($sender, $new_color);
        }
        else {
            //redirect("index", "Oops! Post information wasn't passed.");
        }
    }
}

function load_profile_info($sender) {
    $profile_info = load_profile_info_from_db($sender);
    $profile_info->execute();
//  $result = $list_of_messages->fetch(\PDO::FETCH_ASSOC);
    $result = $profile_info->fetchAll();
    foreach($result as $row) {
        print("<div" . " id=" . "profile_" . $row['User_ID'] . " class=" . "profile_info" . ">");
        print("<div id=" . "profile_" . $row['User_ID'] . "_First_Name" . ">");
        print("first name: " . $row['First_Name']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Last_Name" . ">");
        print("last name: " . $row['Last_Name']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Username" . ">");
        print("username: " . $row['Username']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Email" . ">");
        print("email: " . $row['Email']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_City" . ">");
        print("city: " . $row['City']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Country" . ">");
        print("country: " . $row['Country']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Games_Won" . " class=" . "profile_numbers" . ">");
        print($row['Games_Won']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Games_Lost" . " class=" . "profile_numbers" . ">");
        print($row['Games_Lost']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Experience" . " class=" . "profile_numbers" . ">");
        print($row['Experience']);
        print("</div>");
        print("<div id=" . "profile_" . $row['User_ID'] . "_Reliability" . " class=" . "profile_numbers" . ">");
        print($row['Reliability']);
        print("</div>");
        print("<br>");
        print("<div id=" ."hidden_" . $row['User_ID'] . " class=" . "hidden_element" . ">");
        print($row['User_ID']);
        print("</div>");
        print("</div>");      
    }
}


function load_profile_info_from_db($sender) {
    $db = makePDO();
// WHERE (Sender = {$db_sender} OR Recipient = {$db_sender});
    $db_sender = $db->quote($sender);
    $profile_info = $db->query("SELECT * FROM User_Accounts WHERE (Email = {$db_sender} OR Username = {$db_sender}) LIMIT 1;");
    return $profile_info;
}

function load_inbox($sender) {
    $inbox_messages = load_inbox_from_db($sender);
    $inbox_messages->execute();
//     $result = $list_of_messages->fetch(\PDO::FETCH_ASSOC);
    $result = $inbox_messages->fetchAll();
    foreach($result as $row) {
        print("<button type=" . "button" . " id=" . "message_" . $row['Message_ID'] . " class=" . "message_element" . ">");
        print("<div id=" . "message_" . $row['Message_ID'] . "_cipher" . ">");
        print("cipher: " . $row['Ciphertext']);
        print("</div>");
        print("<br>");
        print("sent from: " . $row['Sender'] . "<br>");
        print("<div id=" ."answer_" . $row['Message_ID'] . " class=" . "answer_element" . ">");
        print("You: " . $row['Recipient'] . "<br>");
        print("message: " . $row['Plaintext'] . "<br>");
        print("</div>");
        print("</button>");
        
    }
    
    print("<div id=" . "message_count" . ">");
    print("rowCount: " . $inbox_messages->rowCount() . "<br>");
    print("</div>");
}


function load_inbox_from_db($sender) {
    $db = makePDO();
// WHERE (Sender = {$db_sender} OR Recipient = {$db_sender});
    $db_sender = $db->quote($sender);
    $inbox_messages = $db->query("SELECT * FROM Game_Messages WHERE Recipient = {$db_sender} ORDER BY Message_ID DESC;");
    return $inbox_messages;
}

function load_messages($sender) {
    $list_of_messages = load_messages_from_db($sender);
    $list_of_messages->execute();
//     $result = $list_of_messages->fetch(\PDO::FETCH_ASSOC);
    $result = $list_of_messages->fetchAll();
    foreach($result as $row) {
        print("<button type=" . "button" . " id=" . "message_" . $row['Message_ID'] . " class=" . "message_element" . ">");
        print("<div id=" . "message_" . $row['Message_ID'] . "_cipher" . ">");
        print("cipher: " . $row['Ciphertext']);
        print("</div>");
        print("<br>");
        print("sent from: " . $row['Recipient'] . "<br>");
        print("<div id=" ."answer_" . $row['Message_ID'] . " class=" . "answer_element" . ">");
        print("You: " . $row['Sender'] . "<br>");
        print("message: " . $row['Plaintext'] . "<br>");
        print("</div>");
        print("</button>");
        
    }
    
    print("<div id=" . "message_count" . ">");
    print("rowCount: " . $list_of_messages->rowCount() . "<br>");
    print("</div>");
}

function load_messages_from_db($sender) {
    $db = makePDO();
// WHERE (Sender = {$db_sender} OR Recipient = {$db_sender});
    $db_sender = $db->quote($sender);
    $list_of_messages = $db->query("SELECT *
                        FROM Game_Messages WHERE (Sender = {$db_sender} OR Recipient = {$db_sender}) ORDER BY Message_ID DESC;");
    return $list_of_messages;
}

function load_settings($sender) {
    $loaded_settings = load_settings_from_db($sender);
    $loaded_settings->execute();
    $result = $loaded_settings->fetchAll();
    foreach($result as $row) {
        print("<button type=" . "button" . " id=" . "settings_1" . " class=" . "setting_element" . ">");
        print("<div id=" . "settings_1" . "_color" . ">");
        print($row['BG_Color']);
        print("</div>");
        print("<br>");
        print("</button>");
        
    }
    
    print("<div id=" . "message_count" . ">");
    print("rowCount: " . $loaded_settings->rowCount() . "<br>");
    print("</div>");
}

function load_settings_from_db($sender) {
    $db = makePDO();
    $db_sender = $db->quote($sender);
    $loaded_settings = $db->query("SELECT *
                        FROM User_Accounts WHERE (Email = {$db_sender} OR Username = {$db_sender});");
    return $loaded_settings;
}

function change_settings($sender, $new_color) {
    change_settings_from_db($sender, $new_color);
    load_settings($sender);
}

function change_settings_from_db($sender, $new_color) {
    $db = makePDO();
    $db_sender = $db->quote($sender);
    $db_new_color = $db->quote($new_color);
    $color = $db->query("UPDATE User_Accounts SET BG_Color = {$db_new_color} WHERE (Email = {$db_sender} OR Username = {$db_sender});");
    return $color;
}


/* Returns whether the account exists in the database. */
function account_exists($friend) {
    $db = makePDO();

    $dbFriend = $db->quote($friend);
    $rows = $db->query("SELECT *
                        FROM User_Accounts
                        WHERE (Email = {$dbFriend} OR Username = {$dbFriend})
                        LIMIT 1");
    
    return $rows->rowCount();
}

/* edits the first name in the database. */
function edit_firstname_in_db($new_firstname, $sender) {
    $db = makePDO();

    $db_new_firstname = $db->quote($new_firstname);
    $db_sender = $db->quote($sender);
    $db->query("UPDATE User_Accounts SET First_Name = {$db_new_firstname} WHERE (Email = {$db_sender} OR Username = {$db_sender});");
}
/* edits the last name in the database. */
function edit_lastname_in_db($new_lastname, $sender) {
    $db = makePDO();

    $db_new_lastname = $db->quote($new_lastname);
    $db_sender = $db->quote($sender);
    $db->query("UPDATE User_Accounts SET Last_Name = {$db_new_lastname} WHERE (Email = {$db_sender} OR Username = {$db_sender});");
}
/* edits the username in the database. */
function edit_username_in_db($new_username, $sender) {
    $db = makePDO();

    $db_new_username = $db->quote($new_username);
    $db_sender = $db->quote($sender);
    $db->query("UPDATE User_Accounts SET Username = {$db_new_username} WHERE (Email = {$db_sender} OR Username = {$db_sender});");
}
/* edits the city in the database. */
function edit_city_in_db($new_city, $sender) {
    $db = makePDO();

    $db_new_city = $db->quote($new_city);
    $db_sender = $db->quote($sender);
    $db->query("UPDATE User_Accounts SET City = {$db_new_city} WHERE (Email = {$db_sender} OR Username = {$db_sender});");
}
/* edits the country in the database. */
function edit_country_in_db($new_country, $sender) {
    $db = makePDO();

    $db_new_country = $db->quote($new_country);
    $db_sender = $db->quote($sender);
    $db->query("UPDATE User_Accounts SET Country = {$db_new_country} WHERE (Email = {$db_sender} OR Username = {$db_sender});");
}

/* Sends a friend a message. */
function send_friend($ciphered_message, $real_message, $friend, $sender) {
        if(!account_exists($friend)) {
                add_message_to_db($ciphered_message, $real_message, $friend, $sender);
        } else {
            print("That friend's account does not exist.");
        }
    
}

/* Returns whether the account info is valid. */
function is_valid_account_info($email, $password) {
    return (preg_match("/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/", $email) && 
            preg_match("/^.{6,30}$/", $password) );
}

/* Returns if the username exists in the database. */
function username_exists($username) {
    $db = makePDO();

    $dbUsername = $db->quote($username);
    $rows = $db->query("SELECT *
                        FROM User_Accounts
                        WHERE Username = {$dbUsername}
                        LIMIT 1");
    
    return $rows->rowCount();
}

function show_friends($sender) {
    $list_of_friends = show_friends_from_db($sender);
    $list_of_friends->execute();
    //$result = $list_of_friends->fetch(\PDO::FETCH_ASSOC);
    $result = $list_of_friends->fetchAll();
    $sender = $_SESSION["name"];
    foreach($result as $row) {
        print("<button type=" . "button" . " id=" . "friend_" . $row['Friend_ID'] . " class=" . "friend_element" . ">");
        if (strcmp($sender, $row['Receiver']) !== 0) {
            print($row['Receiver']);
        }
        else {
            print($row['Requester']);
        }
        print("</button>");
        print("<br>");
        
    }
}

function show_friends_from_db($sender) {
    $db = makePDO();

    $db_sender = $db->quote($sender);
    $list_of_friends = $db->query("SELECT * FROM Friend_Table WHERE (Requester={$db_sender} OR Receiver={$db_sender}) ORDER BY Friend_ID DESC;");
    return $list_of_friends;
}



?>