/**
 * Created by oussama.elbouzi on 07/06/2015.
 */
var http = require('http');

var server = http.createServer(function(req,res){
    res.writeHead(200);
    res.end('Salut tout le monde');
});
server.listen(8080);