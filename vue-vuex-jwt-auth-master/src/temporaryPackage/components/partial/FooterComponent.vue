<template>
  <div class="my_footer text-center">
    <div class="footer_inner justify-content-center align-items-center">
      <p class="footer_inner_text"> <span class="font-weight-bold">GameJam</span> done by <a class="my_footer_link" href="https://github.com/Farad2020"> Farad2020</a>. Copyright © 2021</p>
    </div>
    <div id="nav">
      <router-link class="md-list-item-link" to="/">Home</router-link> |
      <router-link class="md-list-item-link" to="/item">Item Page</router-link> |
      <router-link class="md-list-item-link" to="/search">Search</router-link> |
      <router-link class="md-list-item-link" to="/profile">Account Page</router-link> |
      <router-link class="md-list-item-link" to="/login">Login Page</router-link> |
      <router-link class="md-list-item-link" to="/registration">Registration</router-link> |
      <router-link class="md-list-item-link" to="/admin">Admin</router-link> |
    </div>
  </div>
</template>

<script>
export default {
  name: "FooterComponent"
};
</script>

<style scoped>
</style>