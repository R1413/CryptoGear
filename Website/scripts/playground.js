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
        load_my_settings_onload();
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
    $("passive_form").innerHTML = "ovwl fvb kv uva ahrl avv svun av kljyfwa aopz";
    var string = "hope you do not take too long to decrypt this";
}

function load_challenge_two() {
    $("passive_form").innerHTML = "ovwl fvb kv uva ahrl avv svun av kljyfwa aopz";
    var string = "hope you do not take too long to decrypt this";
}

function load_challenge_three() {
    $("passive_form").innerHTML = "ovwl fvb kv uva ahrl avv svun av kljyfwa aopz";
    var string = "hope you do not take too long to decrypt this";
}

function load_challenge_four() {
    $("passive_form").innerHTML = "e pdejg ukq wna cappejc pda dwjc kb pda ywaown yeldan";
    var string = "i think you are getting the hang of it";
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

function load_my_settings_onload() {
    jQuery.ajax({ url: 'messages',
        data: {type: 'settings_load'},
        type: 'post',
        success: function(output) {
        $("stored_settings").innerHTML = output; 
        $("stored_settings").style.display = "none";
        //$("main_content").style.backgroundColor = "#" + $("stored_settings").innerHTML;
        var string = $("settings_1_color").innerHTML;
        $("main_content").style.backgroundColor = "#" + string;
        jQuery( ".tab-content" ).css("background", "#" + string);
        jQuery( ".tabs" ).css("background", "#" + string);
        //$("messaging_form").style.backgroundColor = "#" + string;     
        $("rightColumn").style.backgroundColor = "#" + string;
        var body = document.getElementsByTagName("BODY")[0];
        body.style.backgroundColor = "#" + string;      
        }
        });
}
