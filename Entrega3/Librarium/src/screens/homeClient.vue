<template>
    <div>
        <div class="sidebar">
            <div class="sidebarTitle">
                <u>Olá, {{clienteLogado.name}}!</u>
            </div>
            <div class="sidebarOptionsContainer">
                <!-- esse "to" faz a navegacao pro 'name', que ta no router/index.js-->
                <router-link class="linkSidebar" :to="{ name: 'ProfileClient', params: {clienteLogado: this.clienteLogado, livrosCarrinho: this.livrosCart}}">
                    <div class="sidebarOption">
                        Meu Perfil
                    </div>
                </router-link>
                <router-link class="linkSidebar" :to="{ name: '', link:''}">
                    <div class="sidebarOption">
                        Minhas Compras
                    </div>    
                </router-link>                
            </div>
        </div>

        <div class="header">
            <router-link class="linkSidebar" :to="{ name: 'Carrinho', link:'', params: { clienteLogado: this.clienteLogado, livrosCarrinho: this.livrosCart}}">
                <div class="carrinhoContainer">
                    <ion-icon class="cartIcon" name="cart"></ion-icon>                    
                    <div class="cartText">
                        Meu Carrinho ({{this.livrosCart.length}})
                    </div>                    
                </div>
            </router-link>
        </div>

        <div class="bookListContainer">
            <div class="bookContainer" v-for="(book, index) in livros" :key="index">
                <div class="priceAndCartIcon">
                    <span v-on:click="addToCart(index)" v-bind:id=index class="dot">
                        <img class="addCartIcon" width="40px" height="48px" src="../assets/addCartIcon.png"/>
                    </span>                      
                </div>
                <div class="bookTextContainer">
                    <div class="bookTitle">
                        {{book.titulo}}
                    </div>     
                    <div class="bookDetails">
                        {{book.autor}}
                    </div>  
                    <div class="bookDetails">
                        {{book.editora}}
                    </div>

                    <div class="bookPrice">
                        R$ {{book.preco}}
                    </div>
                </div>              
            </div>            
        </div>

        <h1 v-if="livros.length == 0" class="noBookWarn">Não há livros na vitrine... ;-;</h1>

    </div>    
</template>

<script> 
import {fetchBooks} from '../requests.js'
    var livros1 = [];
    export default {
        data: function () {
            return {
                clienteLogado: this.$route.params.clienteLogado,
                
                livros: [
                    {
                        titulo: 'Harry Potter e o Ladrão de Raios',
                        autor: 'J. K. Riordan',
                        editora: 'Rocco',
                        preco: 25,
                    },
                    {
                        titulo: 'Crime e Preconceito',
                        autor: 'Fiódor Austen',
                        editora: 'leya',
                        preco: 45,
                    },
                    {
                        titulo: 'Deuses sob a Redoma',
                        autor: 'Stephen Gaiman',
                        editora: 'intriseca',
                        preco: 30,
                    },
                    {
                        titulo: 'Assassinato no Mundo Novo',
                        autor: 'Agatha Huxley',
                        editora: 'leya',
                        preco: 40,
                    },
                                
                ],
                //array that will be passed to cartScreen upon navigation
                //how to remove the book added to the cart? (maybe just remove from livros[]?)
                livrosCart: [],
                
            };
        },
        mounted() {

        },
        methods: {
            addToCart: function(index){
                //console.log("eae");
                var livroAdd = this.livros[index];
                //console.log(livroAdd);
                this.livrosCart.push(livroAdd);
            },
            updateVitrine: function(){
                //uncomment when server is working
                //this.livros = livros1;
            },
            fetchBooks: async function(){
                let livrosReq = await fetchBooks();
                livros1 = livrosReq.data;
                console.log("livros: " + livrosReq);
                this.updateVitrine();                                
            }
        },
        async created() {
            //this.id = this.$route.params.id;

            await this.fetchBooks();
        },        
    }
</script>

<style scoped>
    .noBookWarn{
        margin-top: 4em;
    }
    .bookPrice {
        color: #27AE60;
        font-size: 150%;
        font-weight: bold;
        display: flex;
        justify-content: flex-end;
    }
    .priceAndCartIcon{
        float: right;
    }
    .addCartIcon{
        width: 40px;
        height: 50px;
        margin-right: 10%;
        margin-top: 10%;        
    }
    .dot {
        height: 60px;
        width: 60px;
        background-color: #27AE60;
        border-radius: 50%;
        display: inline-block;
    }
    .bookTextContainer{
        
    }
    .bookDetails {
        color: #4F4F4F;
        width: fit-content;
        margin: 5px;
    }
    .bookTitle {
        color: #000000;
        font-size: 150%;
        width: fit-content;
        margin: 5px;
    }
    .bookContainer {
        margin-top: 10px;
        border-radius: 25px;
        background-color: #F2F2F2;
        padding: 10px;
        text-align: center;
    }
    .bookListContainer {
        color: #ffffff;
        margin-left: 20%;
        padding-left: 5%;
        padding-right: 5%;
    }
    .arrange-horizontally > * {
        display: inline-block;
        text-align: center;
    }
    .arrange-vertically > * {
        display: block;
    }
    .cartText {
        color: #4F4F4F;
        font-size: 25px;
        margin: 15px;
        float: right;
    }
    .cartIcon {
        color: #4F4F4F;
        margin-top: 10px;
        font-size: 40px;
    }
    .carrinhoContainer {
        float: right;
        margin-top: 5px;
    }
    .header {
        background-color: #F2F2F2;
        width: 100%;
        height: 5em;
    }
    .sidebarTitle{
        color: #ffffff;
        font-size: 20px;
        padding-top: 20px;
        padding-bottom: 10px;
    }
    .sidebarOptionsContainer{

    }
    .sidebarOption{

    }
    .linkSidebar {
        color: #ffffff;
        font-size: 20px;
    }
    .sidebar{
        width: 20%;
        background-color: #2F80ED;
        height: 100em;
        float: left;        
    }
    .image {
        float: left;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
        border: 1px solid #ebebeb;
        margin: 5px;
    }
    .versionString{
        color: #4F4F4F;
    }
    .containerr{
        display: flex; /* or inline-flex */
        flex-direction: row;
        flex-wrap: wrap;
        margin-top: 1em;
        justify-content: center;
    }
    .loginBackground {
        background-color: #2F80ED;
        border-radius: 25px;   
        padding-right: 50px;
        padding-left: 50px;
    }
    .loginTitle {
        color: #ffffff;
        font-size: 30px;
        font-weight: 100;
        margin: 40px;      
    }
    .inputText {
        color: #ffffff;
        font-size: 20px;
        font-weight: 50;   
        float: left;         
    }
    .inputContainer {
        margin: 20px;
    }
    .textInputBox{
        background-color: #ffffff;
    }
    .botoes{
        margin: 20px;
    }
    .botaoCadastro{
        background-color: #F2994A;
    }
    .buttonCadastro {
        display: inline-block;
        -webkit-box-sizing: content-box;
        -moz-box-sizing: content-box;
        box-sizing: content-box;
        cursor: pointer;
        padding: 10px 20px;
        border: 1px solid #F2994A;
        -webkit-border-radius: 3px;
        border-radius: 3px;
        font: normal medium/normal Arial, Helvetica, sans-serif;
        color: rgba(255,255,255,0.9);
        -o-text-overflow: clip;
        text-overflow: clip;
        background: #F2994A;
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        text-shadow: -1px -1px 0 #D98B45 ;
        -webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonCadastro:hover {
        border: 1px solid #F2994A;
        background: #F2994A;
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
    }

    .buttonCadastro:active {
        border: 1px solid #F2994A;
        background: #F2994A;
        -webkit-box-shadow: 0 1px 4px 0 rgba(0,0,0,0.2) inset;
        box-shadow: 0 1px 4px 0 rgba(0,0,0,0.2) inset;
        text-shadow: none;
        -webkit-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonLogin {
        display: inline-block;
        -webkit-box-sizing: content-box;
        -moz-box-sizing: content-box;
        box-sizing: content-box;
        cursor: pointer;
        padding: 10px 20px;
        border: 1px solid #018dc4;
        -webkit-border-radius: 3px;
        border-radius: 3px;
        font: normal medium/normal Arial, Helvetica, sans-serif;
        color: rgba(255,255,255,0.9);
        -o-text-overflow: clip;
        text-overflow: clip;
        background: #27AE60;
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        text-shadow: -1px -1px 0 #219653 ;
        -webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonLogin:hover {
        border: 1px solid#27AE60;
        background: #27AE60;
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
    }

    .buttonLogin:active {
        border: 1px solid #27AE60;
        background:#27AE60;
        -webkit-box-shadow: 0 1px 4px 0 rgba(0,0,0,0.2) inset;
        box-shadow: 0 1px 4px 0 rgba(0,0,0,0.2) inset;
        text-shadow: none;
        -webkit-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    h2{
        font-family: AvenirNext;
        font-weight: 600;
        font-size: 2.3em;
    }
</style>
