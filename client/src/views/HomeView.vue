<template>
  <div class="landingpage">
    <div class="box">
      <div class="infobox">
        <p class="infobox-boldtext">
          YOUR ONLY LIMIT<br>IS YOU.
        </p>
        <p class="infobox-slimtext">
          When you find YOUR focus it will feel as if everything is moving in slow motion.<br>- Annie Thorisdottir
        </p>
        <div class="infobox-btnwrapper">
          <button class="infobox-explorebtn selected">Explore</button>
        </div>
      </div>
      <div class="display">
        <img class="display-nft"
          src="https://images.squarespace-cdn.com/content/v1/55621738e4b03745126ebdf3/1602182093057-5IWHX3D9ALQ3WEIKP7UQ/IMG-0026.JPG?format=2500w"
          alt="unsplash-OG44d93i-NJk" border="0">
        <div class="infowrapper">
          <div class="info">
            <img class="info-img" src="@/assets/짱구.jpg" alt="unsplash-OG44d93i-NJk" border="0">
            <div>
              <p>Kimwonny</p>
            </div>
          </div>
          <div class="info2">
            <p>WE ARE HERE</p>
            <div class="iconwrapper">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="auction">
      <div class="title">
        <p class="titlebold">Hot auctions</p>
        <p class="titleslim">View all</p>
      </div>
      <div class="nft">
        <div class=item>
          <img class="item-img" src="@/assets/logo.png" alt="unsplash-OG44d93i-NJk" border="0">
          <div class="item-title">
            <p>Lorem Ipsum</p>
            <p>1.20 Weth</p>
          </div>
          <p class="item-date">Ends in 01.34.45</p>
        </div>
        <div class=item>
          <img class="item-img" src="@/assets/logo.png" alt="unsplash-OG44d93i-NJk" border="0">
          <div class="item-title">
            <p>Lorem Ipsum</p>
            <p>1.20 Weth</p>
          </div>
          <p class="item-date">Ends in 01.34.45</p>
        </div>
        <div class=item>
          <img class="item-img" src="@/assets/logo.png" border="0">
          <div class="item-title">
            <p>Lorem Ipsum</p>
            <p>1.20 Weth</p>
          </div>
          <p class="item-date">Ends in 01.34.45</p>
        </div>
        <div class=item>
          <img class="item-img" src="@/assets/logo.png" alt="unsplash-OG44d93i-NJk" border="0">
          <div class="item-title">
            <p>Lorem Ipsum</p>
            <p>1.20 Weth</p>
          </div>
          <p class="item-date">Ends in 01.34.45</p>
        </div>
      </div>
    </div>
    <div class="footer">
      <div class="footer-main">
        Etiam et id tincidunt faucibus mollis a sociis pretium fermentum quis magna faucibus lacus.
      </div>
      <div class="footer-navigate">
        <div class="nav">
          <h5>Contact</h5>
          <p>Github</p>
          <p>Blog</p>
          <p>Email</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    signin() {
      this.$router.push("/signin");
    }
  }
}

</script>
<style lang="scss" scoped>
.landingpage {
  margin: 0 auto;
  padding: 0 150px;
  // position: relative;
  max-width: 100vw;
  overflow-y: auto;
  overflow-x: hidden;
  background-color: #1f2034;

  &::before {
    content: "";
    position: absolute;
    width: 123px;
    height: 123px;
    left: 60%;
    top: 138px;
    filter: blur(90px);
    background-color: #feafff;
  }

  &::after {
    content: "";
    position: absolute;
    width: 123px;
    height: 123px;
    left: 80%;
    top: 550px;
    background-color: #18B2DE;
    filter: blur(80px);
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
    padding-bottom: 30px;
    border-top: 1px solid #F2F2F2;
  }
}

.box {
  .infobox {
    animation-name: leftslide;
    animation-duration: 0.8s;
    max-height: 500px;
    max-width: 55%;
    overflow: hidden;

    &-boldtext {
      margin: 0;
      font-family: Poppins;
      color: #FFFFFF;
      font-size: 65px;
      font-weight: 600;
      line-height: 60px;
      letter-spacing: -2px;
      text-align: left;
    }

    &-slimtext {
      margin: 24px 0;
      font-family: Poppins;
      color: #FFFFFF;
      font-size: 16px;
      font-weight: 400;
      line-height: 18px;
      letter-spacing: 0.5px;
      text-align: left;
    }

    &-btnwrapper {
      display: flex;
    }

    &-explorebtn {
      cursor: pointer;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: #1F1D2B;
      padding: 8px 38px;
      border-radius: 16px;

      font-family: 'Poppins';
      font-style: normal;
      font-weight: 600;
      font-size: 13px;
      letter-spacing: -1px;
      color: #FFFFFF;
    }

    &-createbtn {
      cursor: pointer;
      margin-left: 20px;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: transparent;
      padding: 8px 38px;
      border: 1px solid #D7D7D7;
      border-radius: 16px;

      font-family: 'Poppins';
      font-style: normal;
      font-weight: 600;
      font-size: 13px;
      letter-spacing: -1px;
      color: #FFFFFF;
    }

    .selected {
      border: none;
      background: linear-gradient(103.91deg, #9B51E0 21.01%, rgba(48, 129, 237, 0.8) 100%);
    }
  }

  .display {
    animation-name: rightslide;
    animation-duration: 0.8s;
    padding: 14px;
    border: 1px solid;
    background: linear-gradient(169.44deg, rgba(58, 129, 191, 0.08) 1.85%, rgba(65, 48, 90, 0.08) 98.72%);
    border-radius: 35px;
    max-height: 450px;
    max-width: 50%;
    overflow: hidden;
    z-index: 1;

    &-nft {
      object-fit: cover;
      flex-shrink: 0;
      width: 300px;
      height: 300px;
      border-radius: 20px;
    }

    .infowrapper {
      display: flex;
      align-items: center;
      justify-content: space-between;
      margin-top: 10px;
    }

    .info {
      display: flex;
      align-items: center;
      font-family: 'Poppins';
      font-style: normal;
      color: #FFFFFF;
      font-weight: 600;
      font-size: 14px;

      p {
        margin: 0;
      }

      &-img {
        object-fit: cover;
        flex-shrink: 0;
        width: 30px;
        height: 30px;
        border-radius: 50%;
        margin-right: 10px;
      }
    }

    .info2 {
      display: flex;
      flex-direction: column;
      align-items: flex-end;
      font-family: 'Poppins';
      color: #FFFFFF;
      font-style: normal;
      font-weight: 600;
      font-size: 14px;

      p {
        margin: 0;
      }

      .iconwrapper {
        display: flex;
        align-items: center;

        svg {
          margin-right: 5px;
        }
      }
    }
  }
}

.auction {
  .title {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    margin-bottom: 50px;

    .titlebold {
      margin: 0;
      font-family: 'Poppins';
      font-style: normal;
      color: #FFFFFF;
      font-weight: 500;
      font-size: 48px;
      line-height: 72px;
    }

    .titleslim {
      margin: 0;
      font-family: 'Poppins';
      font-style: normal;
      color: #D7D7D7;
      font-weight: 600;
      font-size: 18px;
      line-height: 36px;
      letter-spacing: -1px;
    }
  }

  .nft {
    display: grid;
    grid-template-columns: auto auto auto auto;
    grid-row-gap: 20px;
    grid-column-gap: 20px;
    justify-content: space-between;
  }
}

.started {
  margin-top: 100px;
  display: flex;
  flex-direction: column;

  &-boldtext {
    margin: 0;
    align-self: center;
    font-family: "Poppins";
    font-style: normal;
    color: #FFFFFF;
    font-weight: 500;
    font-size: 40px;
    line-height: 72px;
  }

  &-slimtext {
    margin: 0;
    align-self: center;
    font-family: 'Poppins';
    font-style: normal;
    font-weight: 400;
    font-size: 20px;
    line-height: 36px;
    letter-spacing: 0.5px;
    color: #E2E2E2;
  }

  &-items {
    padding: 60px 80px;
    position: relative;
    display: grid;
    grid-template-columns: auto auto auto auto;
    grid-column-gap: 20px;
    grid-row-gap: 20px;
    justify-content: space-between;

    &:before {
      content: "";
      position: absolute;
      width: 100%;
      height: 100px;
      top: 80px;
      filter: blur(80px);
      background: linear-gradient(93.51deg, #9B51E0 2.84%, #3081ED 99.18%);
    }

    .itemwrapper {
      p {
        width: 100px;
        margin: 0;
        margin-top: 10px;
        text-align: center;
        font-family: 'Poppins';
        font-style: normal;
        font-weight: 400;
        font-size: 14px;
        color: #FFFFFF;
      }
    }

    &-item {
      display: flex;
      align-items: center;
      justify-content: center;
      width: 100px;
      height: 100px;
      border-radius: 18px;
      background-color: red;
      background: rgba(255, 255, 255, 0.095);
      box-shadow: inset 2.01px -2.01px 20px rgba(214, 214, 214, 0.17), inset -3.01333px 3.01333px 3.01333px rgba(255, 255, 255, 0.39);
      backdrop-filter: blur(74.4293px);
    }
  }
}

.discover {
  &-title {
    display: flex;
    align-items: center;
    justify-content: space-between;

    p {
      font-family: 'Poppins';
      font-style: normal;
      font-weight: 500;
      font-size: 36px;
      letter-spacing: -1px;
      color: #FFFFFF;
    }
  }

  &-items {
    display: grid;
    grid-template-columns: auto auto auto auto;
    grid-row-gap: 20px;
    grid-column-gap: 20px;
    justify-content: space-between;
  }

  &-loadbtn {
    cursor: pointer;
    margin-top: 20px;
    align-self: center;
    width: 161px;
    height: 40px;
    border: 1px solid #D7D7D7;
    border-radius: 10px;
    background-color: transparent;
    font-family: 'Poppins';
    font-style: normal;
    font-weight: 500;
    font-size: 14px;
    letter-spacing: 1.5px;
    color: #BCBCBC;
  }
}

.item {
  display: flex;
  flex-direction: column;
  justify-self: center;

  &-img {
    object-fit: cover;
    flex-shrink: 0;
    width: 200px;
    height: 220px;
    border-radius: 10px;
    transition: .3s;
    cursor: pointer;

    &:hover {
      transform: scale(1.05);
    }
  }

  &-title {
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid white;

    font-family: 'Poppins';
    font-style: normal;
    font-weight: 600;
    font-size: 14px;
    line-height: 24px;
    color: #FFFFFF;
  }

  &-date {
    font-family: 'Poppins';
    font-style: normal;
    font-weight: 400;
    font-size: 14px;
    line-height: 24px;
    color: #BCBCBC;
  }
}

.filters {
  display: flex;
  align-items: center;

  .filter {
    display: flex;
    align-items: center;
    margin-right: 30px;
    font-family: 'Poppins';
    font-style: normal;
    font-weight: 500;
    font-size: 14px;
    color: #FFFFFF;

    svg {
      margin-right: 5px;
      margin-left: 5px;
    }
  }

  .filterbtn {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100px;
    height: 30px;
    background: linear-gradient(93.51deg, #9B51E0 2.84%, #3081ED 99.18%);
    border: none;
    border-radius: 10px;
    font-family: 'Poppins';
    font-style: normal;
    font-weight: 500;
    font-size: 14px;
    color: #FFFFFF;

    svg {
      margin-right: 5px;
    }
  }
}



@media screen and (max-width: 1500px) {
  .landingpage {
    max-width: 1200px;
  }
}

@media screen and (max-width: 1040px) {
  .box {
    flex-direction: column;

    .infobox {
      max-height: 450px;
      max-width: none;
      margin-bottom: 50px;
    }

    .display {
      display: none;
      max-height: none;
      max-width: none;
    }
  }

  .auction {
    .nft {
      grid-template-columns: auto auto;
      justify-content: space-around;
    }
  }

  .discover-items {
    grid-template-columns: auto auto auto;
    justify-content: space-around;
  }

  .footer {
    flex-direction: column;

    &-main {
      max-width: 80%;
      margin-bottom: 50px;
      text-align: center;
    }

    &-navigate {
      .nav {
        &:first-child {
          margin: 0;
        }
      }
    }
  }
}

@media screen and (max-width: 925px) {
  .navlinkwrap {
    display: none;
  }

  .buttonwrap {
    display: none;
  }

  .hamburger {
    display: flex !important;
    align-items: center;
  }

  .started-slimtext {
    text-align: center;
  }
}

@media screen and (max-width: 825px) {
  .started-items {
    display: grid;
    grid-template-columns: auto auto;
    justify-content: space-evenly;
    padding: 50px 0;

    &:before {
      height: 200px;
      top: 90px;
      filter: blur(120px);
    }
  }

  .discover-items {
    grid-template-columns: auto auto;
    justify-content: space-around;
  }
}

@media screen and (max-width: 700px) {
  .box {
    flex-direction: column;

    .infobox {
      max-height: none;
      max-width: none;
      margin-bottom: 50px;
    }

    .display {
      display: block;
      max-height: none;
      max-width: none;
    }
  }

  .discover-title {
    justify-content: center;

    .filters {
      display: none;
    }
  }

  .auction {
    .title {
      justify-content: center;

      .titleslim {
        display: none;
      }
    }
  }
}

@media screen and (max-width: 600px) {
  .landingpage {
    padding: 0 20px;
  }

  .box {
    .infobox {
      &-boldtext {
        font-size: 45px;
        line-height: 50px;
      }

      &-slimtext {
        font-size: 14px;
        line-height: 16px;
      }
    }
  }

  .discover-items {
    grid-template-columns: auto;
    justify-content: space-around;
  }

  .auction {
    .nft {
      grid-template-columns: auto;
      justify-content: space-around;
    }
  }

  .footer-main {
    font-size: 20px;
    line-height: 30px;
    max-width: 100%;
    margin-bottom: 50px;
    text-align: center;
  }

  .footer-navigate {
    justify-content: space-between;
    width: 100%;

    .nav {
      margin-left: 20px;

      h5 {
        font-size: 15px;
        line-height: 30px;
      }

      p {
        font-size: 10px;
        line-height: 18px;
      }
    }
  }
}

@media screen and (max-width: 480px) {
  .landingpage {
    .box {
      .infobox {
        &-boldtext {
          font-size: 32px;
          line-height: 1.4em;
          text-align: center;
        }

        &-slimtext {
          text-align: center;
        }

        &-btnwrapper {
          justify-content: center;
        }
      }
    }
  }
}

@keyframes leftslide {
  from {
    transform: translateX(-700px);
  }

  to {
    transform: translateX(0px);
  }
}

@keyframes rightslide {
  from {
    transform: translateX(550px);
  }

  to {
    transform: translateX(0px);
  }
}
</style>