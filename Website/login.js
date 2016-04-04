


$(document).ready(function() {
// Start when document will be ready.
$("#LogIn").click(function() {

//$("#passwordClone0").removeClass("invalid");

var email = $("#email").val(); // Store E-mail input value in the variable email.
var password = $("#password").val(); // Store Password input value in the variable password.
/* Check if email=formget@gmail.com and password=fugo then,Show the message Account Validated!!! in the Div having id message.*/
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