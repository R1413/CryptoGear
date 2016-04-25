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
						    
							</button>
						</ol>
					</div>
					
					<div id="messaging_nav">
        					<button type="button" id="inbox_ajax" class="tab_inactive">
            					<li id="tab_inbox">
							<img src="images/inbox.svg" alt="settings" width="40px" height="40px">
							</li>
        					</button>
        					<button type="button" id="outbox_ajax" class="tab_inactive">
            					<li id="tab_outbox">
							<img src="images/outbox.svg" alt="settings" width="40px" height="40px">
							</li>
        					</button>
        					<button type="button" id="compose_ajax" class="tab_inactive">
            					<li id="tab_compose">
							<img src="images/compose.svg" alt="settings" width="40px" height="40px">
							</li>
        					</button>
    					</div>
    					
					<div class="tab-content">
    					
    					
    					
						<div id="messages" class="tab_item">
							<p>Here are your messages.</p>
						</div>

						<div id="friends" class="tab_item">
							<p>Here are your friends. <?php echo $friends; ?></p>
						</div>
						
						<div id="friends_options">
    						<input id="add_friend" class="option_item" name="add_friend" placeholder="add a friend!" type="text" />  
                        <button type="button" id="add_friend_ajax">add</button>
                        <div id="could_not_add_friend"></div>
				        </div>

						<div id="settings" class="tab_item">
							<p>Here are your settings.</p>
						</div>
						<div id="settings_options">
                        <input id="change_color" class="option_item" name="new_color" placeholder="your bg color!" type="text" />  
                        <button type="button" id="color_ajax">change color
                        </button>
				        </div>
						
					</div>
				</div>
			</div>
			<div id="rightColumn">
    			<form id="messaging_form" action="messages" method="post">
				<div id="passive_text">
					<div id="passive_form" name="cipher"></div>
				</div>
				<div id="active_text">
                    <textarea autofocus="autofocus" id="active_form" name="message" placeholder="Think of a message to send your friends!" cols="40" rows="12" maxlength="140" type="text"></textarea>
                    <input type="hidden" name="type" value="message_send" />
				</div>
				</form>
				
				
				<div id="messaging_options">
				<input id="friend_input" class="friend_item" name="friend" placeholder="friend" type="text" />
				<button type="button" id="send_message_ajax">
				send!
				</button>
				</div>
				<div id="confirmation">
				</div>
				
				
				
				
                

			</div>
		</div>
</div>

<?= printFooter() ?>