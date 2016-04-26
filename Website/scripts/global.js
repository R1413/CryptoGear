/*
 * Vivo Applications
 *
 * Global javascript functions.
*/

"use strict";

/* Just a shorthand method for getting the computed style property of an element. */ 
function getStyle(element, property) {
    return window.getComputedStyle(element).getPropertyValue(property);
}

/* Sets the current page to active. Allowing it to be highlighted on the navbar. */
function setActivePage() {
        var navs = ["playground", "training", "versus", "profile"];
        var url = window.location.href;

        for (var i = 0; i < navs.length; i++) {
            $("nav_" + navs[i]).classList.remove("nav_item_active");
            if (url == "http://crypto.vivoapplications.com/" + navs[i]) {
                $("nav_" + navs[i]).classList.add("nav_item_active");
            }
        } 
    }

/* Just a shorthand method for calling document.getElementById */
function $(id) {
    return document.getElementById(id);
}