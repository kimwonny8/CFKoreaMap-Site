<template>
  <div>
    <p>연결된 블로그가 없습니다.<br>블로그 생성 후 이용해주세요.</p>
    <!-- 블로그 없다면 -->
    <div  class="blog_create_form">
      <h3>블로그 생성</h3>
      <div class="text_form">
        <input type="text" class="input_text" placeholder="이름">
      </div>
      <div class="text_form">
        <input type="text" class="input_text" placeholder="상세설명">
      </div>
      <input type="submit" class="btn" value="등록" />
    </div>
  </div>

</template>
  
<script>

export default {
  data() {
    return {

    }
  },
  components: {

  }
}
</script>
<style scoped>
.blog_create_form {
  width:400px;
  padding: 30px;
  border: 1px solid gray;
  text-align:center;
  border-radius: 10px;
}

.text_form {
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px;
}


.input_text {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.btn {
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  margin-bottom: 20px;
}

.btn:hover {
  background-position: right;
}
</style>