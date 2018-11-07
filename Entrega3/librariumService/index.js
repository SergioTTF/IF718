let http = require('http')
let express = require('express')
let path = require('path')
let bodyparser = require('body-parser')

let app = express()
app.use(bodyparser.json())
app.use(
    bodyparser.urlencoded({
        extended: true
    })
)

let port = process.env.port || 8080
app.use(express.static(__dirname + '/web'))

let server = app.listen(port, () => {
    console.log('App running on port ' + server.address().port + '!');
    console.log('Press Ctrl+C to quit');
});