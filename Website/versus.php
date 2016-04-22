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

<script type="text/javascript" src="scripts/ciphers.js"></script>

<div id="main_content">
    <h1 id="versus_header">Versus</h1>
    <div class="cryptoGame">
			<div id="leftColumn">
				<div class="tabs">
					<div class="tab-list">
						<ol>
							
							<button type="button" id="messages_ajax" class="tab_active">
							<li id="tab_messages">
							<img src="images/mail.svg" alt="messages" width="40px" height="40px">
							</li>
							</button>
							
							<button type="button" id="friends_ajax" class="tab_inactive">
							<li id="tab_friends" >
							<img src="images/friends.svg" alt="friends" width="40px" height="40px">
							</li>
							</button>
							
							<button type="button" id="settings_ajax" class="tab_inactive">
							<li id="tab_settings">
							<img src="images/settings.svg" alt="settings" width="40px" height="40px">
							</li>
							
							<div id="stored_settings">
							<p>Here are your stored settings.</p>
						    </div>
						    
							</button>
						</ol>
					</div>
					<div class="tab-content">
						<div id="messages" class="tab_item">
							<p>Here are your messages.</p>
						</div>

						<div id="friends" class="tab_item">
							<p>Here are your friends. <?php echo $friends; ?></p>
						</div>

						<div id="settings" class="tab_item">
							<p>Here are your settings.</p>
						</div>
						
					</div>
				</div>
			</div>
			<div id="rightColumn">
    			<form id="messaging_form" action="messages" method="post">
				<div id="passive_text">
					<textarea id="passive_form" name="cipher" placeholder="Your cipher appears here." maxlength="140" cols="40" rows="7"></textarea>
				</div>
				<div id="active_text">
                    <textarea autofocus="autofocus" id="active_form" name="message" placeholder="Think of a message to send your friends!" cols="40" rows="12" maxlength="140" type="text"></textarea>
                    <input type="hidden" name="type" value="message_send" />
                    <input id="friend" class="friend_item" name="friend" placeholder="friend" type="text" />
                    <input id="message_submit" class="form_submit" type="submit" value="Send Message" />
                    
                    </form>
                    
                    <input id="change_color" class="color_item" name="new_color" placeholder="change your background color!" type="text" />    
                    <input type="hidden" name="type" value="settings_change" />
                    <button id="color_ajax">
                    <li id="color_settings">
                    <img src="images/settings.svg" alt="settings" width="40px" height="40px">
                    </li>
                    </button>
				</div>
			</div>
		</div>
</div>

<?= printFooter() ?>