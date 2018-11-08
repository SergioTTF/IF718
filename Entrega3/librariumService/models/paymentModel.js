var mongoose = require('mongoose')
var Schema = mongoose.Schema

var schema = new mongoose.Schema({
    valor: Number,
    data: Date,
    customerId: {
        type: Schema.Types.ObjectId,
        ref: 'Customer',
        required: true
    }
})

module.exports = mongoose.model('Payment', schema)
