<?php

/*
 * Vivo Applications
 *
 * PHP for the playground page.
 */

include("global.php");
ensure_logged_in();

$description = "Hone your cryptography skills to become the very best!";
$keywords = "crypto, vivo, applications, training";
$cssfiles = ["styles/global.css", "styles/playground.css"];
$jsfiles = ["scripts/global.js", "scripts/playground.js"];
printHeader("Playground | Crypto", $description, $keywords, $cssfiles, $jsfiles);
printNavbar();
?>

<div id="main_content">
    <h1>Playground</h1>
    <div class="cryptoGame">
			<div id="leftColumn">
				<div class="tabs">
					<div class="tab-list">
						<ol>
							
							<button type="button" id="messages_tab">
							<li id="tab_messages" class="active">
							Challenge One
							</li>
							</button>
							
							<button type="button" id="friends_tab">
							<li id="tab_friends" >
							Challenge Two
							</li>
							</button>

							
							<button type="button" id="settings_tab">
							<li id="tab_settings">
							Challenge Three
							</li>
							</button>
						</ol>
					</div>
					<div class="tab-content">
						<div id="messages" class="tab_item">
							<p>Welcome to your first challenge!</p>
						</div>

						<div id="friends" class="tab_item">
							<p>Here's your second challenge.</p>
						</div>

						<div id="settings" class="tab_item">
							<p>Welcome to the third and final challenge.</p>
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