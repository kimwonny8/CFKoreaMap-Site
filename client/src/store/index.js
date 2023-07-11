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
      },
    }
  },
  getters: {
    isLogin(state) {
      return state.accessToken == null ? false : true;
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
    setAccessTokenAndUser(state, accessToken) {
      state.accessToken = accessToken;
      state.user.email = null;
      alert('세션 만료로 로그아웃 되었습니다. 다시 로그인 후 이용해주세요');
      location.href="/";
    },
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
