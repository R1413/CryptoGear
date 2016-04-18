<?php

/*
 * Vivo Applications
 *
 * PHP for the profile page.
 */

include("global.php");
ensure_logged_in();

$description = "Edit your profile and prepare to become the crypography master!";
$keywords = "crypto, vivo, applications, profile";
$cssfiles = ["styles/global.css"];
$jsfiles = ["scripts/global.js", "scripts/profile.js"];
printHeader("Profile | Crypto", $description, $keywords, $cssfiles, $jsfiles);
printNavbar();
?>

<div id="main_content">
    <h1>Profile</h1>
</div>

<?= printFooter() ?>