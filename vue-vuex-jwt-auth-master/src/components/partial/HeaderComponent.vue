<template>
  <nav class="navbar navbar-expand navbar-dark my_header w-100">
    <a href class="navbar-brand" @click.prevent>GameJam</a>
    <div class="navbar-nav mr-auto">
      <li class="nav-item">
        <router-link to="/home" class="nav-link my_link">
          <font-awesome-icon icon="home" /> Home
        </router-link>
      </li>
      <li v-if="showAdminBoard" class="nav-item">
        <router-link to="/admin" class="nav-link my_link"> Admin Board</router-link>
      </li>
      <li v-if="showModeratorBoard" class="nav-item">
        <router-link to="/mod" class="nav-link my_link"> Moderator Board</router-link>
      </li>
      <li class="nav-item">
        <router-link v-if="currentUser" to="/user" class="nav-link my_link"> User</router-link>
      </li>
    </div>

    <div v-if="!currentUser" class="navbar-nav ml-auto">
      <li class="nav-item">
        <router-link to="/register" class="nav-link my_link">
          <font-awesome-icon icon="user-plus" /> Sign Up
        </router-link>
      </li>
      <li class="nav-item">
        <router-link to="/login" class="nav-link my_link">
          <font-awesome-icon icon="sign-in-alt" /> Login
        </router-link>
      </li>
    </div>

    <div v-if="currentUser" class="navbar-nav ml-auto">
      <li class="nav-item">
        <router-link to="/profile" class="nav-link">
          <font-awesome-icon icon="user" />
          {{ currentUser.username }}
        </router-link>
      </li>
      <li class="nav-item">
        <a class="nav-link" href @click.prevent="logOut">
          <font-awesome-icon icon="sign-out-alt" /> LogOut
        </a>
      </li>
    </div>
  </nav>
</template>

<script>
export default {
  name: "HeaderComponent"
};
</script>
<!--https://css-tricks.com/4-ways-to-animate-the-color-of-a-text-link-on-hover/-->
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Courgette&display=swap');
.navbar-brand{
  font-family: 'Courgette', cursive;
  font-weight: bold;
}

.my_logo{
  color: #FFF;
  text-decoration: none;
  font-size: x-large;
}

.my_logo:hover{
  color: #FCF7FF;
}

.my_header{
  min-height: 5vh;
  max-height: 5vh;
  background-color: #52057b;
  color: white;
  /*position: absolute;*/
}

.my_link{
  color: white;
}

.my_link:hover{
  color: #FCF7FF;
}
</style>

<!--
fonts:
https://fonts.google.com/?preview.text=GameJam&preview.text_type=custom

https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap
https://fonts.google.com/specimen/Montserrat?preview.text=GameJam&preview.text_type=custom
https://fonts.google.com/specimen/Caveat?preview.text=GameJam&preview.text_type=custom#standard-styles
https://fonts.google.com/specimen/Amatic+SC?preview.text=GameJam&preview.text_type=custom#standard-styles
https://fonts.google.com/specimen/Alfa+Slab+One?preview.text=GameJam&preview.text_type=custom#about
https://fonts.googleapis.com/css2?family=Courgette&display=swap
-->