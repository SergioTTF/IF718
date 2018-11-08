const cupom = require('../models/cupomModel')
const payment = require('../models/paymentModel')
const cartErrors = require('../errors/cartErrors.json')

const customerController = require('./customerController')

exports.payment = async function(pay, callback) {
    await customerController.getCustomer(pay.customer, {
        accept(c) {
            let paymentCard = {
                valor: pay.value,
                data: new Date(),
                customerId: pay.customer
            }
            payment.create(paymentCard, function(e, p) {
                if (e) {
                    callback.error(e)
                } else {
                    callback.accept({
                        customer: c,
                        payment: p
                    })
                }
            })
        },
        error(e) {
            callback.error(e)
        }
    })
}

exports.cupomValidate = async function(cupomCode, callback) {
    await cupom.find({ code: cupomCode }, function(err, cupom) {
        if (err || cupom == null) {
            callback.error(cartErrors['invalidData'])
        } else {
            callback.accept(cupom)
        }
    })
}
