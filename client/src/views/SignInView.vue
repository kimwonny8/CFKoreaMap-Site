<template>
  <section>
    <div class="login-box">
      <div v-if="!isSignUp">
        <h2>Sign in</h2>
        <div class="user-box">
          <input type="text" v-model.trim="form.email" required=true  maxlength="100">
          <label>email</label>
        </div>
        <div class="user-box" @keyup.enter="signin()">
          <input type="password" v-model="form.password" required=true  maxlength="100">
          <label>password</label>
        </div>
        <button class="login-btn" @click="signin()">signin</button>
        <button class="login-btn" @click="changeForm()">signup</button>
      </div>
      <div v-if="isSignUp">
        <h2>Sign up</h2>
        <div class="user-box">
          <input type="text" v-model.trim="form.email" required=true maxlength="100">
          <label>email</label>
        </div>
        <div class="user-box">
          <input type="text" v-model.trim="form.name" required=true maxlength="50">
          <label>userName</label>
        </div>
        <div class="user-box">
          <input type="password" v-model.trim="form.password" required=true maxlength="100">
          <label>password</label>
        </div>
        <div class="user-box">
          <input type="password" v-model.trim="password2" required=true maxlength="100">
          <label>confirm password</label>
        </div>
        <button class="login-btn" @click="changeForm()">signin</button>
        <button class="login-btn" @click="signup()">signup</button>
      </div>
    </div>
  </section>
</template>
<script>
import axios from 'axios';

export default {
  data() {
    return {
      isSignUp: false,
      password2: null,
      form: {
        email: null,
        password: null,
        name: null,
      }
    }
  },
  methods: {
    changeForm() {
      this.isSignUp = !this.isSignUp;
      this.form.password = null;
      this.password2 = null;
    },
    async signin() {
      if (this.form.email == null || this.form.password == null) {
          alert("입력하지 않은 칸이 있습니다.");
          return;
      }
      await axios.post(`${process.env.VUE_APP_API_PATH}/api/v1/auth/login`, this.form)
        .then((res) => {
          this.$store.commit("setAccessToken", res.data);
          this.$store.commit("setUser", this.form.email);
          this.$router.push('/');
        })
        .catch((err) => {
          alert(err.response.data.message);
          console.log(err);
        });
    },
    async signup() {
      if (this.form.email == null || this.form.password == null || this.form.name == null) {
        alert("입력하지 않은 칸이 있습니다.");
        return;
      }
      else if (this.form.password !== this.password2) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
      }
      await axios.post(`${process.env.VUE_APP_API_PATH}/api/v1/auth`, this.form)
        .then((res) => {
          alert(res.data);
          this.$router.push('/');
        })
        .catch((err) => {
          alert(err.response.data.message);
          console.log(err.response.data.message);
        });
    }
  }
}
</script>
<style lang="scss" scoped>
section {
  height: 80vh;
}

html {
  height: 100%;
}

body {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background: linear-gradient(#141e30, #243b55);
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0, 0, 0, .2);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, .3);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 15px;
  color: #ccc;
  pointer-events: none;
  transition: .5s;
  text-transform: capitalize;
}

.login-box .user-box input:focus~label,
.login-box .user-box input:valid~label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}

.login-btn {
  background-color: #141e30;
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  margin: 0 5px;
  color: #00c7d1;
  font-size: 15px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 20px;
  letter-spacing: 4px;
  border: 1px solid rgba(255, 255, 255, 0.582);
}

.login-btn:hover {
  color: #fff;
}
</style>