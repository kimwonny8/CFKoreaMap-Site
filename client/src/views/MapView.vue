<template>
    <section>
        <KakaoMap />
    </section>
</template>
<script>
// import axios from 'axios';
import KakaoMap from '@/components/KakaoMap.vue';

export default {
  data() {
    return {
        map:null
    }
  },
  components: {
    KakaoMap
  }
}
</script>
<style scoped>
section {
  height: 80vh;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

</style>