<?php
    /*
     * Vivo Applications
     *
     * PHP for logout post requests.
     */

    include("global.php");
    ensure_logged_in();

    session_destroy();
    session_regenerate_id(TRUE);
    session_start();
    
    redirect("index", "Logout successful!");
?>