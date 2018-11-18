import axios from 'axios'

var baseUrl = 'https://ef36ff13.ngrok.io'

export const fetchBooks = async function() {
    let livros = null
    await axios.get(baseUrl + '/getBooks')
    .then(res => {
        livros = res
    })
    .catch(err => {
        console.log("Err: ", err)
        livros = err
    })
    return livros
}

export const fetchCustomers = async function() {
    let customers = null
    await axios.get(`${baseUrl}/customers`)
    .then(res => {
        customers = res
    })
    .catch(err => {
        console.log("Err: ", err)
        customers = err
    })
    return customers
}


export const cadastrarCliente = async function(data) {
    await axios.post(baseUrl + '/customers', data)
    .then(res => {
        console.log("deu create");
    })
    .catch(err => {
        console.log("Err: ", err)
    })
}

/**
 * 
 * @param {int} customerId - id do customer que será atualizado, lembrando que só é pegar do customer logado
 * @param {object} data - novo customer
 */
export const updateCliente = async function(customerId, data) {
    await axios.post(`${baseUrl}/customers/${customerId}/update`, data)
    .then(res => {
        console.log("deu update");
    })
    .catch(err => {
        console.log("Err: ", err)
    })
}

/**
 * 
 * @param {string} data - codigo do cupom -> data = { cupom: 'value' }
 */
export const cupomValidate = async function(data) {
    await axios.post(`${baseUrl}/cupom`, data)
    .then(res => {
        console.log("validou cupom");
    })
    .catch(err => {
        console.log("Err: ", err)
    })
}

/**
 * 
 * @param {int} customerId - id do customer logado
 * @param {object} card - objeto cartao que ele escolheu na compra
 * @param {int} value - valor da compra
 */
export const makePayment = async function(customerId, card, value) {
    await axios.post(`${baseUrl}/payment`, {
        customerId,
        card,
        value
    })
    .then(res => {
        console.log("pagou");
    })
    .catch(err => {
        console.log("Err: ", err)
    })
}