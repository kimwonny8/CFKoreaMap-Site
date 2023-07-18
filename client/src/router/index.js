import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomeView.vue'
import SignIn from '../views/SignInView.vue'
import Map from '../views/MapView.vue'
import BlogSetting from '../views/BlogSettingView.vue';
import BlogMember from '@/components/BlogMember.vue';
import BlogDetails from '@/components/BlogDetails.vue';
import BlogPost from '@/components/BlogPost.vue';

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
  },
  {
    path: '/map',
    name: 'Map',
    component: Map
  },
  {
    path: '/blog',
    name: 'BlogSetting',
    component: BlogSetting,
    children: [
      {
        path: 'member',
        name: 'BlogMember',
        component: BlogMember
      },
      {
        path: 'details',
        name: 'BlogDetails',
        component: BlogDetails
      },
      {
        path: 'post',
        name: 'BlogPost',
        component: BlogPost
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
