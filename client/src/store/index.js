import { createStore } from 'vuex'
import { createVuexPersistedState } from "vue-persistedstate";
import axios from "axios";

const store = createStore({
  plugins: [createVuexPersistedState()],
  state() {
    return {
      accessToken: null,
      user: {
        id: 0,
        email: null,
        name: null,
        role: null,
      },
      blogId: null
    }
  },
  getters: {
    isLogin(state) {
      return state.accessToken !== null;
    },
    isCoached(state) {
      if(state.user.role === "[ROLE_COACH]"){
        return true;
      }
      else return false;
    },
    headers(state) {
      return {
        Authorization: `Bearer ${state.accessToken}`,
      };
    },
  },
  mutations: {
    setAccessToken(state, _accessToken) {
      state.accessToken = _accessToken;
    },
    setUser(state, _email) {
      state.user.email = _email;
    },
    setUserRole(state, _role) {
      state.user.role = _role;
    },
    setAccessTokenAndUser(state, accessToken) {
      state.accessToken = accessToken;
      state.user.email = null;
      alert('세션 만료로 로그아웃 되었습니다. 다시 로그인 후 이용해주세요');
      location.href="/";
    },
    setBlogId(state, id) {
      state.blogId  = id;
    }
  },
  actions: {
    async getAccessToken({ commit }) {
      try {
        const response = await axios.post("/api/v1/jwt");
        const accessToken = response.data.accessToken;
        commit("setAccessToken", accessToken);
        console.log("Access Token 발급 완료: " + accessToken);
        return true;
      } catch (error) {
        console.log("Access Token 발급 실패: " + error);
        return false;
      }
    },
  },
  modules: {
  }
})
export default store;
