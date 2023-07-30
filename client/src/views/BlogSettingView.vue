<template>
  <div class="setting">
    <Sidebar />
    <main class="main">
      <div class="main_form">
        <router-view></router-view>
      </div>
    </main>
  </div>
</template>

<script>
import Sidebar from '@/components/setting/Sidebar.vue';

export default {
  data() {
    return {
      blogSelectedMenu: null
    } 
  },
  components: {
    Sidebar,
  },
  mounted() {
    this.blogSelectedMenu = sessionStorage.getItem('blogSelectedMenu');
  }
}
</script>
<style scoped>
.setting {
  margin-top: 20px; 
  width: 100%;
  display: flex;
}

.main {
  width: 85%;
}
.main_form {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 80vh;
  color: #ccc;
  border: 1px solid rgba(0, 0, 0, 0.5);
}

</style>