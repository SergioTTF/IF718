<template>
    <div>
        <div class="sidebar">
        	<router-link class="linkSidebar" :to="{ name: '', link:''}">
            	<div class="sidebarTitle">
                	Olá, Fulano! (mudar nome)
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
            <router-link class="linkSidebar" :to="{ name: '', link:''}">
                <div class="carrinhoContainer">
                    <ion-icon class="cartIcon" name="cart"></ion-icon>                    
                    <div class="cartText">
                        Meu Carrinho (0)
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
            
            <input type="text" placeholder="Me edite">
            <!-- <input type="text" name="nome" value="Daniel Filgueira Bezerra">
        		<input type="text" name="email" value="dvb2@cin.ufpe.br">
    		<input type="password" name="senha" value="admin">
    		<input type="text" name="rua" value="Av. Nova Guiné">
        	<input type="text" name="numero" value="324">
    		<input type="text" name="complemento" value="apto 201">
    		<input type="text" name="cep" value="54.410-021">
    		<input type="text" name="estado" value="PE">
    		<input type="text" name="cidade" value="Recife"> -->
            
        </div>
        <div>
            <p>googog</p>
        </div>

    </div>    
</template>

<script> 
    export default {
        data: function () {
            return {
                nome: "Daniel",
            };
        },
        methods: {
            
        },
        created() {
                this.id = this.$route.params.id;
        },        
    }
</script>

<style scoped>
	.profileData{
		margin: 20px;
        align-content: center;
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
