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

app.post('/cupom/create', (req, res) => {
    let cupomData = req.body.cupom
    createCupom(cupomData, {
        accept(c) {
            res.status(201).json(c)
        },
        error(e) {
            res.status(e.httpStatus).json(e.data)
        }
    })
})

const createCupom = async function(cupomData, callback) {
    await Cupom.create(cupomData, function(e, c) {
        callback.accept(c)
    })
}

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

// app.post('/books', (req, res) => {
//     let bookData = req.body.book
//     bookController.createBook(bookData, {
//         accept(c) {
//             res.status(200).json(c)
//         },
//         error(e) {
//             res.status(e.httpStatus).json(e.data)
//         }
//     })
// })