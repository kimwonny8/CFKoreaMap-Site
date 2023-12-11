<template>
  <div style="height: 80vh; display: flex; align-items: center; justify-content: center;">
    <div v-if="!isEdited" class="blog-container">
      <div class="blog-header">
        <div class="blog-cover">
          <div class="blog-name">
            <h3>센터이름</h3>
          </div>
        </div>
      </div>
      <div class="blog-body">
        <div class="blog-title">
          <h2>센터 소개</h2>
        </div>
        <div class="blog-summary">
          <p>300자까지 허용</p>
        </div>
      </div>
      <div class="blog-footer">
        <ul>
          <li class="published-date">2 days ago</li>
          <li><button @click="editNoticePost()">수정</button></li>
        </ul>
      </div>
    </div>
    <!-- ABOUT 수정 -->
    <div v-else>
    <div class="blog-container">
    <div class="blog-header">
      <div class="blog-cover">
        <p>바꿀 이미지를 선택해주세요.</p>
        <input type="file">
      </div>
    </div>
    <div class="blog-body">
      <div class="blog-title">
        <input type="text" value="센터 소개">
      </div>
      <div class="blog-summary">
        <textarea>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Praesentium, odio sunt ad, consequuntur beatae cum repudiandae suscipit accusantium quia illo, dolor quas? Eos rerum nihil illum repellendus fugiat id reprehenderit.</textarea>
      </div>
      <div class="blog-footer">
        <ul>
          <li class="published-date">소개 수정중......</li>
          <li><button @click="editNoticePost()">수정</button></li>
        </ul>
      </div>
    </div>
  </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "blogAbout",

  data() {
    return {
      blogId: null,
      isEdited: false
    }
  },
  mounted() {
    this.blogId = this.$store.state.blogId;
    // DB에 id 있는지 확인
    console.log(this.$store.state.blogId);
  },
  methods: {
    editNoticePost() {
      this.isEdited = !!!this.isEdited;
      // 매개변수로 저장인지 수정인지 확인, DB 저장
    }
  }
}
</script>
<style scoped lang="scss">
li {
  list-style: none;
}

.blog-name {
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: large;
}

.blog-container {
  background: #fff;
  border-radius: 5px;
  box-shadow: hsla(0, 0, 0, .2) 0 4px 2px -2px;
  margin: 20px auto;
  width: 800px;
}

.blog-cover {
  background: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/17779/yosemite-3.jpg");
  background-size: cover;
  border-radius: 5px 5px 0 0;
  height: 15rem;
  box-shadow: inset hsla(0, 0, 0, .2) 0 64px 64px 16px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.blog-body {
  margin: 0 auto;
  width: 700px;
}

.blog-title h1 a {
  color: #333;
  font-weight: 100;
}

.blog-summary p {
  color: lighten(#333, 10%);
  margin-bottom: 30px;
  height: 100px;
}

.blog-footer {
  border-top: 1px solid lighten(#333, 70%);
  margin: 0 auto;
  width: 600px;
  padding-bottom: 20px;
}

.blog-footer ul {
  list-style: none;
  display: flex;
  flex: row wrap;
  justify-content: flex-end;
  padding-left: 0;
}

.blog-footer li:first-child {
  margin-right: auto;
}

.blog-footer li+li {
  margin-left: .5rem;
}

.blog-footer li {
  color: lighten(#333, 40%);
  font-size: .75rem;
  height: 1.5rem;
  letter-spacing: 1px;
  line-height: 1.5rem;
  text-align: center;
  text-transform: uppercase;
  position: relative;
  white-space: nowrap;

  & a {
    color: lighten(#333, 40%);
  }
}

button {
  padding: 5px 15px;
  border-radius: 3px;
  border: 1px solid gray;
  background-color: transparent;
  cursor: pointer;
}

button:hover {
  opacity: 0.7;
}

.blog-cover input {
  width: 180px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.blog-title input {
  font-family: 'Noto Sans KR', Avenir, Helvetica, Arial, sans-serif;
  color: #333;
  margin: 10px 0;
  width: 700px;
  padding: 5px;
  font-size: 24px;
  font-weight: bold;
  border: none;
  text-align: center;
}

.blog-summary textarea {
  font-family: 'Noto Sans KR', Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: lighten(#333, 10%);
  width: 700px;
  height: 100px;
  padding: 10px 0px;
  font-size: 16px;
  margin-bottom: 13px;
  resize: none;
}
</style>