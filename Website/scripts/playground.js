/*
 * Vivo Applications
 *
 * Javascript for the playground page.
*/

(function() {
    "use strict";
    /* Set up - such as onclick events, etc. */
    window.onload = function() {
        setActivePage();
        $("tab_challenge_one").addEventListener("click", setActiveTab);
        $("tab_challenge_two").addEventListener("click", setActiveTab);
        $("tab_challenge_three").addEventListener("click", setActiveTab);
        $("tab_challenge_four").addEventListener("click", setActiveTab);
        startActiveTab("tab_messages");
        };
        
        jQuery(document).ready(function () {
        jQuery("#challenge_one").click( function(){
            load_challenge_one();
        });
        
        jQuery("#challenge_two").click( function(){
            load_challenge_two();
        });
        
        jQuery("#challenge_three").click( function(){
            load_challenge_three();
        });
        
        jQuery("#challenge_four").click( function(){
            load_challenge_four();
        });
        
        
        
        });

    
    

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

function load_challenge_one() {
    
}

function load_challenge_two() {
    $("passive_form").innerHTML = "uvaopun pz ptwvzzpisl, aol dvyk pazlsm zhfz pt wvzzpisl! - hbkylf olwibyu";
}

function load_challenge_three() {

}

function load_challenge_four() {
}

function setActiveTab() {
        
        var tab = this.id;
        var navs = ["one", "two", "three", "four"];

        for (var i = 0; i < navs.length; i++) {
            var element = $("challenge_" + navs[i] + "_content");
            $("challenge_" + navs[i]).classList.remove("tab_active");
            $("challenge_" + navs[i]).classList.add("tab_inactive");
            element.style.display = "none";
            //alert(tab);
            if (tab == "tab_challenge_" + navs[i]) {
                $("challenge_" + navs[i]).classList.remove("tab_inactive");
                $("challenge_" + navs[i]).classList.add("tab_active");
                element.style.display = "block";
                //alert(this.id);
            }
        } 
    }
    
function startActiveTab(tab) {
        
        var navs = ["one", "two", "three", "four"];

        for (var i = 0; i < navs.length; i++) {
            var element = $("challenge_" + navs[i] + "_content");
            element.style.display = "none";
            //alert(tab);
            if (tab == "tab_" + navs[i]) {
                element.style.display = "block";
                //alert(this.id);
            }
        } 
    }

   
