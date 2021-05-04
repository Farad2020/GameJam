<template>
  <div id="main_container">
    <HeaderComponent/>
    <router-view />
  </div>
  <FooterComponent/>
</template>

<script>
import HeaderComponent from "@/components/partial/HeaderComponent";
import FooterComponent from "@/components/partial/FooterComponent";
export default {
  components: { FooterComponent, HeaderComponent }
}


</script>

<!--https://css-tricks.com/4-ways-to-animate-the-color-of-a-text-link-on-hover/-->
<style>
/*get back to top from github https://github.com/Farad2020/GameLibra/blob/main/GameLibra/Content/Site.css*/
</style>
