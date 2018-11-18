const customer = require('../models/customerModel')
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
            await customer.create(customerData, function(e, c) {
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
    await customer.find(function(err, customers) {
        if ((err, customers == null)) {
            callback.error(customerErrors['noCustomerForId'])
        } else {
            callback.accept(customers)
        }
    })
}

exports.getCustomer = async function(customerId, callback) {
    await customer.findById(customerId, function(err, customer) {
        if (err || customer == null) {
            callback.error(customerErrors['noCustomerForId'])
        } else {
            callback.accept(customer)
        }
    })
}

exports.updateCustomer = async function(oldCustomer, newCustomer, callback) {
    if (newCustomer) {
        oldCustomer.email = newCustomer.email
        oldCustomer.password = newCustomer.password
        oldCustomer.name = newCustomer.name
        oldCustomer.address = newCustomer.address
        oldCustomer.creditCard = newCustomer.creditCard
        await oldCustomer.save(function(e) {
            if (e) {
                callback.error(customerErrors['failedUpdate'])
            } else {
                callback.accept(newCustomer)
            }
        })
    } else {
        callback.error(customerErrors['badlyFormedCustomer'])
    }
}
