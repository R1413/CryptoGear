<?php

/*
 * Vivo Applications
 *
 * PHP for the contact us page.
 */

include("global.php");

$description = "Contact the Crypto team.";
$keywords = "crypto, vivo, applications, contact us";
$cssfiles = ["styles/global.css"];
$jsfiles = ["scripts/global.js"];
printHeader("Contact Us | Crypto", $description, $keywords, $cssfiles, $jsfiles);
printNavbar();
?>

<div id="main_content">
    <h1>Say Hello!</h1>
    <h2 class="dev_name">Jos&eacute; Ca&ntilde;izares</h4>
    <p> jose.canizares@colorado.edu</p>
    <h2 class="dev_name">Anh-Khoa Than</h4>
    <p>anhkhoa.than@colorado.edu</p>
    <h2 class="dev_name">Raymond Duncan</h4>
    <p>raymond.duncan@colorado.edu</p>
    <h2 class="dev_name">Sayed Sarder</h4>
    <p>sayed.sarder@colorado.edu</p>
</div>

<?= printFooter() ?>