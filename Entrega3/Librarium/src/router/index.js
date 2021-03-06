import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '../screens/login.vue'
import Cadastro from '../screens/cadastro.vue'
import HomeClient from '../screens/homeClient.vue'
import ProfileClient from '../screens/profileClient.vue'
import Carrinho from '../screens/carrinho.vue'
import Pagamento from '../screens/pagamento.vue'

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
      path: '/profileClient',
      name: 'ProfileClient',
      component: ProfileClient
    },
    {
      path: '/carrinho',
      name: 'Carrinho',
      component: Carrinho
    },
    {
      path: '/pagamento',
      name: 'Pagamento',
      component: Pagamento
    }
  ]
})
