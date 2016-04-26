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
$cssfiles = ["styles/global.css", "styles/profile.css"];
$jsfiles = ["scripts/global.js", "scripts/profile.js"];
printHeader("Profile | Crypto", $description, $keywords, $cssfiles, $jsfiles);
printNavbar();
?>

<div id="main_content">
    <h1>Profile</h1>
    <div id="loading"></div>
    <div id="profile">
        
    </div>
    <ul id="chart">
		<li id="Games_Won">
			<span class="bar"></span>
			<span class="percent"></span>
		</li>
		<li id="Games_Lost">
			<span class="bar"></span>
			<span class="percent"></span>
		</li>
		<li id="Experience">
			<span class="bar"></span>
			<span class="percent"></span>
		</li>
		<li id="Reliability">
			<span class="bar"></span>
			<span class="percent"></span>
		</li>
	</ul>
	<li id="Crypto">
			<span class="bar"></span>
			<span class="percent"></span>
        </li>
	<button type="button" id="update_info" class="tab_inactive">
        <li id="tab_update">
        <img src="images/compose.svg" alt="settings" width="40px" height="40px">
        </li>
    </button>
    
    <div id="profile_options" class="tab_inactive">
        <input id="change_firstname" class="update_item" name="new_firstname" placeholder="update your first name!" type="text" />  
        <button type="button" id="firstname_ajax">update
        </button>
        <input id="change_lastname" class="update_item" name="new_lastname" placeholder="update your last name!" type="text" />  
        <button type="button" id="lastname_ajax">update
        </button>
        <input id="change_username" class="update_item" name="new_username" placeholder="update your username!" type="text" />  
        <button type="button" id="username_ajax">update
        </button>
        <input id="change_city" class="update_item" name="new_city" placeholder="update your city!" type="text" />  
        <button type="button" id="city_ajax">update
        </button>
        <input id="change_country" class="update_item" name="new_country" placeholder="update your country!" type="text" />  
        <button type="button" id="country_ajax">update
        </button>
        </div>
    
    </div>

<?= printFooter() ?>