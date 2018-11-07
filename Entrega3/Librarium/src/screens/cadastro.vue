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
            
                <div class="inputContainer">
                    <div class="inputText">
                        nome
                    </div>    
                    <div class="inputTextField">
                        <input id="nome" v-model="message" placeholder="">
                    </div>            
                    
                </div>
                <div class="inputContainer">
                    <div class="inputText">
                        Email
                    </div>                
                    <input id="email" v-model="message" placeholder="">
                </div>
                <div class="inputContainer">
                    <div class="inputText">
                        Senha
                    </div>                
                    <input id="senha" v-model="message" placeholder="">
                </div>
                <div class="inputContainer">
                    <div class="inputText">
                        Confirmação
                    </div>                
                    <input id="confirmacao" v-model="message" placeholder="">
                </div>

                <div class="textoIntervalo">
                    Endereço
                </div>

                <div class="botoes">
                    <button v-on:click="cadastro" class="buttonCadastro">
                        Cadastrar-se
                    </button>
                </div>

            </div>
        </div>
    </div>
</template>

<script> 
    export default {
        data: function () {
            return {
                images: [
                'https://dummyimage.com/800/ffffff/000000',
                'https://dummyimage.com/1600/ffffff/000000',
                'https://dummyimage.com/1280/000000/ffffff',
                'https://dummyimage.com/400/000000/ffffff',
                ],
                index: null
            };
        },
        methods: {
            cadastrar: function(){                
                
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
    .buttonCadastro:hover {
        border: 1px solid #007cad;
        background: rgba(0,142,198,1);
        -webkit-box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        box-shadow: 2px 2px 2px 0 rgba(0,0,0,0.3) ;
        -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
        transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
    }

    .buttonCadastro:active {
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
    .backIcon{
        color: #ffffff;
        float: left;
        margin-top: 15px;
        font-size: 30px;
    }
    .textoIntervalo{
        font-size: 1.6em;
        color: #ffffff;
        float: left;
    }
    .inputTextField{
        float: right;
    }
    h2{
        font-family: AvenirNext;
        font-size: 2.3em;
    }
</style>
