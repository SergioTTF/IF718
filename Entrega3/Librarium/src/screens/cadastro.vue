<template>
    <div>
        <div class="col s6 containerr">
            <div class="loginBackground">
                <div class="cadastroNavBar">
                    <router-link :to="{ name: 'Login', link:''}">
                        <ion-icon name="arrow-round-back" class="backIcon"></ion-icon>
                    </router-link>
                    
                    <div class="cadastroNavBarText">
                        Cadastro
                    </div>
                </div>  
                <b-container fluid>
                    <b-row class="my-1" v-for="type in types" :key="type">
                        <b-col sm="3"><label class="inputText" :for="`type-${type}`"> {{ type.tag }}:</label></b-col>
                        <b-col sm="9"><b-form-input :id="`type-${type}`" :type="type" :value="type.defaultValue"></b-form-input></b-col>
                    </b-row>
                    <div class="textoIntervalo">
                        Endereço
                    </div>
                    <b-row class="my-1" v-for="type in address" :key="type">
                        <b-col sm="3"><label class="inputText" :for="`type-${type}`"> {{ type.tag }}:</label></b-col>
                        <b-col sm="9"><b-form-input :id="`type-${type}`" :type="type" :value="type.defaultValue"></b-form-input></b-col>
                    </b-row>
                    <div class="textoIntervalo">
                        Cartão
                    </div>
                    <b-row class="my-1" v-for="type in card" :key="type">
                        <b-col sm="3"><label class="inputText" :for="`type-${type}`"> {{ type.tag }}:</label></b-col>
                        <b-col sm="9"><b-form-input :id="`type-${type}`" :type="type" :value="type.defaultValue"></b-form-input></b-col>
                    </b-row>
                </b-container>

                <div>
                    <button v-on:click="atualizarInfos" class="buttonCadastro">
                        Cadastrar-se!
                    </button>
                </div>
            </div>
        </div>
    </div>
  
</template>

<script>
    import {cadastrarCliente} from '../requisitions.js'
    
    export default {
        data () {
            return {
                types: [
                    {
                        tag: 'Nome',
                        defaultValue: 'Daniel'
                    },
                    {
                        tag: 'Email',
                        defaultValue: 'dfb2@cin.ufpe.br'
                    },
                    {
                        tag: 'Senha',
                        defaultValue: 'pizza'
                    },
                    {
                        tag: 'Confirmar',
                        defaultValue: 'pizza'
                    }
                ],
                address: [
                    {
                        tag: 'Rua',
                        defaultValue: 'Rua oloco meu'
                    },
                    {
                        tag: 'CEP',
                        defaultValue: '50682-12'
                    },
                    {
                        tag: 'Nº',
                        defaultValue: '12'
                    },
                    {
                        tag: 'Compl',
                        defaultValue: 'Apt. 101'
                    },
                    {
                        tag: 'Cidade',
                        defaultValue: 'Recife'
                    },
                    {
                        tag: 'UF',
                        defaultValue: 'PE'
                    },
                ],
                card: [
                    {
                        tag: 'CPF',
                        defaultValue: '07125325440'
                    },
                    {
                        tag: 'NomeCard',
                        defaultValue: 'DANIEL F BEZERRA'
                    },
                    {
                        tag: 'NumCard',
                        defaultValue: '3330 2220 1110 2220'
                    },
                    {
                        tag: 'Venc',
                        defaultValue: '03/10'
                    },
                    {
                        tag: 'CodSeg',
                        defaultValue: '098'
                    },
                ],
                stateName: '',
                stateEmail: '',
                stateSenha: '',
                stateConfirmar: '',

                stateRua: '',
                stateCEP: '',
                stateNum: '',
                stateComplemento: '',
                stateCidade: '',
                stateUF: '',

                stateCPF: '',
                stateNomeCard: '',
                stateNumCard: '',
                stateVenc: '',
                stateCodSeg: ''
            }
        },
        created: {

        },
        methods: {
            registerClient: async function() {
                var data = {
                    nome: this.stateName,
                    email: this.stateEmail,
                    senha: this.stateSenha,
                    confirmar: this.stateConfirmar,
                    
                    rua: this.stateRua,
                    cep: this.stateCEP,
                    num: this.stateNum,
                    complemento: this.stateComplemento,
                    cidade: this.stateCidade,
                    uf: this.stateUF,

                    cpf: this.stateCPF,
                    nomeCard: this.stateNomeCard,
                    numCard: this.stateNumCard,
                    venc: this.stateVenc,
                    codSeg: this.stateCodSeg
                }
                var id = 0;
                await cadastrarCliente(id, data);
            },

            atualizarInfos: function(){
                this.stateName = document.getElementById('type-Nome').value;
                this.stateEmail = document.getElementById('type-Email').value;
                this.stateSenha = document.getElementById('type-Senha').value;
                this.stateConfirmar = document.getElementById('type-Confirmar').value;

                this.stateRua = document.getElementById('type-Rua').value;
                this.stateCEP = document.getElementById('type-CEP').value;
                this.stateNum = document.getElementById('type-Nº').value;
                this.stateComplemento = document.getElementById('type-Compl').value;
                this.stateCidade = document.getElementById('type-Cidade').value;
                this.stateUF = document.getElementById('type-UF').value;

                this.stateCPF = document.getElementById('type-CPF').value;
                this.stateNomeCard = document.getElementById('type-NomeCard').value;
                this.stateNumCard = document.getElementById('type-NumCard').value;
                this.stateVenc = document.getElementById('type-Venc').value;
                this.stateCodSeg = document.getElementById('type-CodSeg').value;
                console.log(this.stateName);
                console.log(this.stateEmail);
                console.log(this.stateSenha);

                this.registerClient();
            }
        },

        
    }
</script>

<style scoped>
    .image {
        float: left;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
        border: 1px solid #ebebeb;
        margin: 5px;
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
        margin-bottom: 80px;   
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
        background-color:#00a6e8;
    }
    .botoes{
        margin: 40px;
    }
    .botaoCadastro{
        background-color: #F2994A;
    }
    .buttonCadastro {
        float: right;
        margin: 20px;
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
        text-shadow: -1px -1px 0 rgba(15,73,168,0.66) ;
        -webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonCadastro:hover {
        border: 1px solid #27AE60;
        background: #27AE60;
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
    }

    .buttonCadastro:active {
        border: 1px solid #018dc4;
        background: #27AE60;
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
        background: #0199d9;
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.2) ;
        text-shadow: -1px -1px 0 rgba(15,73,168,0.66) ;
        -webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonLogin:hover {
        border: 1px solid #007cad;
        background: rgba(0,142,198,1);
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
    }
    .buttonLogin:active {
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
    .cadastroNavBarText{
        font-size: 30px;
        color: #ffffff;
        margin-top: 10px;
    }
    .cadastroNavBar{
        margin-bottom: 20px;
    }
    .backIcon{
        color: #ffffff;
        float: left;
        margin-top: 15px;
        font-size: 30px;
    }
    .textoIntervalo{
        font-size: 1.6em;
        color: #ffffff;
        margin: 10px;        
    }
    .inputTextField{
        float: right;
    }
    h2{
        font-family: AvenirNext;
        font-size: 2.3em;
    }
</style>
