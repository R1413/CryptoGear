

$(document).ready(function() {
// Start when document will be ready.
$("#LogIn").click(function() {

var email = $("#email").val();
var password = $("#password").val(); 
/* Check if email=formget@gmail.com 
if (email == "formget@gmail.com" && password == "fugo") {
// $("#message").html("Account Validated!!!");
}
/* If E-mail and Password do not match then shake Div having id maindiv and show the message "***Invalid email or password***" in the div having id message.*/
else {
$("#passwordClone0").effect("shake", { direction: "left", times: 3, distance: 8}, 400);
//$("#passwordClone0").addClass("invalid");
// $("#message").html('***Invalid email or password***');
}
});
});


function clickedButton()
            {

                window.location = 'index.html';
                

            }
            
