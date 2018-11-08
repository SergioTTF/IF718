import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '../screens/login.vue'
import Cadastro from '../screens/cadastro.vue'
import HomeClient from '../screens/homeClient.vue'
import Carrinho from '../screens/carrinho.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/cadastro',
      name: 'Cadastro',
      component: Cadastro
    },
    {
      path: '/homeClient',
      name: 'HomeClient',
      component: HomeClient
    },
    {
      path: '/carrinho',
      name: 'Carrinho',
      component: Carrinho
    },
  ]
})
