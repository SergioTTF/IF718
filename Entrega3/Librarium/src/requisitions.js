import axios from 'axios'

var baseUrl = 'https://6e0538f6.ngrok.io'

export const fetchBooks = async function() {
    let livros = null;
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

export const cadastrarCliente = async function(id, data) {
    await axios.post(baseUrl + '/customers' + id + '/update', data)
    .then(res => {
        console.log("deu update");
    })
    .catch(err => {
        console.log("Err: ", err)
    })
}