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
        document.getElementById("tab_messages").addEventListener("click", setActiveTab);
        document.getElementById("tab_friends").addEventListener("click", setActiveTab);
        document.getElementById("tab_settings").addEventListener("click", setActiveTab);
        startActiveTab("tab_messages");
        };
        
        jQuery(document).ready(function () {
            jQuery("#challenge_one").click( function(){
            jQuery.ajax({ url: 'challenge1.html',
            data: {type: 'show_friends'},
            type: 'post',
            success: function(output) {
            $("challenge_one_content").innerHTML = output;
            }
            });
            });
            
            jQuery("#challenge_two").click( function(){
            jQuery.ajax({ url: 'challenge2.html',
            data: {type: 'message_load'},
            type: 'post',
            success: function(output) {
            $("challenge_two_content").innerHTML = output;
            }
            });
            });
            
            jQuery("#challenge_three").click( function(){
            jQuery.ajax({ url: 'challenge2.html',
            data: {type: 'message_load'},
            type: 'post',
            success: function(output) {
            $("challenge_two_content").innerHTML = output;
            }
            });
            });
            
            jQuery("#challenge_four").click( function(){
            jQuery.ajax({ url: 'challenge2.html',
            data: {type: 'message_load'},
            type: 'post',
            success: function(output) {
            $("challenge_two_content").innerHTML = output;
            }
            });
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


function setActiveTab() {
        
        var tab = this.id;
        var navs = ["one", "two", "three", "four"];

        for (var i = 0; i < navs.length; i++) {
            var element = document.getElementById("challenge_" + navs[i] + "_content");
            element.style.display = "none";
            $("challenge_" + navs[i]).classList.remove("tab_active");
            $("challenge_" + navs[i]).classList.add("tab_inactive");
            //alert(tab);
            if (tab == "tab_" + navs[i]) {
                element.style.display = "block";
                $("challenge_" + navs[i]).classList.remove("tab_inactive");
                $("challenge_" + navs[i]).classList.add("tab_active");
                //alert(this.id);
            }
        } 
    }
    
function startActiveTab(tab) {
        
        var navs = ["one", "two", "three", "four"];

        for (var i = 0; i < navs.length; i++) {
            var element = document.getElementById("challenge_" + navs[i] + "_content");
            element.style.display = "none";
            //alert(tab);
            if (tab == "tab_" + navs[i]) {
                element.style.display = "block";
                //alert(this.id);
            }
        } 
    }

   
