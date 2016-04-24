/*
 * Vivo Applications
 *
 * Javascript for the versus page.
*/



(function() {
    "use strict";
    /* Set up - such as onclick events, etc. */

    window.onload = function() {
        setActivePage();
        $("tab_messages").addEventListener("click", setActiveTab);
        $("tab_friends").addEventListener("click", setActiveTab);
        $("tab_settings").addEventListener("click", setActiveTab);
        
        load_my_messages();
        load_my_settings_onload();
        
        startActiveTab("tab_messages");
        };
    
    jQuery(document).ready(function () {
        jQuery("#friends_ajax").click( function(){
            load_my_friends();
        });
        
        jQuery("#messages_ajax").click( function(){
            load_my_messages();
        });
        
        jQuery("#settings_ajax").click( function(){
            load_my_settings();
        });
        
        jQuery("#color_ajax").click( function(){
            change_my_settings();
        });
        
        jQuery("#send_message_ajax").click( function(){
            send_message();
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

function load_my_messages() {
    jQuery.ajax({ url: 'messages',
        data: {type: 'message_load'},
        type: 'post',
        success: function(output) {
        $("messages").innerHTML = output;
        $("settings_options").style.display = "none";
        $("messaging_nav").style.display = "block";
        var i = 0;
            var ids = [];  
            jQuery(".message_element").each(function(){
                ids.push(this.id);
            });
            for (var i = 0; i < ids.length; i++) {
                $(ids[i].toString()).addEventListener('click', function() {
                    var active_message = this.id;
                    setActiveMessage(ids, active_message);
                });
            }
        }
        });
}

function load_my_friends() {
    jQuery.ajax({ url: 'messages',
        data: {type: 'show_friends'},
        type: 'post',
        success: function(output) {
        $("friends").innerHTML = output;
        $("settings_options").style.display = "none";
        $("messaging_nav").style.display = "none";
            var i = 0;
            var ids = [];  
            jQuery(".friend_element").each(function(){
                ids.push(this.id);
            });
            for (var i = 0; i < ids.length; i++) {
                $(ids[i].toString()).addEventListener('click', function() {
                    var active_friend = this.id;
                    setActiveFriend(ids, active_friend);
                });
            }
        
        }
        });
}

function load_my_settings() {
    jQuery.ajax({ url: 'messages',
        data: {type: 'settings_load'},
        type: 'post',
        success: function(output) {
        $("settings").innerHTML = output;
        $("settings_options").style.display = "block";
        $("messaging_nav").style.display = "none";
        var i = 0;
            var ids = [];  
            jQuery(".setting_element").each(function(){
                ids.push(this.id);
            });
            for (var i = 0; i < ids.length; i++) {
                $(ids[i].toString()).addEventListener('click', function() {
                    var active_setting = this.id;
                    setActiveSetting(ids, active_setting);
                });
            }
        }
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
        //document.getElementsByClassName("tab-content").style.backgroundColor = "#" + string;    
        //document.getElementsByClassName("tabs").style.backgroundColor = "#" + string;  
        jQuery( ".tab-content" ).css("background", "#" + string);
        jQuery( ".tabs" ).css("background", "#" + string);
        $("messaging_form").style.backgroundColor = "#" + string;     
        $("rightColumn").style.backgroundColor = "#" + string;
        var body = document.getElementsByTagName("BODY")[0];
        body.style.backgroundColor = "#" + string;      
        }
        });
}


function change_my_settings() {
    jQuery.ajax({ url: 'messages',
        data: {type: 'settings_change', new_color: jQuery("#change_color").val()},
        type: 'post',
        success: function(output) {
        $("settings").innerHTML = output;
        $("settings_options").style.display = "block";
        $("stored_settings").innerHTML = output; 
        $("stored_settings").style.display = "none";
        var string = $("settings_1_color").innerHTML;
        $("main_content").style.backgroundColor = "#" + string;
        jQuery( ".tab-content" ).css("background", "#" + string);
        jQuery( ".tabs" ).css("background", "#" + string);
        $("messaging_form").style.backgroundColor = "#" + string;     
        $("rightColumn").style.backgroundColor = "#" + string;   
        var body = document.getElementsByTagName("BODY")[0];
        body.style.backgroundColor = "#" + string;
        var i = 0;
        var ids = [];  
        jQuery(".setting_element").each(function(){
            ids.push(this.id);
            });
            for (var i = 0; i < ids.length; i++) {
            $(ids[i].toString()).addEventListener('click', function() {
                var active_setting = this.id;
                setActiveSetting(ids, active_setting);
            });
            }
        }
    });
}

function send_message() {
    jQuery.ajax({ url: 'messages',
        data: {type: 'message_send', cipher: jQuery("#passive_form").val(), message: jQuery("#active_form").val(), friend: jQuery("#friend").val()}, 
        type: 'post',
        success: function(output) {
        $("confirmation").style.display = "block";
        $("confirmation").innerHTML = "sent to " + jQuery("#friend").val() + "!";    
        }
        });
}


function clearSelection() {
    var i = 0;
    var ids = [];  
    jQuery(".message_active").each(function(){
        ids.push(this.id);
    });

    for (var i = 0; i < ids.length; i++) {
        var msg = $(ids[i]);
        msg.classList.remove("message_active");
        msg.classList.add("message_inactive");
        }
}

function setActiveMessage(id_array, active_message) {
        var ids = id_array;

        for (var i = 0; i < ids.length; i++) {
            var msg = document.getElementById(ids[i]);
            msg.classList.remove("message_active");
            msg.classList.add("message_inactive");
//             msg.style.backgroundColor = "#465461";
//             alert(msg.id);
//             alert(active_message);
            if (msg.id == active_message) {
                msg.classList.remove("message_inactive");
                msg.classList.add("message_active");
                $("passive_form").innerHTML = $(active_message + "_cipher").innerHTML;
                $("versus_header").removeEventListener("click", clearSelection);
                $("versus_header").addEventListener("click", clearSelection);
//                 msg.style.backgroundColor = "#A7A5A7";
            }
        }
    }
    
function setActiveFriend(id_array, active_friend) {
        var ids = id_array;

        for (var i = 0; i < ids.length; i++) {
            var msg = document.getElementById(ids[i]);
            msg.classList.remove("friend_active");
            msg.classList.add("friend_inactive");
            if (msg.id == active_friend) {
                msg.classList.remove("friend_inactive");
                msg.classList.add("friend_active");
                $("passive_form").innerHTML = $(active_friend).innerHTML;
//                 $("passive_form").innerHTML = jQuery("#active_friend #cipher").innerHTML;
                $("versus_header").removeEventListener("click", clearSelection);
                $("versus_header").addEventListener("click", clearSelection);
            }
        }
    }
    
function setActiveSetting(id_array, active_setting) {
        var ids = id_array;

        for (var i = 0; i < ids.length; i++) {
            var msg = document.getElementById(ids[i]);
            msg.classList.remove("setting_active");
            msg.classList.add("setting_inactive");
            if (msg.id == active_setting) {
                msg.classList.remove("setting_inactive");
                msg.classList.add("setting_active");
                $("passive_form").innerHTML = $(active_setting + "_color").innerHTML;
//                 $("passive_form").innerHTML = jQuery("#active_friend #cipher").innerHTML;
                $("versus_header").removeEventListener("click", clearSelection);
                $("versus_header").addEventListener("click", clearSelection);
            }
        }
    }  
    

function setActiveTab() {
        
        var tab = this.id;
        var navs = ["messages", "friends", "settings"];

        for (var i = 0; i < navs.length; i++) {
            var element = $(navs[i]);
            $(navs[i] + "_ajax").classList.remove("tab_active");
            $(navs[i] + "_ajax").classList.add("tab_inactive");
            element.style.display = "none";
            //alert(tab);
            if (tab == "tab_" + navs[i]) {
                //temp = tab;
                $(navs[i] + "_ajax").classList.remove("tab_inactive");
                $(navs[i] + "_ajax").classList.add("tab_active");
                element.style.display = "block";
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




   
