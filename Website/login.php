<?php

/*
 * Vivo Applications
 *
 * PHP for when login.php sends a login post request.
 */

include("global.php");
ensure_logged_out();
main();

/* Handles the method calling and basic computations of the php file. */
function main() {
    if (!empty($_POST["type"]) && !empty($_POST["email"]) && !empty($_POST["password"])) {
        $email = $_POST["email"];
        $password = $_POST["password"];
        $type = $_POST["type"];

        if ($type == "create" && !empty($_POST["username"])) {
            $username = $_POST["username"];
            create_account($email, $password, $username);
        } else if ($type == "login") {
            login($email, $password);
        } else {
            redirect("", "Oops! Post information wasn't passed.");
        }
    }
}

/* Returns whether the account exists in the database. */
function account_exists($email, $password) {
    $db = makePDO();

    $dbEmail = $db->quote($email);
    $dbPassword = $db->quote($password);
    $rows = $db->query("SELECT *
                        FROM User_Accounts
                        WHERE (Email = {$dbEmail} OR Username = {$dbEmail})
                        AND Password = {$dbPassword}
                        LIMIT 1");
    
    return $rows->rowCount();
}

/* Adds a new user account to the database. */
function add_account_to_db($email, $password, $username) {
    $db = makePDO();

    $dbEmail = $db->quote($email);
    $dbPassword = $db->quote($password);
    $dbUsername = $db->quote($username);
    $db->query("INSERT INTO User_Accounts
                VALUE(DEFAULT, DEFAULT, {$dbUsername},
                {$dbPassword}, {$dbEmail}, DEFAULT,
                DEFAULT, NULL, DEFAULT, DEFAULT, DEFAULT,
                DEFAULT)");
}

/* Checks if the account info is valid and creates a new account. */
function create_account($email, $password, $username) {
    if (is_valid_account_info($email, $password)) {
        if(!account_exists($email, $password)) {
            if (!username_exists($username)) {
                add_account_to_db($email, $password, $username);
                login($email, $password);
            } else {
                print("That username is already taken, try a new one.");
            }
        } else {
            print("That email address is already taken, try a new one.");
        }
    } else {
        print("Oops, try again. Make sure you enter a valid email address and have a password between 6 and 30 characters long.");
    }
}

/* Returns whether the account info is valid. */
function is_valid_account_info($email, $password) {
    return (preg_match("/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/", $email) && 
            preg_match("/^.{6,30}$/", $password) );
}

/* Logs in if the account info is valid. */
function login($email, $password) {
    if (account_exists($email, $password)) {
        $_SESSION["name"] = $email;
        redirect("versus", "Login successful! Welcome back!");
    } else {
        print("Invalid information, try again.");
    }
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

?>