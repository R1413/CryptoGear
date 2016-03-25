var express = require("express");
var mysql = require('mysql');
var bodyParser = require('body-parser');
//var session = require('express-session');
var port = 8080;
//this also uses json middleware (when i use stringify)


//First you need to create a connection to the database
var connection = mysql.createConnection({
	host: 'localhost',	//This is the ip of wherever the mysql server is running
	user: 'USER', //this your user's name (on your computer)
	password: 'PASSWORD',	//Replace [PASSWORD] with the database password
	database: 'DATABASE'	//Replace [DATABASE] with the database name
});


var app = express();

app.use(bodyParser.json());
//app.user(session({secret: 'ssshhhhh'}));

//session
//var sess;


connection.connect(function(err) {
if(!err) {
console.log("Mysql Database is connected.");
} else {

   console.log("Error connecting database.");
}
});


//
app.get("/", function(req, res) {

//sess = req.session;

//query the database
connection.query('select * from User_Accounts', function(err, rows) {

//connection.end();

        if(err){
		console.error(err);
		return;
	}
        console.log('Connection established from query.js.');
	var JsonRows = "";

        for (var i = 0; i < rows.length; i++) {

        console.log(rows[i].First_Name);
        JsonRows += JSON.stringify(rows[i].First_Name);


        }

        //give this Json string of cities to the Android app
        res.json(JsonRows);



   });


   //pass control to the next handler
  // next();



});



app.get("/Signup", function(req, res) {

//query the database
connection.query('select * from User_Accounts', function(err, rows) {


        if(err){
		console.error(err);
		return;
	}
        console.log('Connection established from query.js.');
	var JsonRows = "";

        for (var i = 0; i < rows.length; i++) {

        console.log(rows[i].City);
        JsonRows += JSON.stringify(rows[i].UserName);
        JsonRows += JSON.stringify(rows[i].Email);
        JsonRows += JSON.stringify(rows[i].Password);

        }

        //give this Json string of cities to the Android app
        res.json(JsonRows);



   });

});

app.post("/Signup", function(req, res) {

//verify username and email do not already
//exist and if so, add this new account to
//database
var email = req.body.email;
var username = req.body.username;
var password = req.body.password;
console.log("Email: " + email + "\nUsername: " + username + "\nPassword: " + password);

var valid = true;

//query the database
connection.query('select Email, UserName from User_Accounts', function(err, rows) {


        if(err){
		console.error(err);
		return;
	}
        //console.log('Connection established from query.js.');
	var JsonRows = "";



    for (var i = 0; i < rows.length; i++) {

				console.log(email);
				console.log(rows[i].UserName);
        console.log(rows[i].Email);

				if (email == rows[i].Email) {

            valid = false;
						console.log("invalid email." + valid);


	    	}
    }



		//insert into the database this new account if the email is unique
		if (valid == true) {
			var post = {UserName: username, Email: email, Password: password};
			connection.query('INSERT INTO User_Accounts SET ?', post, function(error) {

				if (error) {
					console.log(error.message);
				} else {
					console.log('success');
				}

				return;

			});

		}

   console.log("Final say: " + valid);
   res.json(valid);


   });









});




app.get("/Login", function(req, res) {

//verify credentials and issue cookie


});



app.post("/Login", function(req, res) {

//verify credentials and issue cookie
//verify username and email do not already
//exist and if so, add this new account to
//database
var email = req.body.email;
var password = req.body.password;
console.log("Email: " + email + "\nPassword: " + password);

//assume it's false
var verify = "IncorrectEmail";

//query the database
connection.query('select Email from User_Accounts', function(err, rows) {


        if(err){
		console.error(err);
		return;
	}
        //console.log('Connection established from query.js.');
	var JsonRows = "";



    for (var i = 0; i < rows.length; i++) {

        console.log(rows[i].Email);

				if (email == rows[i].Email) {

            verify = "CorrectEmail";
						console.log("valid email." + verify);


	    	}
    }



		//insert into the database this new account if the email is unique
		if (verify == "CorrectEmail") {

			connection.query('Select Password from User_Accounts where Email=' +  '"' + email + '"', function(error, row) {

				if (error) {
					console.log(error.message);
				} else {
					console.log('success');
				}

				if (password == row[0].Password) {

					verify = "CorrectPassword";
					console.log("This is a valid password.");

				}


				console.log("Final say:" + verify);
		    res.json(verify);


				return;

			});

		}

		else {

			console.log("Final say:" + verify);
			res.json(verify);


		}




   });










});



app.get("/Logout", function(req, res) {

//Tell the database that user is logged out
//and go to homepage


});


app.get("/user/:id", function(req, res) {

//var userId = req.params.id;


//load user and return JSON


});




//create a nodejs server on port 8080
app.listen(port);
console.log('Server running on this port: ' + port);
