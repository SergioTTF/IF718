var mongoose = require('mongoose')

var schema = new mongoose.Schema({
    email: {
        type: 'string',
        unique: true,
        required: true
    },
    password: {
        type: 'string',
        required: true
    },
    name: {
        type: 'string',
        required: true
    },
    address: {
        rua: 'string',
        numero: 'string',
        CEP: 'string',
        complemento: 'string',
        estado: 'string',
        cidade: 'string'
    },
    creditCard: [
        {
            numero: 'string',
            nome: 'string',
            validade: 'string',
            codigoSeguranca: 'string',
            cpf: 'string'
        }
    ]
})

module.exports = mongoose.model('Customer', schema)
