/*
 * Vivo Applications
 *
 * Javascript for the login page.
*/

/* Anonymous function for the "module pattern", so no global variables are introduced */
(function() {
    "use strict";

    /* Set up - such as onclick events, etc. */
    window.onload = function() {
        resetPage();
        randomBackground();

        $("get_started_button").onclick = getStarted;
        $("log_in_button").onclick = logIn;
        $("login_back").onclick = resetPage;
    };

    /* Sets the displays for when log in is clicked. */
    function logIn() {
        $("login_buttons").style.display = "none";
        $("main_login_content").style.marginTop = "-202px";
        $("login_back").style.display = "block";
        $("login_form").style.display = "block";
    }

    /* Sets the displays for when get started is clicked. */
    function getStarted() {
        $("login_buttons").style.display = "none";
        $("main_login_content").style.marginTop = "-225px";
        $("login_back").style.display = "block";
        $("get_started_form").style.display = "block";
    }

    /* Selects and sets a new random background. */
    function randomBackground() {
        var randIndex = Math.floor(Math.random() * 17);
        var imageURL = "url('http://crypto.vivoapplications.com/images/backgrounds/" + randIndex + ".jpg')";
        document.body.style.backgroundImage = imageURL;
    }

    /* Shorthand method for sending an ajax request to bestreads.php */
    function requestBackground(handler) {
        var request = new XMLHttpRequest();
        request.onload = handler;
        request.open("GET", "http://crypto.vivoapplications.com/background_utility.php" + title, true);
        request.send();
    }

    /* Resets the page to its defaults when the page is refreshed. */
    function resetPage() {
        $("get_started_form").style.display = "none";
        $("login_form").style.display = "none";
        $("login_back").style.display = "none";
        $("main_login_content").style.marginTop = "-176px";
        $("login_buttons").style.display = "block";
    }

}) ();