let http = require('http')
let express = require('express')
let glob = require('glob'),
    path = require('path')
let bodyparser = require('body-parser')
let mongoose = require('mongoose')
var { envconfig } = require('./config')
var cors = require('cors')

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

var corsOptions = {
    origin: (origin, callback) => {
        callback(null, true)
    }
}
app.use(cors(corsOptions))

let port = process.env.port || 8080
app.use(express.static(__dirname + '/web'))

app.get('/', function(req, res) {
    res.end(envconfig.root)
})

glob.sync('./routes/*.js').forEach(file => require(path.resolve(file)))

let server = app.listen(port, () => {
    console.log('App running on port ' + server.address().port + '!')
    console.log('Press Ctrl+C to quit')
})
