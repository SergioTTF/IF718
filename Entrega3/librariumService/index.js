let http = require('http')
let express = require('express')
let glob = require('glob'),
    path = require('path')
let bodyparser = require('body-parser')
let mongoose = require('mongoose')
var { envconfig } = require('./config')

mongoose.Promise = global.Promise
mongoose = mongoose.connect(
    envconfig.mongo.address,
    {
        useMongoClient: true
    }
)

customerController = require('./controllers/customerController')
bookController = require('./controllers/bookController')
cartController = require('./controllers/cartController')

app = express()
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

glob.sync('./routes/*.js').forEach(file => require(path.resolve(file)))

let server = app.listen(port, () => {
    console.log('App running on port ' + server.address().port + '!')
    console.log('Press Ctrl+C to quit')
})
