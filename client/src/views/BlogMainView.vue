<template>
  <div class="blog_main_form">
    <div class="blog_menu">
      <li><a href="/blog">About</a></li>
      <li><a href="/blog/posts">Posts</a></li>
      <li><a href="/blog/guestbook">GuestBook</a></li>
    </div>
    <div class="blog_content">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>

export default {
  name: "blogMain",
  data() {
    return {
      blogId: null,
      edit: false
    }
  },
  mounted() {
    this.blogId = this.$store.state.blogId;
  },
}

</script>
<style scoped lang="scss">
.blog_main_form {
  border-top: 1px solid #dadce036;
  margin: 10px 0;
}

.blog_menu {
  border-bottom: 1px solid #dadce036;
  display: flex;
  align-items: center;
  justify-content: center;
}

.blog_content {
  display: flex;
  align-items: center;
  justify-content: center;
}

li {
  list-style: none;
}

a {
  color: #fff;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 0.15em;
  display: inline-block;
  padding: 15px 20px;
}

a:after {
  background: none repeat scroll 0 0 transparent;
  bottom: 0;
  content: "";
  display: block;
  height: 1px;
  background: #fff;
  transition: width 0.3s ease 0s, left 0.3s ease 0s;
  width: 0;
}

a:hover:after {
  width: 100%;
  left: 0;
}
</style>