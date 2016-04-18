<?php

/*
 * Vivo Applications
 *
 * PHP for the login page. Redirects to versus if already logged in.
 */

include("global.php");
ensure_logged_out();

$description = "Login to Crypto, adventure awaits.";
$keywords = "crypto, login, vivo, applications";
$cssfiles = ["styles/global.css", "styles/index.css"];
$jsfiles = ["scripts/global.js", "scripts/index.js"];
printHeader("Crypto", $description, $keywords, $cssfiles, $jsfiles);
?>

<div id="crypto_logo_login">
    <a href="index">
        <img src="images/crypto_logo_white.svg" alt="Crypto" width="40px" heigth="40px" />
    </a>
</div>

<div id="main_login_content">
    <button id="login_back">&#x276e; Back</button>
    <div id="login_header_container">
        <h1 id="login_header">CRYPTO</h1>
        <h2 id="login_tagline">
            Learn cryptography.
            <br />
            Challenge your friends.
        </h2>
    </div>

    <div id="login_forms_container">
        <div id="login_buttons">
            <button id="get_started_button" class="login_buttons">Get Started</button>
            <button id="log_in_button" class="login_buttons">Log In</button>
        </div>

        <form id="get_started_form" action="login" method="post">
            <div class="form_row">
                <input autofocus="autofocus" id="new_email_input" class="form_item" name="email" placeholder="Email" type="text" />
            </div>
            <div class="form_row">
                <input autofocus="autofocus" id="new_password_input" class="form_item" name="password" placeholder="Password" type="password" />
            </div>
            <div class="form_row">
                <input autofocus="autofocus" id="new_username_input" class="form_item" name="username" placeholder="Username" type="text" />
            </div>
            <input type="hidden" name="type" value="create" />
            <input id="sign_up_submit" class="form_submit" type="submit" value="Sign Up" />
        </form>

        <form id="login_form" action="login" method="post">
            <div class="form_row">
                <input autofocus="autofocus" id="email_input" class="form_item" name="email" placeholder="Email or Username" type="text" />
            </div>
            <div class="form_row">
                <input autofocus="autofocus" id="password_input" class="form_item" name="password" placeholder="Password" type="password" />
            </div>
            <input type="hidden" name="type" value="login" />
            <input id="login_submit" class="form_submit" type="submit" value="Log In" />
        </form>
    </div>
</div>

<?= printFooter() ?>