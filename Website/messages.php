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

        if ($type == "message_send") {
            $ciphered_message = $_POST["cipher"];
            $real_message = $_POST["message"];
            $friend = $_POST["friend"];
            send_friend($ciphered_message, $real_message, $friend, $sender);
        } else if ($type == "message_load") {
            load_messages($sender);
        } else if ($type == "inbox_load") {
            load_inbox($sender);     
        } else if ($type == "outbox_load") {
            load_outbox($sender);
        } else if ($type == "message_read") {
            $ciphered_message = $_POST["cipher"];
            $real_message = $_POST["message"];
            $friend = $_POST["friend"];
//             mark_message($ciphered_message, $real_message, $friend, $sender);
        } 
        else if ($type == "show_friends") {
            $sender = $_SESSION["name"];
            show_friends($sender);
        } else if ($type == "accept_friend_request") {
            $friend = $_POST["friend"];
//             accept_friend_request($friend, $sender);
        } else if ($type == "make_friend_request") {
            $friend = $_POST["friend"];
//             make_friend_request($friend, $sender);
        } else if ($type == "settings_load") {
               load_settings($sender); 
        } else if ($type == "settings_change") {
            $new_color = $_POST["new_color"]; 
            change_settings($sender, $new_color);
        }
        else {
            //redirect("index", "Oops! Post information wasn't passed.");
        }
    }
}

function load_outbox($sender) {
    $outbox_messages = load_outbox_from_db($sender);
    $outbox_messages->execute();
//  $result = $list_of_messages->fetch(\PDO::FETCH_ASSOC);
    $result = $outbox_messages->fetchAll();
    foreach($result as $row) {
        print("<button type=" . "button" . " id=" . "message_" . $row['Message_ID'] . " class=" . "message_element" . ">");
        print("<div id=" . "message_" . $row['Message_ID'] . "_cipher" . ">");
        print("cipher: " . $row['Ciphertext']);
        print("</div>");
        print("<br>");
        print("sent to: " . $row['Recipient'] . "<br>");
        print("message: " . $row['Plaintext'] . "<br>");
        print("<div id=" ."answer_" . $row['Message_ID'] . " class=" . "answer_element" . ">");
        print("You: " . $row['Sender'] . "<br>");
        print("</div>");
        print("</button>");
        
    }
    
    print("<div id=" . "message_count" . ">");
    print("rowCount: " . $outbox_messages->rowCount() . "<br>");
    print("</div>");
}


function load_outbox_from_db($sender) {
    $db = makePDO();
// WHERE (Sender = {$db_sender} OR Recipient = {$db_sender});
    $db_sender = $db->quote($sender);
    $outbox_messages = $db->query("SELECT * FROM Game_Messages WHERE Sender = {$db_sender};");
    return $outbox_messages;
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
    $inbox_messages = $db->query("SELECT * FROM Game_Messages WHERE Recipient = {$db_sender};");
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
                        FROM Game_Messages WHERE (Sender = {$db_sender} OR Recipient = {$db_sender});");
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

/* Adds a new user account to the database. */
function add_message_to_db($ciphered_message, $real_message, $friend, $sender) {
    $db = makePDO();

    $db_ciphered_message = $db->quote($ciphered_message);
    $db_real_message = $db->quote($real_message);
    $db_friend = $db->quote($friend);
    $db_sender = $db->quote($sender);
    $db->query("INSERT INTO Game_Messages VALUE ({$db_ciphered_message}, {$db_real_message}, NULL, {$db_sender}, {$db_friend}, DEFAULT, DEFAULT);");
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
    $list_of_friends = $db->query("SELECT * FROM Friend_Table WHERE (Requester={$db_sender} OR Receiver={$db_sender});");
    return $list_of_friends;
}


/* Logs in if the account info is valid. */
function login($email, $password) {
    if (account_exists($email, $password)) {
        $_SESSION["name"] = $email;
        redirect("versus", "Login successful! Welcome back!");
    } else {
        print("Invalid login account, try again.");
    }
}



?>