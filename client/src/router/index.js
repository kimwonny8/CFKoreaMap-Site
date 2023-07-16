import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomeView.vue'
import SignIn from '../views/SignInView.vue'
import Map from '../views/MapView.vue'


const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/signin',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/map',
    name: 'Map',
    component: Map
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
