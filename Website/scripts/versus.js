/*
 * Vivo Applications
 *
 * Javascript for the versus page.
*/

(function() {
    "use strict";
    /* Set up - such as onclick events, etc. */
    window.onload = function() {
        document.getElementById("tab_messages").addEventListener("click", setActiveTab);
        document.getElementById("tab_friends").addEventListener("click", setActiveTab);
        document.getElementById("tab_settings").addEventListener("click", setActiveTab);
        startActiveTab("tab_messages");
        };
    
    

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


/* Just a shorthand method for calling document.getElementById */
function $(id) {
    return document.getElementById(id);
}


function setActiveTab() {
        
        var tab = this.id;
        var navs = ["messages", "friends", "settings"];

        for (var i = 0; i < navs.length; i++) {
            var element = document.getElementById(navs[i]);
            element.style.display = "none";
            //alert(tab);
            if (tab == "tab_" + navs[i]) {
                element.style.display = "block";
                //alert(this.id);
            }
        } 
    }
    
function startActiveTab(tab) {
        
        var navs = ["messages", "friends", "settings"];

        for (var i = 0; i < navs.length; i++) {
            var element = document.getElementById(navs[i]);
            element.style.display = "none";
            //alert(tab);
            if (tab == "tab_" + navs[i]) {
                element.style.display = "block";
                //alert(this.id);
            }
        } 
    }

   
