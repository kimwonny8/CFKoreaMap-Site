<template>
    <div class="landingpage">
      <div class="navbar">
        <a class="navlogo" href="/">CROSSFIT</a>
        <button class="hamburger">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-width="2"
            stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu">
            <path d="M3 12h18M3 6h18M3 18h18" />
          </svg>
        </button>
        <div class="navlinkwrap">
          <a href="#" class="navlink selectedlink">Home</a>
          <a href="#" class="navlink">Location</a>
          <a href="#" class="navlink">Blog</a>
          <a href="#" class="navlink">My Profile</a>
        </div>
        <div class="buttonwrap">
          <button class="createbtn selectedbtn" @click="signin()">SIGN IN</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      signin(){
        this.$router.push("/signin");
      }
    }
  }
  
  </script>
  
  <style scoped>
  .landingpage{
    padding: 0 10%;
  }
  </style>
  