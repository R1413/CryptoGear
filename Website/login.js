(function(){
    
    window.onload = function() {
        

        $("LogIn").onclick = query;
        
       
    };
    
    function query() {
        
        $("output").innerHTML = "HELLO WORLD";
        email = $("email");
        password = $("password");
        sendRequest(handler, username, password);
        
        
    }
    
    
    function $(id) {
        return document.getElementById(id);
    }
    
    
    function sendRequest(handler) {
        var request = new XMLHttpRequest();
        request.onload = handler;
        request.open("GET", "login.php", true);
        request.send();
    }
    
    

    

    
    
})();