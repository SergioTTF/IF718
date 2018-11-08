const Customer = require('../models/customerModel')

app.post('/customers', (req, res) => {
    let customerData = req.body.customerData
    customerController.createCustomer(customerData, {
        accept(c) {
            res.status(201).json(c)
        },
        error(e) {
            res.status(e.httpStatus).json(e.data)
        }
    })
})

app.get('/customers', function(req, res) {
    customerController.getAll({
        accept(c) {
            res.status(200).json(c)
        },
        error(e) {
            res.status(e.httpStatus).json(e.data)
        }
    })
})

app.post('/customers/:customerId/update', (req, res) => {
    let customerData = req.body.customerData
    let customerId = req.params.customerId
    Customer.findById(customerId, function(err, customer) {
        if (err || customer == null) {
            let e = productErrors['noProductForId']
            res.status(e.httpStatus).json(e.data)
        } else {
            customerController.updateCustomer(customer, customerData, {
                accept(c) {
                    res.status(201).json(c)
                },
                error(e) {
                    res.status(e.httpStatus).json(e.data)
                }
            })
        }
    })
})
