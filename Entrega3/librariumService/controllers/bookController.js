const book = require('../models/bookModel')
const bookErrors = require('../errors/bookErrors.json')

exports.getAll = async function(callback) {
    await book.find(function(err, books) {
        if (err) {
            callback.error(bookErrors['nobookForId'])
        } else {
            callback.accept(books)
        }
    })
}
