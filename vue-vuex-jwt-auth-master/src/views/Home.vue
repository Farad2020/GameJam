<template>
  <div>
<!--    class="container"-->
<!--    <header class="jumbotron">-->
<!--      <h3>{{content}}</h3>-->
<!--    </header>-->
    <HomeSliderComponent/>
    <HomeMainGrid/>
    <HomeMainContent/>
    <HomeAdditionalComponent/>
  </div>
</template>

<script>
import UserService from '../services/user.service';
import HomeMainContent from "@/components/home/HomeMainContent";
import HomeMainGrid from "@/components/home/HomeMainGrid";
import HomeSliderComponent from "@/components/home/HomeSliderComponent";
import HomeAdditionalComponent from "@/components/home/HomeAdditionalComponent";

export default {
  name: 'Home',
  components: {HomeAdditionalComponent, HomeSliderComponent, HomeMainGrid, HomeMainContent},
  data() {
    return {
      content: ''
    };
  },
  mounted() {
    UserService.getPublicContent()
        .then(
      response => {
        this.content = response.data;
      },
      error => {
        this.content =
          (error.response && error.response.data && error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );
  }
};
</script>
