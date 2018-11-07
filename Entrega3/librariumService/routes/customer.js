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
