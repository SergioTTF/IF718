<template>
    <div>
        <div class="col s6 containerr">
            <div class="loginBackground">
                <div class="loginTitle">
                    Librarium!
                </div>    
            
                <div class="inputContainer">
                    <div class="inputText">
                        Email
                    </div>                
                    <input class="textInputBox" id="email" v-model="email" placeholder="" @change="updtEmailInput">
                </div>

                <div class="inputContainer">
                    <div class="inputText">
                        Senha
                    </div>                
                    <input class="textInputBox" id="senha" v-model="senha" placeholder="">
                </div>

                <div class="botoes">
                    <button v-on:click="cadastro" class="buttonCadastro">
                        Cadastrar-se
                    </button>
                    <button v-on:click="login" class="buttonLogin">
                        Login
                    </button>
                </div>
                <div class="versionString">
                    Por Librarium Inc.
                </div>
            </div>
        </div>
    </div>
</template>

<script> 
import {fetchCustomers} from '../requests.js'
    export default {
        data: function () {
            return {
                images: [
                'https://dummyimage.com/800/ffffff/000000',
                'https://dummyimage.com/1600/ffffff/000000',
                'https://dummyimage.com/1280/000000/ffffff',
                'https://dummyimage.com/400/000000/ffffff',
                ],
                index: null,
            };
        },
        methods: {
            login: async function(){                
                //statica navigation, user and password must me "aps"
                var costumers = await fetchCustomers();
                costumers = costumers.data;
                console.log(costumers);
                if(costumers == null) return;
                //veryfying if there use trying to login is signed up
                var emailLogin = document.getElementById("email").value;
                
                var senhaLogin = document.getElementById("senha").value;
                console.log(senhaLogin);

                var costumerLoggedIn = null;
                for(var i = 0; i < costumers.length; i++){
                    if(costumers[i].email == emailLogin){
                        if(costumers[i].password == senhaLogin){
                            console.log("logou tudo certo");
                            costumerLoggedIn = costumers[i];
                            this.$router.push({ name: 'HomeClient', params: {clienteLogado: costumerLoggedIn}});
                        } else {
                            console.log("senha errada");
                        }                        
                    }
                }
                if(costumerLoggedIn == null){
                    console.log("nao existe usuario com esse email");
                }

                if(document.getElementById("email").value == "aps" && document.getElementById("senha").value == "aps"){
                    alert("logou");
                    //navigation:
                    //this.$router.push('homeClient');
                }
            },
            cadastro: function(){                
                this.$router.push('cadastro');
            },
            updtEmailInput: function(){
                console.log(document.getElementById("email").value);
                //this.emailEae = 
            }
        },
        created() {
                this.id = this.$route.params.id;
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
