<template>
  <aside class="sidebar">
    <nav class="nav">
      <ul>
        <li><a href="/blogsetting/main">블로그정보</a></li>
        <li><a href="/blogsetting/post">게시글관리</a></li>
        <li><a href="/blogsetting/member">회원관리</a></li>
      </ul>
    </nav>
  </aside>
</template>

<script>
export default {
  data() {
    return {

    }
  },
}
</script>

<style scoped lang="scss">
.sidebar {
  width: 17%;
  //   width: 250px;
  height: 80vh;
  background: #312450;
  font-size: 14px;
  font-weight: 600;
}

.nav {
  position: relative;
  margin: 0 15%;
  text-align: right;
  top: 50%;
  transform: translateY(-50%);
}

.nav ul {
  list-style: none;

  li {
    position: relative;
    margin: 30px 0;

    a {
      line-height: 5em;
      text-transform: uppercase;
      text-decoration: none;
      letter-spacing: 0.1em;
      color: rgba(#FFF, 0.5);
      display: block;
      transition: all ease-out 300ms;
    }

    &:not(.active):hover a {
      color: rgba(#FFF, 0.8);
    }

    &::after {
      content: '';
      position: absolute;
      width: 100%;
      height: 0.2em;
      background: black;
      left: 0;
      bottom: 0;
      background-image: linear-gradient(to right, #5e42a6, #b74e91)
    }
  }
}
</style>