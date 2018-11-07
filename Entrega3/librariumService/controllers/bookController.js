const book = require('../models/bookModel')
const bookErrors = require('../errors/bookErrors.json')
const version = require('../package.json').version

exports.getAll = async function(callback) {
    book.find(function(err, books) {
        if (err) {
            callback.error(bookErrors['nobookForId'])
        } else {
            callback.accept(books)
        }
    })
}
