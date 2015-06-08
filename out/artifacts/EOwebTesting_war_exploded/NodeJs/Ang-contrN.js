/**
 * Created by oussama.elbouzi on 06/06/2015.
 */
var express  = require('express');
var app      = express();


app.use('/js',express.static(__dirname+'/js'));
app.use('/lib',express.static(__dirname+'/lib/angular-1.3.15'));
app.get('/',function(req, res){
    res.sendfile(__dirname+'/login.html')
});
app.listen(1099);