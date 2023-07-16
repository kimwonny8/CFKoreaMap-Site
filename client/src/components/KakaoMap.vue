<template>
  <section>
    <div id="map"></div>
    <div id="menu_wrap" class="bg_white">
      <div v-if="!search">
        <button class="search_btn" @click="search=true">검색하기</button> 
      </div>
      <div v-else>
        <input type="text" v-model="keyword" id="keyword" size="15"> 
        <button class="search_btn" @click="searchPlaces()" @keyup.enter="searchPlaces()">검색</button> 
      </div>
      <div id="pagination">
        <a v-for="pageNum in pagination.last" :key="pageNum" :class="{ on: pageNum === pagination.current }" @click="goToPage(pageNum)">
          {{ pageNum }}
        </a>
      </div>
      <ul id="placesList">
        <li v-for="(place, index) in places" :key="index" class="item">
          <span :class="'markerbg marker_' + (index + 1)"></span>
          <div class="info">
            <a href="#" class="gym_btn">{{ place.place_name }}</a>
            <span v-if="place.road_address_name">{{ place.road_address_name }}</span>
            <span class="jibun gray">{{ place.address_name }}</span>
            <span class="tel">{{ place.phone }}</span>
          </div>
        </li>
      </ul>
    </div>
  </section>
</template>

<script>
export default {
  name: "",
  data() {
    return {
      map: null,
      markers: [],
      latitude: 0,
      longitude: 0,
      keyword: "crossfit",
      places: [],
      pagination: {},
      search: false
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.VUE_APP_KAKAO_API_KEY}&autoload=false&libraries=services`;
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(this.latitude, this.longitude),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
      this.searchPlaces();
    },
    searchPlaces() {
      const ps = new kakao.maps.services.Places();

      ps.keywordSearch(this.keyword, (data, status, pagination) => {
        if (status === kakao.maps.services.Status.OK) {
          this.places = data;
          this.pagination = pagination;
          this.displayPlaces();
        } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
          alert("검색 결과가 존재하지 않습니다.");
        } else if (status === kakao.maps.services.Status.ERROR) {
          alert("검색 결과 중 오류가 발생했습니다.");
        }
      });
    },
    displayPlaces() {
      const bounds = new kakao.maps.LatLngBounds();

      this.markers.forEach((marker) => marker.setMap(null));
      this.markers = [];

      for (let i = 0; i < this.places.length; i++) {
        const place = this.places[i];
        const placePosition = new kakao.maps.LatLng(place.y, place.x);
        const marker = this.addMarker(placePosition, i);
        this.markers.push(marker);

        bounds.extend(placePosition);
      }

      this.map.setBounds(bounds);
    },
    addMarker(position, idx) {
      const imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png";
      const imageSize = new kakao.maps.Size(36, 37);
      const imgOptions = {
        spriteSize: new kakao.maps.Size(36, 691),
        spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10),
        offset: new kakao.maps.Point(13, 37),
      };
      const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions);
      const marker = new kakao.maps.Marker({
        position: position,
        image: markerImage,
      });

      marker.setMap(this.map);
      return marker;
    },
    goToPage(pageNum) {
      this.pagination.gotoPage(pageNum);
    },
  },
};
</script>

<style scoped>
section {
  width: 100%;
  height: 80vh;
}

section {
  opacity: 0;
  transform: translateY(20px);
  animation: fadeIn 0.5s ease forwards;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

#map {
  width: 50vw;
  height: 70vh;
  position: relative;
  overflow: hidden;
}

.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-size: 12px;
}

.map_wrap a,
.map_wrap a:hover,
.map_wrap a:active {
  color: #000;
  text-decoration: none;
}

.map_wrap {
  position: relative;
  width: 100%;
  height: 500px;
}

#menu_wrap {
  width: 300px;
  height: 69vh;
  margin: 0 5px;
  padding: 5px 0;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.7);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}

.bg_white {
  background: #fff;
}

#menu_wrap hr {
  display: block;
  height: 1px;
  border: 0;
  border-top: 2px solid #5f5f5f;
  margin: 3px 0;
}

#menu_wrap .option {
  text-align: center;
}

#menu_wrap .option p {
  margin: 10px 0;
}

#menu_wrap .option button {
  margin-left: 5px;
}

#placesList li {
  list-style: none;
}

#placesList .item {
  position: relative;
  border-bottom: 1px solid #888;
  overflow: hidden;
  min-height: 65px;
}

#placesList .item span {
  display: block;
  margin-top: 10px;
}

#placesList .item .gym_btn,
#placesList .item .info {
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}

#placesList .info .gray {
  color: #8a8a8a;
}

#placesList .info .jibun {
  padding-left: 26px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;
}

#placesList .info .tel {
  color: #009900;
}

#placesList .item .markerbg {
  float: left;
  position: absolute;
  width: 36px;
  height: 35px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;
}

#placesList .item .marker_1 {
  background-position: 0 -10px;
}

#placesList .item .marker_2 {
  background-position: 0 -56px;
}

#placesList .item .marker_3 {
  background-position: 0 -102px;
}

#placesList .item .marker_4 {
  background-position: 0 -148px;
}

#placesList .item .marker_5 {
  background-position: 0 -194px;
}

#placesList .item .marker_6 {
  background-position: 0 -240px;
}

#placesList .item .marker_7 {
  background-position: 0 -286px;
}

#placesList .item .marker_8 {
  background-position: 0 -332px;
}

#placesList .item .marker_9 {
  background-position: 0 -378px;
}

#placesList .item .marker_10 {
  background-position: 0 -423px;
}

#placesList .item .marker_11 {
  background-position: 0 -470px;
}

#placesList .item .marker_12 {
  background-position: 0 -516px;
}

#placesList .item .marker_13 {
  background-position: 0 -562px;
}

#placesList .item .marker_14 {
  background-position: 0 -608px;
}

#placesList .item .marker_15 {
  background-position: 0 -654px;
}

#pagination {
  margin: 10px auto;
  text-align: center;
}

#pagination a {
  display: inline-block;
  margin-right: 10px;
  font-size: 14px;
  padding: 0 5px;
}

#pagination a:hover {
  background-color: #ccc;
  border-radius: 50%;
}

#pagination .on {
  font-weight: bold;
  cursor: default;
  color: #777;
}

#placesList {
  margin: 0;
}
.search_btn {
  margin-top: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  padding: 3px 10px;
  font-family: 'Noto Sans KR', Avenir, Helvetica, Arial, sans-serif;
}
.search_btn:hover {
  opacity: 0.7;
}
input {
  border: 1px solid #ccc;
  border-radius: 3px;
  padding: 3px 10px;
  font-family: 'Noto Sans KR', Avenir, Helvetica, Arial, sans-serif;
}

.gym_btn {
  text-decoration: none;
  font-size: 14px;
  color: #000;
}

.gym_btn:hover {
  opacity: 0.5;
}
</style>
