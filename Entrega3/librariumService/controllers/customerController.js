const Customer = require('../models/customerModel')

const customerErrors = require('../errors/customerErrors.json')

const version = require('../package.json').version

exports.createCustomer = async function(customerData, callback) {
    if (customerData) {
        if (
            customerData.email &&
            customerData.password &&
            customerData.name &&
            customerData.address &&
            customerData.creditCard
        ) {
            customerData.version = version
            Customer.create(customerData, function(e, c) {
                if (e) {
                    callback.error(customerErrors.failedCreation)
                } else {
                    callback.accept(c)
                }
            })
        } else {
            callback.error(customerErrors.invalidData)
        }
    } else {
        callback.error(customerErrors.invalidData)
    }
}

exports.getAll = async function(callback) {
    Customer.find(function(err, customers) {
        if (err) {
            callback.error(customerErrors['noCustomerForId'])
        } else {
            callback.accept(customers)
        }
    })
}
