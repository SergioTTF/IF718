let http = require('http')
let express = require('express')
let path = require('path')
let bodyparser = require('body-parser')
let mongoose = require('mongoose')

mongoose.Promise = global.Promise

// mongoose.connect('mongodb://localhost/msgdb')

let app = express()
app.use(bodyparser.json())
app.use(
    bodyparser.urlencoded({
        extended: true
    })
)

let port = process.env.port || 8080
app.use(express.static(__dirname + '/web'))

app.get('/', function(req, res) {
    res.json({ hello: 'world' })
})

let server = app.listen(port, () => {
    console.log('App running on port ' + server.address().port + '!')
    console.log('Press Ctrl+C to quit')
})
