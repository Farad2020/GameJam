<template>
  <div class="home">
    <HomeSliderComponent/>
    <HomeMainGrid/>
    <HomeMainContent/>
  </div>
</template>

<script>
// @ is an alias to /src
import HomeSliderComponent from "@/components/home/HomeSliderComponent";
import HomeMainGrid from "@/components/home/HomeMainGrid";
import HomeMainContent from "@/components/home/HomeMainContent";

export default {
  name: "Home",
  components: {
    HomeMainContent,
    HomeMainGrid,
    HomeSliderComponent,
  },
};
</script>
