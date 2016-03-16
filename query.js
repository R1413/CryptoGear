var express = require("express");
var mysql = require('mysql');
//this also uses json middleware (when i use stringify)


//First you need to create a connection to the database
var connection = mysql.createConnection({
	host: 'localhost',	//This should hold the IP of the database once we have it
	user: 'josecanizares',
	password: 'PASSWORD',	//Replace [PASSWORD] with the database password
	database: 'CryptoDatabase'	//Replace [DATABASE] with the database name
});


var app = express();


connection.connect(function(err) {
if(!err) {
console.log("Mysql Database is connected.");
} else {

   console.log("Error connecting database.");
}
});


//
app.get("/", function(req, res) {

//query the database
connection.query('select * from User_Accounts', function(err, rows) {

connection.end();

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



app.get("/Cities", function(req, res) {

//query the database
connection.query('select * from User_Accounts', function(err, rows) {

connection.end();

        if(err){
		console.error(err);
		return;
	}
        console.log('Connection established from query.js.');
	var JsonRows = "";

        for (var i = 0; i < rows.length; i++) {

        console.log(rows[i].City);
        JsonRows += JSON.stringify(rows[i].City);
        

        }
       
        //give this Json string of cities to the Android app
        res.json(JsonRows);
        


   });

});


//app.post('/', function (req, res) {

  //  res.send('POST request');

//}




//create a nodejs server on port 8080
app.listen(8080);
