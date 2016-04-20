<?php

/*
 * Vivo Applications
 *
 * PHP for the versus page.
 */

include("global.php");
ensure_logged_in();



$description = "Battle your friends to be crowned the cryptography champion!";
$keywords = "crypto, vivo, applications, versus";
$cssfiles = ["styles/global.css", "styles/versus.css"];
$jsfiles = ["scripts/global.js", "scripts/versus.js"];
printHeader("Versus | Crypto", $description, $keywords, $cssfiles, $jsfiles);
printNavbar();
?>




<div id="main_content">
    <h1>Versus</h1>
    <div class="cryptoGame">
			<div id="leftColumn">
				<div class="tabs">
					<div class="tab-list">
						<ol>
							
							<button type="button" id="messages_tab">
							<li id="tab_messages" class="active">
							Messages
							</li>
							</button>
							
							<button type="button" id="friends_tab">
							<li id="tab_friends" >
							Friends
							</li>
							</button>

							
							<button type="button" id="settings_tab">
							<li id="tab_settings">
							Settings
							</li>
							</button>
						</ol>
					</div>
					<div class="tab-content">
						<div id="messages" class="tab_item">
							<p>Here are your messages.</p>
						</div>

						<div id="friends" class="tab_item">
							<p>Here are your friends.</p>
						</div>

						<div id="settings" class="tab_item">
							<p>Here are your settings.</p>
						</div>
					</div>
				</div>
			</div>
			<div id="rightColumn">
				<div id="passive_text">
					<form> <textarea id="passive_form" name="passive_form" cols="40" rows="10"></textarea></form>
				</div>
				<div id="active_text">
					<form> <textarea id="active_form" name="active_form" cols="40" rows="12"></textarea></form>
				</div>
			</div>
		</div>
</div>

<?= printFooter() ?>