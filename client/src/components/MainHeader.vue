<template>
  <div class="landingpage">
    <div class="navbar">
      <a class="navlogo" href="/">CFKoreaMap</a>
      <button class="hamburger">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-width="2"
          stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu">
          <path d="M3 12h18M3 6h18M3 18h18" />
        </svg>
      </button>
      <div class="navlinkwrap">
        <a href="#" class="navlink selectedlink">Home</a>
        <a href="/map" class="navlink">Map</a>
        <a href="/blog" class="navlink">Blog</a>
        <a href="#" class="navlink">My Page</a>
      </div>
      <div v-if="!this.$store.getters.isLogin" class="buttonwrap">
        <button class="createbtn selectedbtn" @click="signin()">SIGN IN</button>
      </div>
      <div v-else class="buttonwrap">
        <p class="welcome">Hi {{ this.$store.state.user.email }}!</p>
        <button class="createbtn selectedbtn" @click="logout()">Logout</button>
      </div>
    </div>
  </div>
</template>
  
<script>
import axios from "axios";

export default {
  methods: {
    signin() {
      this.$router.push("/signin");
    },
    async logout() {
      await axios.get(`${process.env.VUE_APP_API_PATH}/api/v1/auth`)
      this.$store.commit('setAccessToken', null);
      this.$store.commit('setUser', null);
      this.$router.push({ path: "/" });
    }
  }
}

</script>
  
<style scoped>
.landingpage {
  padding: 0 10%;
}

.buttonwrap {
  display: flex;
  align-items: center;
}

.welcome {
  color: white;
  margin-right: 10px;
}
</style>
  