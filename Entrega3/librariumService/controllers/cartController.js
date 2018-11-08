const book = require('../models/bookModel')
const cupom = require('../models/cupomModel')
// const bookErrors = require('../errors/bookErrors.json')
const version = require('../package.json').version

exports.payment = async function(pay, callback) {}

exports.cupomValidate = async function(cupomCode, callback) {
    cupom.find({ code: cupomCode }, function(err, cupom) {
        if (err || cupom == null) {
            // callback.error(customerErrors['noCustomerForId'])
        } else {
            callback.accept(cupom)
        }
    })
}
