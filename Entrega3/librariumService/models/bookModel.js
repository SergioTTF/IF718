var mongoose = require('mongoose')

var schema = new mongoose.Schema({
    preco: Number,
    titulo: {
        type: 'string',
        required: true
    },
    editora: {
        type: 'string',
        required: true
    },
    autor: {
        type: 'string',
        required: true
    },
    genero: {
        type: 'string',
        required: true
    },
    descricao: {
        type: 'string',
        required: true
    }
})

module.exports = mongoose.model('Book', schema)
