<template>
  <div class="blog_main_form">
    <div class="blog_menu">
      <li><a href="#">About</a></li>
      <li><a href="#">Posts</a></li>
      <li><a href="#">GuestBook</a></li>
    </div>
    <div class="blog-container">
      <div class="blog-header">
        <div class="blog-cover">
          <div class="blog-name">
            <h3>blog-name</h3>
          </div>
        </div>
      </div>
      <div class="blog-body">
        <div class="blog-title">
          <h1><a href="#">센터 소개</a></h1>
        </div>
        <div class="blog-summary">
          <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Praesentium, odio sunt ad, consequuntur beatae cum repudiandae suscipit accusantium quia illo, dolor quas? Eos rerum nihil illum repellendus fugiat id reprehenderit.</p>
        </div>
      </div>

      <div class="blog-footer">
        <ul>
          <li class="published-date">2 days ago</li>
          <li>수정</li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>

</script>
<style scoped lang="scss">
.blog_main_form{
  border-top: 1px solid #dadce036;
  margin: 10px 0;
}
.blog_menu {
  border-bottom: 1px solid #dadce036;
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
  width: 75%;
}
.blog-cover {
  background: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/17779/yosemite-3.jpg");
  background-size: cover;
  border-radius: 5px 5px 0 0;
  height: 15rem;
  box-shadow: inset hsla(0, 0, 0, .2) 0 64px 64px 16px;
}

.blog-body {
  margin: 0 auto;
  width: 75%;
}

.blog-title h1 a {
  color: #333;
  font-weight: 100;
}

.blog-summary p {
  color: lighten(#333, 10%);
  margin-bottom: 30px;
}

.blog-tags ul {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  list-style: none;
  padding-left: 0;
}

.blog-tags li+li {
  margin-left: .5rem;
}

.blog-tags a {
  border: 1px solid lighten(#333, 40%);
  border-radius: 3px;
  color: lighten(#333, 40%);
  font-size: .75rem;
  height: 1.5rem;
  line-height: 1.5rem;
  letter-spacing: 1px;
  padding: 0 .5rem;
  text-align: center;
  text-transform: uppercase;
  white-space: nowrap;
  width: 5rem;
}
.blog-footer {
  border-top: 1px solid lighten(#333, 70%);
  margin: 0 auto;
  width: 75%;
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

.comments {
  margin-right: 1rem;
}

.published-date {
  border: 1px solid lighten(#333, 40%);
  border-radius: 3px;
  padding: 0 .5rem;
}

.numero {
  position: relative;
  top: -0.5rem;
}

// Icons
//-------------------------
.icon-star,
.icon-bubble {
  fill: lighten(#333, 40%);
  height: 24px;
  margin-right: .5rem;
  transition: .25s ease;
  width: 24px;

  &:hover {
    fill: #ff4d4d;
  }
}</style>