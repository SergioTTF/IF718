const Customer = require('../models/customerModel')
const Book = require('../models/bookModel')
const Cupom = require('../models/cupomModel')

app.post('/cupom', (req, res) => {})

app.post('/payment', (req, res) => {})

app.get('/getBooks', (req, res) => {
    bookController.getAll({
        accept(c) {
            res.status(200).json(c)
        },
        error(e) {
            res.status(e.httpStatus).json(e.data)
        }
    })
})
