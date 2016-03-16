var express = require('express');


var obj = require("/Users/josecanizares/Desktop/Android/CryptoGear/dummy.json");
var body = JSON.stringify({
    foo: "bar"
});


var bodyParser = require('body-parser');

var app = express();

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');


app.use(require('json-middleware').middleware());


app.use(bodyParser.json());


app.get('/', function(req, res) {

//
//res.render('/Users/josecanizares/Desktop/Node/index.ejs');

res.json(body);

});



app.post('*', function (request, response) {
    console.log(request);
    response.send("200");
});


//create a nodejs server on 8088
app.listen(8000, function () {
    console.log("Started on PORT 8000");
})
