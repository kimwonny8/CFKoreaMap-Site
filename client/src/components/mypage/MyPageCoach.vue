<template>
  <!-- 코치 등록 안되어 있을 때 -->
  <div class="blog_create_form" v-if="isCoach === false">
    <h3>코치 등록</h3>
    <p>본인 센터의 주소, 사업자 등록증 사진을 첨부해주세요.<br>심사는 최대 1주일 소요됩니다.</p>
    <div class="text_form">
      <input type="text" class="input_text" @click="openPostcode()" placeholder="우편번호" v-model="zonecode">
    </div>
    <div class="text_form">
      <input type="text" class="input_text" placeholder="센터이름" v-model="roadAddress">
    </div>
    <div class="text_form">
      <input type="file" name="file" id="file" accept="image/png, image/jpg, image/jpeg">
      </div>
    <button class="btn">확인</button>
  </div>

  <!-- 코치 등록 대기중 -->
  <div class="blog_create_form" v-else-if="isCoach === 'wait'">
    <h3>코치 등록 대기중...🤔</h3>
    <p>현재 입력하신 정보를 확인중입니다.<br>심사는 최대 1주일 소요됩니다.</p>
    <!-- 입력한 데이터와 날짜 출력 예정 -->
    <div class="text_form">
      <input type="text" class="input_text" placeholder="센터이름" readonly>
    </div>
    <div class="text_form">
      <input type="text" class="input_text" placeholder="신청한 날짜" readonly>
    </div>
  </div>
  <!-- 코치 -->
  <div class="blog_create_form" v-else>
    <h3>반갑습니다!</h3>
    <p>코치님과 연결된 센터 정보입니다.</p>
    <div class="text_form">
      <input type="text" class="input_text" placeholder="센터이름" readonly>
    </div>
    <button class="btn">⭐블로그로 이동하기⭐</button>
    <button class="btn">연결끊기</button>
  </div>
</template>
    
<script>
export default {
  data() {
    return {
      isCoach: false,
      email: null,
      zonecode: "",
      roadAddress: "",
      detailAddress: "",
    }
  },
  mounted() {
    this.email = this.$store.state.user.email;
  },
  methods: {
    openPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          console.log(data);
          this.zonecode = data.zonecode;
          this.roadAddress = data.roadAddress;
        },
      }).open();
    },
  },

}
</script>
<style style="scss" scoped>
.blog_create_form {
  width: 400px;
  padding: 30px;
  border: 1px solid gray;
  text-align: center;
  border-radius: 10px;
}

.text_form {
  margin: 30px;
  display: flex;
  justify-content: center;
}


.input_text {
  width: 90%;
  border: none;
  outline: none;
  color: #636e72;
  font-size: 16px;
  height: 25px;
  background: none;
  border-bottom: 1px solid #adadad;
  padding: 10px;
}

.btn {
  width: 80%;
  height: 40px;
  background: linear-gradient(125deg, #3d465f, #6c5ce7, #6d98bb);
  background-position: left;
  background-size: 200%;
  color: white;
  font-weight: bold;
  border: none;
  cursor: pointer;
  transition: 0.4s;
  border-radius: 3px;
  margin-bottom: 20px;
}

.btn:hover {
  background-position: right;
}

input[type=file]::file-selector-button {
  width: 140px;
  height: 30px;
  background: #ccc;
  border: 1px solid rgb(77,77,77);
  border-radius: 10px;
  cursor: pointer;
  margin-right: 10px;
  &:hover {
    background: rgb(77,77,77);
    color: #fff;
  }
}

</style>