/*
 * Vivo Applications
 *
 * Javascript for the training page.
*/

(function() {
    "use strict";

    /* Set up - such as onclick events, etc. */
    window.onload = function() {
        setActivePage();
        load_my_settings_onload();
    };

}) ();



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