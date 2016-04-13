<?php

/* 
 * Vivo Applications
 *
 * PHP for the login page.
 */

include("shared.php");

$description = "Login to Crypto, adventure awaits.";
$keywords = "crypto, login, vivo, applications";
$cssfiles = ["styles/login.css"];
$jsfiles = null;
printHeader("Login", $description, $keywords, $cssfiles, $jsfiles);
?>

<div id="login-content">
    <img id="crypto-logo-login" src="images/crypto_logo_gray.svg" alt="Crypto" width="750px" heigth="auto" />
    <p>Go ahead and log in. Crypto awaits you.</p>
    <form id="loginform" action="login_utility.php" method="post">
        <input autofocus="autofocus" id="email-input" name="email" placeholder="Email" size="30" type="text" />
        <input autofocus="autofocus" id="password-input" name="password" placeholder="Password" size="30" type="text" />
        <input id="login-button" type="submit" value="Log In" />
    </form>
</div>