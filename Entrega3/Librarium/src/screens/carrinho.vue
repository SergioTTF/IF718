<template>
    <div>
        <div class="sidebar">
            <div class="sidebarTitle">
                <!--if book is removed from cart, how to send it back to main screen?-->
                <router-link class="linkSidebar" :to="{ name: 'HomeClient', params: {clienteLogado: this.clienteLogado}}">
                    <u>Olá, {{clienteLogado.name}}!</u>
                </router-link>
            </div>
            <div class="sidebarOptionsContainer">
                <!-- esse "to" faz a navegacao pro 'name', que ta no router/index.js-->
                <router-link class="linkSidebar" :to="{ name: 'ProfileClient', params: {clienteLogado: this.clienteLogado, livrosCarrinho: this.livros}}">
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
            <router-link class="linkSidebar" :to="{ name: '', link:''}">
                <div class="carrinhoContainer">
                    <ion-icon class="cartIconMenu" name="cart"></ion-icon>                    
                        <div class="cartText">
                            Meu Carrinho ({{this.livros.length}})
                        </div>                    
                </div>
            </router-link>
        </div>

        <div class="conteudoCarrinho">
            <ion-icon class="cartIcon" name="cart"></ion-icon>
            <br/>
            <br/>
            <br/>
            
            <div class="itens" v-for="(book, index) in livros" :key="index">
                <div class="itemCarrinho"> 
                    <p class="nomeItem">{{book.titulo}}</p>
                    <ion-icon class="excluirItem" name="trash" v-on:click="remFromCart(index)"></ion-icon>
                    <p class="valorItem">R$ {{book.preco}}</p>
                </div>            
            </div>

            <div class="total">
                <b><p class="nomeTotal">Total:</p></b>
                <b><p class="valorTotal">R$ {{this.calculateCartTotal()}}</p></b>
            </div>

            <div class="cupom">
                <input id="cupomInput" type="text" placeholder="Inserir Cupom">
                <button class="buttonCadastro" v-on:click="validarCupom()">Ok!</button>

                <router-link :to="{ name: 'Pagamento', params: {clienteLogado: this.clienteLogado, livros: this.livros, total: this.totalCarrinho}}">
                    <button id="prosseguir" class="buttonLogin">Prosseguir Compra</button>
                </router-link>
            </div>
            
        </div>
    </div>
    
</template>
''
<script> 
import {cupomValidate} from '../requests.js'
    export default {        
        data: function () {
            return {
                livros: this.$route.params.livrosCarrinho,
                clienteLogado: this.$route.params.clienteLogado,
                hasCupom: false,
                totalCarrinho: 0.0,
            };

        },
        methods: {
            remFromCart: function(index) {
                this.livros.splice(index, 1);
                console.log("removeu: " + this.livros[index].titulo);
            },
            calculateCartTotal: function() {
                var total = 0;
                if(!this.hasCupom){
                    for(var i = 0; i < this.livros.length; i++){
                        total += this.livros[i].preco;
                    }
                    this.totalCarrinho = total;
                    return total;
                } else {
                    return this.totalCarrinho;
                }               
            },
            validarCupom: async function() {
                var cupomString = document.getElementById("cupomInput").value;
                console.log("Validando " + cupomString);

                try{
                    var data = {
                        cupom: cupomString
                    }
                    var cupomComponent = await cupomValidate(data);
                    var cupomRetornado = cupomComponent.data;

                    console.log("pegou: ");
                    console.log(cupomRetornado);

                    if(cupomRetornado != null){
                        if(cupomRetornado[0].code == cupomString){
                            var desconto = cupomRetornado[0].value;
                            this.atualizarTotalCarrinho(desconto);
                        }
                    }
                } catch (e){
                    console.log(e);
                    console.log("deu erro filhote");
                }
            },
            atualizarTotalCarrinho: function(desconto) {
                console.log(desconto);
                console.log(100-desconto);
                console.log(((100-desconto)/100));
                this.hasCupom = true;
                console.log(this.totalCarrinho);
                this.totalCarrinho = this.totalCarrinho * ((100-desconto)/100);
                console.log(this.totalCarrinho);
            }
        },
        created() {
                //this.id = this.$route.params.id;
                //calculateCartTotal();
        },
        
    }
</script>

<style scoped>

* {
    box-sizing: border-box;
}

/* Style the side navigation */
    html, body{
        margin: 0;
        padding: 0;
    }

    .cartText{
        color: #4F4F4F;
        font-size: 25px;
        margin: 15px;
        float: right;
    }

    .cartIconMenu {
        color: #4F4F4F;
        margin-top: 10px;
        font-size: 40px;
    }

    .cartIcon {
        color: #27AE60;
        margin: 10px;
        float: left;
        font-size: 30px;
    }

    .carrinhoContainer {
        float: right;
        margin-top: 5px;
    }

    .cupom {
        margin-left: 65px;
        float: left;
    }

    #prosseguir {
        margin-left: 39px;
    }

    .cupom input{
        width: 120px;
    }

    .total p{
        float: left;
        margin-right: 20px;
    }

    .nomeTotal {
        margin-top: 20px;
        margin-bottom: 20px;
        margin-left: 310px;
    }

    .valorTotal {
        margin-top: 15px;
        font-size: 20px;
        color: #27AE60;
    }

    .header {
        width: 80%;
        height: 5em;
        margin-left: 20%;
        background-color: #F2F2F2;
    }
    .sidebarTitle{
        color: #ffffff;
        font-size: 20px;
        padding-top: 20px;
        padding-bottom: 10px;
    }
  
    .linkSidebar {
        color: #ffffff;
        font-size: 20px;
    }
    .sidebar{
        width: 20%;
        height: 100%;
        position: fixed;
        background-color: #2F80ED;
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
        border: 1px solid #F2994A;
        -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
    }

    .buttonCadastro:active {
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

    .conteudoCarrinho {
        margin:20px;
        margin-left: 25%;
        width: 50%;
        height: 390px;
        border: 2px solid;
        border-color: #27AE60;  
        border-radius: 15px;
    }

    .itens {
        display: block;
        margin-left: 60px;
    }

    .itemCarrinho {
        width: 400px;
        height: 50px;
        background-color: #F2F2F2;
        border-radius: 100px;
        margin: 10px;
    }

    .excluirItem {
        color:crimson;
        float:right;
        margin: 14px;  
        font-size: 20px; 
    }

    .itemCarrinho p {
        margin: 14px;
    }

    .nomeItem {
        margin: 20px;
        float:left;
    }

    .valorItem {
        color: #27AE60;
        float:right;
    }
</style>