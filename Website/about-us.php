<?php

/*
 * Vivo Applications
 *
 * PHP for the about us page.
 */

include("global.php");

$description = "About the Crypto team.";
$keywords = "crypto, vivo, applications, about us";
$cssfiles = ["styles/global.css"];
$jsfiles = ["scripts/global.js"];
printHeader("About Us | Crypto", $description, $keywords, $cssfiles, $jsfiles);
printNavbar();
?>

<div id="main_content">
    <h1>About Us</h1>
    <h2 class="dev_name">Jos&eacute; Ca&ntilde;izares</h2>
    <p> An artist and app developer, Jos&eacute; is a fan of Atletico Madrid and spends most of his time at the turf gym playing soccer.</p>
    <h2 class="dev_name">Anh-Khoa Than</h2>
    <p>Anh, a die-hard fan of Manchester United, spends much of his time playing FIFA and watching vines.</p>
    <h2 class="dev_name">Raymond Duncan</h2>
    <p>A nonconformist in many respects, Raymond finds time to learn computer science and delve into the language of French.</p>
    <h2 class="dev_name">Sayed Sarder</h2>
    <p>Sayed does graph theory and is known for the famous quote, "Once you go in, there's no way back."</p>
</div>

<?= printFooter() ?>