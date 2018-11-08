const Customer = require('../models/customerModel')
const Book = require('../models/bookModel')
const Cupom = require('../models/cupomModel')

app.post('/cupom', (req, res) => {
    cartController.cupomValidate(req.body.cupom, {
        accept(c) {
            res.status(200).json(c)
        },
        error(e) {
            res.status(e.httpStatus).json(e.data)
        }
    })
})

app.post('/payment', (req, res) => {
    let pay = {
        customer: req.body.customerId,
        card: req.body.card,
        value: req.body.value
    }
    cartController.payment(pay, {
        accept(c) {
            res.status(200).json(c)
        },
        error(e) {
            res.status(e.httpStatus).json(e.data)
        }
    })
})

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
