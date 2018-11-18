<template>
    <div>
        <div class="sidebar">
        	<router-link class="linkSidebar" :to="{ name: '', link:''}">
            	<div class="sidebarTitle">
                	Olá, {{clienteLogado.nome}}!
            	</div>
            </router-link>
            <div class="sidebarOptionsContainer">
                <!-- esse "to" faz a navegacao pro 'name', que ta no router/index.js-->
                    <div class="sidebarOption">
                        <u>Meu Perfil</u>
                    </div>
                <router-link class="linkSidebar" :to="{ name: '', link:''}">
                    <div class="sidebarOption">
                        Minhas Compras
                    </div>    
                </router-link>                
            </div>
        </div>

        <div class="header">
            <router-link class="linkSidebar" :to="{ name: '', link:'', params: { livrosCarrinho: this.livrosCart}}">
                <div class="carrinhoContainer">
                    <ion-icon class="cartIcon" name="cart"></ion-icon>                    
                    <div class="cartText">
                        Meu Carrinho ({{this.livrosCart.length}})
                    </div>                    
                </div>
            </router-link>
        </div>

        <div class="profileDiv">
        	<span class="divText">
        		Usuário
        	</span>
        </div>
        
        <div class="profileData">
            
            <input type="text" id="nome" name="nome" placeholder="nome" :value="this.clienteLogado.name" :readonly="lock">
            
        	<input type="text" id="email" name="email" placeholder="email" value="dvb2@cin.ufpe.br" :readonly="lock">
            
    		<input type="password" id="senha" placeholder="senha" name="senha" value="admin" :readonly="lock">
           
    		<input type="text" id="rua" placeholder="rua" name="rua" value="Av. Nova Guiné" :readonly="lock">
            
        	<input type="text" id="numero" placeholder="numero" name="numero" value="324" :readonly="lock">
            
    		<input type="text" id="complemento" placeholder="complemento" name="complemento" value="apto 201" :readonly="lock">
            
    		<input type="text" id="cep" placeholder="cep" name="cep" value="54.410-021" :readonly="lock">
            
    		<input type="text" id="estado" placeholder = "estado" name="estado" value="PE" :readonly="lock">
    		<input type="text" id="cidade" placeholder="cidade" name="cidade" value="Recife" :readonly="lock">
            
            <button class="buttonEdit" v-on:click="editInformation">{{buttonText}}</button> 
        </div>

        <div class="profileDiv">
        	<span class="divText">
        		Cartões
        	</span>
        </div>

        <div class="cardDiv">
            <div v-for="(card, index) in cards" :key="index" class="cardElement">
                <h5>XXXX XXXX XXXX 1324</h5><br>
                <h6>05/20</h6>
                <ion-icon class="delete" name="trash" @click="deleteCard"></ion-icon>
            </div>
            <button class="buttonEdit">Cadastrar Novo Cartão</button>
        </div>


    </div>    
</template>

<script> 
import {updateCliente} from '../requests.js'
    export default {
        data: function() {
            return {
                clienteLogado: this.$route.params.clienteLogado,
                livrosCart: [
                    {
                        titulo: "eae"
                    }
                ],
                url: "../../assets/trash.png",
                lock: true,
                buttonText: "Editar informações",
                cards: [1,2]
            }
        },
        methods: {
            editInformation: function () {
                //(aqui, o botao esta como "salvar" e o usuario clicou nele)
                if(!this.lock) {
                    //dar update no usuario
                    //this.updateCliente(this.clienteLogado._id, this.clienteLogado);
                    console.log("atualizou hein");
                    this.editAllClientData();
                }

                if (this.lock) {
                    this.lock = false;
                    this.buttonText = "Salvar";
                } else {
                    this.lock = true;
                    this.buttonText = "Editar informações";
                }                
            },
            deleteCard: function (index) {
                this.cards.splice(index, 1);
            },
            editAllClientData: async function() {
                this.clienteLogado.name = document.getElementById("nome").value;
                this.clienteLogado.email = document.getElementById("email").value;
                this.clienteLogado.password = document.getElementById("senha").value;
                
                this.clienteLogado.address.rua = document.getElementById("rua").value;
                this.clienteLogado.address.numero = document.getElementById("numero").value;
                this.clienteLogado.address.complemento = document.getElementById("complemento").value;
                this.clienteLogado.address.CEP = document.getElementById("cep").value;
                this.clienteLogado.address.estado = document.getElementById("estado").value;
                this.clienteLogado.address.cidade = document.getElementById("cidade").value;
                
                console.log("atualizou:");
                await updateCliente(this.clienteLogado._id, this.clienteLogado);
            }
        },
        created() {
                //this.clienteLogado = this.$route.params.clienteLogado;
                //this.livrosCart = this.$route.params.livrosCart;
        },       
    }
</script>

<style scoped>
    .cardElement {
        margin: 20px auto 20px auto;
        padding: 15px;
        width: 65%;
        background-color: #F8F8F8;
        border-radius: 20px;
    }
    .cardElement h5,h6 {
        display: inline-block;
    }
    .delete {
        float: right;
        width: 40px;
        height: 40px;
        color: #EB5757;
    }
    .cardDiv {
        text-align: center;
        margin-left: 25%;
        margin-top: 20px;
    }
    .profileData input {
        width: 30%;
        margin: 10px;
    }
    .buttonEdit {
        margin-top: 10px;
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
        background: #0199d9;
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        text-shadow: -1px -1px 0 rgba(15,73,168,0.66) ;
        -webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonEdit:hover {
        border: 1px solid #007cad;
        background: rgba(0,142,198,1);
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonEdit:active {
        border: 1px solid #018dc4;
        background: #00a6e8;
        -webkit-box-shadow: 0 1px 4px 0 rgba(0,0,0,0.2) inset;
        box-shadow: 0 1px 4px 0 rgba(0,0,0,0.2) inset;
        text-shadow: none;
        -webkit-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 50ms cubic-bezier(0.42, 0, 0.58, 1);
    }
	.profileData{
		margin-left: 25%;
        margin-top: 10px;

	}
	.divText{
		background-color: #FFF;
		padding: 0 10px;
	}
	.profileDiv{
		margin: 15px;
		font-weight: bold;
		width: 100%;
		height: 20px;
		border-bottom: 1px solid black;
		text-align: left;
	}
    .cartText{
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
    	color: #ffffff;
        font-size: 20px;
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
   
</style>
