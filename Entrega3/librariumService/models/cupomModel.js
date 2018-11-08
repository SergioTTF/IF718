var mongoose = require('mongoose')

var schema = new mongoose.Schema({
    code: {
        type: 'string',
        unique: true,
        required: true
    },
    value: {
        type: Number,
        required: true
    }
})

module.exports = mongoose.model('Cupom', schema)
