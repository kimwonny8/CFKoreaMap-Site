<template>
  <div class="landingpage">
    <MainHeader></MainHeader>
    <router-view />
    <MainFooter></MainFooter>
  </div>
</template>

<script>
import mainHeader from '@/components/MainHeader.vue'
import mainFooter from '@/components/MainFooter.vue'

export default {
  components: {
    MainHeader: mainHeader,
    MainFooter: mainFooter
  }
}


</script>
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@400;600&family=Noto+Sans+KR&display=swap');

#app {
  font-family: 'Noto Sans KR', Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

input {
  font-family: 'Noto Sans KR', Avenir, Helvetica, Arial, sans-serif;
}

body {
  margin: 0;
  background-color: #1f2034;
}

body::-webkit-scrollbar {
  width: 8px;
}

body::-webkit-scrollbar-thumb {
  height: 30%;
  background: rgb(77, 77, 77);
  border-radius: 10px;
}

body::-webkit-scrollbar-track {
  background: rgba(131, 131, 131, 0.1);
}

.hidden {
  display: none;
}

.landingpage {
  margin: 0 auto;
  padding: 0 150px;
  max-width: 100vw;
  overflow-y: auto;
  overflow-x: hidden;
  background-color: #1f2034;

  &::before {
    content: "";
  }

  &::after {
    content: "";
  }

  .navbar {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 20px 0;
    width: 100%;
  }

  .box {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 80px;
  }

  .auction {
    margin-top: 100px;
  }

  .discover {
    display: flex;
    flex-direction: column;
  }

  .footer {
    margin: 50px 0;
    margin-top: 100px;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .footer2 {
    display: flex;
    justify-content: space-between;
    padding-bottom: 20px;
    border-top: 1px solid #F2F2F2;
  }
}

.navbar {
  .hamburgerlogowrap {
    display: flex;
    align-items: center;
  }

  .hamburger {
    display: none;
    color: #D7D7D7;
    background-color: #1F1D2B;
    border: none;
    margin-right: 10px;
  }

  .createbtn {
    cursor: pointer;
    background-color: transparent;
    border: none;
    width: 100px;
    height: 40px;
    color: #BCBCBC;
    font-style: normal;
    font-weight: 500;
    font-size: 14px;

    &.selectedbtn {
      border: 1px solid #D7D7D7;
      border-radius: 10px;
    }
  }

  .navlogo {
    height: 100%;
    background: linear-gradient(93.51deg, #9B51E0 2.84%, #3081ED 99.18%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    font-style: normal;
    font-weight: 700;
    font-size: 32px;
  }

  .navlink {
    font-style: normal;
    font-weight: 500;
    font-size: 14px;
    color: #BCBCBC;

    &.selectedlink {
      background: linear-gradient(93.51deg, #9B51E0 2.84%, #3081ED 99.18%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      border-bottom: 1.5px solid #9B51E0;
    }

    &:not(:last-child) {
      margin-right: 32px;
    }
  }
}
</style>
