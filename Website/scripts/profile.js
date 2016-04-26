/*
 * Vivo Applications
 *
 * Javascript for the profile page.
*/

(function() {
    "use strict";
    /* Set up - such as onclick events, etc. */

    window.onload = function() {
        setActivePage();
        
        $("tab_update").addEventListener("click", setActiveUpdateInfo);
        load_my_profile_info();
        load_my_settings_onload();
        };   
        
    jQuery(document).ready(function () {
        jQuery("#firstname_ajax").click( function(){
            update_firstname();
        });
        
        jQuery("#lastname_ajax").click( function(){
            update_lastname();
        });
        
        jQuery("username_ajax").click( function(){
            update_username();
        });
        
        jQuery("#city_ajax").click( function(){
            update_city();
        });
        
        jQuery("#country_ajax").click( function(){
            update_country();
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

function update_firstname() {
    jQuery.ajax({ url: 'profile_info',
        data: {type: 'edit_firstname', new_firstname: jQuery("#change_firstname").val()},
        type: 'post',
        success: function(output) {
        load_my_profile_info();
        }
    });
}

function update_lastname() {
    jQuery.ajax({ url: 'profile_info',
        data: {type: 'edit_lastname', new_lastname: jQuery("#change_lastname").val()},
        type: 'post',
        success: function(output) {
        load_my_profile_info();
        }
    });
}

function update_username() {
    jQuery.ajax({ url: 'profile_info',
        data: {type: 'edit_username', new_username: jQuery("#change_username").val()},
        type: 'post',
        success: function(output) {
        load_my_profile_info();
        }
    });
}

function update_city() {
    jQuery.ajax({ url: 'profile_info',
        data: {type: 'edit_city', new_city: jQuery("#change_city").val()},
        type: 'post',
        success: function(output) {
        load_my_profile_info();
        }
    });
}

function update_country() {
    jQuery.ajax({ url: 'profile_info',
        data: {type: 'edit_country', new_country: jQuery("#change_country").val()},
        type: 'post',
        success: function(output) {
        load_my_profile_info();
        }
    });
}


function load_my_profile_info() {
    jQuery.ajax({ url: 'profile_info',
        data: {type: 'load_profile_info'},
        type: 'post',
        success: function(output) {
        $("profile").innerHTML = output;
        load_bargraphs();
        load_crypto();
        }
        });
}

function load_bargraphs() {
    jQuery(function(){
	    jQuery('#chart li').each(function(){
    		var id = jQuery(this).attr('id');
//     		alert(id);
            var lat = parseInt(jQuery("#profile_" + jQuery(".hidden_element").text() + "_" + id).text());
    		lat = lat > 100 ? 100 : lat;
    		if(id == "Reliability") {
        		jQuery(this).children('.percent').html(lat + "%" + " reliability.");
    		} else if (id == "Games_Won") {
        		jQuery(this).children('.percent').html(lat+ " games won.");
    		} else if (id == "Games_Lost") {
        		jQuery(this).children('.percent').html(lat+ " games lost.");
    		} else if (id == "Experience") {
        		jQuery(this).children('.percent').html(lat+ " experience points.");
    		}
    		var cool = jQuery(this).width();
    		var len = parseInt(cool, 10) * parseInt(lat, 10)/100;
    		jQuery(this).children('.bar').animate({ 'width' : len + 'px'}, 1500);
	    });
    });
}



function load_crypto() {
    jQuery(function(){
		var id = jQuery("#Crypto").attr('id');
//             var lat = parseInt(jQuery("#profile_" + jQuery(".hidden_element").text() + "_Games_Won").text()) - parseInt(jQuery("#profile_" + jQuery(".hidden_element").text() + "_Games_Lost").text());
        var lat = 12;
		lat = lat > 100 ? 100 : lat;
		jQuery("#Crypto").children('.percent').html(lat + " cryptos.");
		var cool = jQuery(this).width();
		var len = parseInt(cool, 10) * parseInt(lat, 10)/100;
		jQuery("#Crypto").children('.bar').animate({ 'width' : len + 'px'}, 1500);
    });
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
        var body = document.getElementsByTagName("BODY")[0];
        body.style.backgroundColor = "#" + string;      
        }
        });
}

function setActiveUpdateInfo() {
    if (document.getElementById("profile_options").classList.contains("tab_active")) {
    $("profile_options").classList.remove("tab_active");
    $("profile_options").classList.add("tab_inactive");
    }
    else {
        $("profile_options").classList.remove("tab_inactive");
        $("profile_options").classList.add("tab_active");
    }
    
}

