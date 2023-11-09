import { createRouter, createWebHistory } from 'vue-router';
import store from '../store';
import Home from '../views/HomeView.vue';
import SignIn from '../views/SignInView.vue';
import Map from '../views/MapView.vue';

import BlogMain from '../views/BlogMainView.vue';
import BlogPost from '@/components/blog/BlogPost.vue';
import BlogAbout from '@/components/blog/BlogAbout.vue';
import BlogGuestBook from '@/components/blog/BlogGuestBook.vue';

import BlogSetting from '../views/BlogSettingView.vue';
import BlogSettingMain from '@/components/setting/BlogSettingMain.vue';
import BlogSettingMember from '@/components/setting/BlogSettingMember.vue';
import BlogSettingPost from '@/components/setting/BlogSettingPost.vue';

import MyPage from '@/views/MyPageView.vue';
import MyPageMain from '@/components/mypage/MyPageMain.vue';
import MyPageCoach from '@/components/mypage/MyPageCoach.vue';

const requireAuth = () => (from, to, next) => {
  const isLogin = store.getters.isLogin;
  if (!isLogin) {
    alert("로그인 후 이용 가능합니다.");
    return history.back()
  }
  return next() 
}

const requireAuthCoach = () => (from, to, next) => {
  const isCoached = store.getters.isCoached;
  if (!isCoached) {
    alert("코치 회원만 이용 가능합니다.");
    return history.back()
  }
  return next()
}

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
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
    beforeEnter: requireAuth(),
    props: true,
    children: [
      {
        path: '',
        name: 'MyPageMain',
        component: MyPageMain
      },
      {
        path: 'coach',
        name: 'MyPageCoach',
        component: MyPageCoach
      },
    ]
  },
  {
    path: '/blog',
    name: 'BlogMain',
    component: BlogMain,
    props: true,
    children: [
      {
        path: '',
        name: 'BlogAbout',
        component: BlogAbout
      },
      {
        path: 'posts',
        name: 'BlogPost',
        component: BlogPost
      },
      {
        path: 'guestbook',
        name: 'BlogGuestBook',
        component: BlogGuestBook
      },
    ]
  }, 
  {
    path: '/blogsetting',
    name: 'BlogSetting',
    component: BlogSetting,
    beforeEnter: requireAuthCoach(),
    children: [
      {
        path: 'main',
        name: 'BlogSettingMain',
        component: BlogSettingMain
      },
      {
        path: 'member',
        name: 'BlogSettingMember',
        component: BlogSettingMember
      },
      {
        path: 'post',
        name: 'BlogSettingPost',
        component: BlogSettingPost
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
