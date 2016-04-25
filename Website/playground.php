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
							
							<button type="button" id="challenge_one" class="tab_active">
							<li id="tab_challenge_one">
							Challenge One
							</li>
							</button>
							
							<button type="button" id="challenge_two" class="tab_inactive">
							<li id="tab_challenge_two" >
							Challenge Two
							</li>
							</button>

							
							<button type="button" id="challenge_three" class="tab_inactive">
							<li id="tab_challenge_three">
							Challenge Three
							</li>
							</button>
							
							<button type="button" id="challenge_four" class="tab_inactive">
							<li id="tab_challenge_four">
							Challenge Four
							</li>
							</button>
							
						</ol>
					</div>
					<div class="tab-content">
						<div id="challenge_one_content" class="challenge_content">
							<p>Welcome to your first challenge!</p>
						</div>

						<div id="challenge_two_content" class="challenge_content">
							<p>Here's your second challenge.</p>
						</div>

						<div id="challenge_three_content" class="challenge_content">
							<p>Welcome to the third challenge.</p>
						</div>
						
						<div id="challenge_four_content" class="challenge_content">
							<p>Welcome to the fourth and final challenge.</p>
						</div>
						
					
					</div>
				</div>
			</div>
			<div id="rightColumn">
				<div id="passive_text">
					<form> <div id="passive_form" name="passive_form" cols="40" rows="7"></textarea></div>
				</div>
				<div id="active_text">
					<form> <textarea id="active_form" name="active_form" cols="40" rows="12"></textarea></form>
				</div>
			</div>
		</div>
</div>

<?= printFooter() ?>