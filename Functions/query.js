var mysql = require('mysql');

var connection = mysql.createConnection({
	host: 'localhost',	//This should hold the IP of the database once we have it
	user: 'josecanizares',
	password: 'Arte!!Mundi17',	//Replace [PASSWORD] with the database password
	database: 'CryptoDatabase'	//Replace [DATABASE] with the database name
});

connection.connect();

//For the below statement, replace the bracketted elements with their corresponding element
connection.query('select City from User_Accounts', function(err, result) {
	if(err){
		console.error(err);
		return;
	}
	console.error(result);
});

connection.end();
