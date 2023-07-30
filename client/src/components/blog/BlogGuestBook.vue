<template>
  <div class="post-contents">
    <button v-if="!isPosted" @click="isPosted = true">방명록 쓰기</button>
    <div v-if="isPosted" class="post-form">
      <div class="editor">
        <div class="editor-page">
          <editor></editor>
        </div>
      </div>
      <button @click="post">작성</button>
    </div>
    <div class="blog-container">
      <div class="blog-header">
        <p>{{ memberId }} 님이 쓰신 글😊</p>
      </div>
      <div class="blog-body">
        <div class="blog-summary">
          <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Praesentium, odio sunt ad, consequuntur beatae cum
            repudiandae suscipit accusantium quia illo, dolor quas? Eos rerum nihil illum repellendus fugiat id
            reprehenderit.</p>
        </div>
      </div>
      <div class="blog-footer">
        <ul>
          <li class="published-date">2023-07-30</li>
          <li><button>수정</button></li>
          <li><button>삭제</button></li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>
import Editor from '@/components/common/Editor.vue'

export default {
  data() {
    return {
      isPosted: false,
      memberId: ''
    }
  },
  components: {
    Editor
  },
  methods: {
    post() {
      this.isPosted = false;
      // 방명록 작성 메소드  
    }
  }
}
</script>
    
<style scoped style="scss">
button {
  padding: 5px 15px;
  border-radius: 3px;
  border: 1px solid gray;
  background-color: transparent;
  cursor: pointer;
  color: white;
}

button:hover {
  opacity: 0.7;
}

.post-contents {
  margin: 30px 0;
  width: 700px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.post-form {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 10px 0;
  border-bottom: 1px solid #2c3e50;
  padding: 20px;
}

.post-form>button {
  border-radius: 3px;
  margin: 10px 0;
}

.blog-header {
  text-align: left;
  margin-left: 30px;
}

.editor {
  width: 700px;
  height: 400px;
  background-color: white;
  margin-top: 20px;
  overflow: scroll;
}

.note-editable {
  height: 500px;
}

.note-editor {
  border-radius: 10px;
}

.editor-page {
  margin-bottom: 120px;
}

.blog-container {
  margin-top: 30px;
  background: #ffffffaf;
  border-radius: 5px;
  box-shadow: hsla(0, 0, 0, .2) 0 4px 2px -2px;
  padding: 10px;
}

.blog-footer {
  border-top: 1px solid lighten(#333, 70%);
  margin: 0 auto;
  padding: 5px;
}

.blog-footer ul {
  list-style: none;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-left: 0;
}

.blog-footer li {
  color: lighten(#333, 40%);
  font-size: 13px;
  text-transform: uppercase;
  margin-right: 10px;
}

.blog-footer li button {
  color: black;
  padding: 3px 10px;
}
</style>