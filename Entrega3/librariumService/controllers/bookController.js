const book = require('../models/bookModel')
const bookErrors = require('../errors/bookErrors.json')
// const version = require('../package.json').version

exports.getAll = async function(callback) {
    await book.find(function(err, books) {
        if (err) {
            callback.error(bookErrors['nobookForId'])
        } else {
            callback.accept(books)
        }
    })
}

// exports.createBook = async function(bookData, callback) {
//     if (bookData) {
//         bookData.version = version
//         await book.create(bookData, function(e, c) {
//             if (e) {
//                 callback.error(bookErrors.failedCreation)
//             } else {
//                 callback.accept(c)
//             }
//         })
//     } else {
//         callback.error(bookErrors.invalidData)
//     }
// }