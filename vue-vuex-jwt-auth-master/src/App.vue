<template>
  <div id="app">
    <a id="back-to-top-btn">
      <button class="material-icons mdc-icon-button back-to-top-btn-icon" title="arrow_drop_up">arrow_drop_up</button>
    </a>

    <nav class="navbar navbar-expand navbar-dark my_header w-100">
      <a href class="navbar-brand" @click.prevent>GameJam</a>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/home" class="nav-link my_link text-white">
            <font-awesome-icon icon="home" /> Home
          </router-link>
        </li>
        <li v-if="showAdminBoard" class="nav-item">
          <router-link to="/admin" class="nav-link my_link text-white"> Admin Board</router-link>
        </li>
        <li v-if="showModeratorBoard" class="nav-item">
          <router-link to="/mod" class="nav-link my_link text-white"> Moderator Board</router-link>
        </li>
        <li class="nav-item">
          <router-link v-if="currentUser" to="/user" class="nav-link my_link text-white"> User</router-link>
        </li>
      </div>

      <div class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/search" class="nav-link my_link">
            <button class="material-icons mdc-icon-button text-white" title="search">search</button>
          </router-link>
        </li>
      </div>

      <div v-if="!currentUser" class="navbar-nav">
        <li class="nav-item">
          <router-link to="/register" class="nav-link my_link text-white">
            <font-awesome-icon icon="user-plus" /> Sign Up
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/login" class="nav-link my_link text-white">
            <font-awesome-icon icon="sign-in-alt" /> Login
          </router-link>
        </li>
      </div>

      <div v-if="currentUser" class="navbar-nav">
        <li class="nav-item">
          <router-link to="/profile" class="nav-link text-white">
            <font-awesome-icon icon="user" />
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" /> LogOut
          </a>
        </li>
      </div>
    </nav>

    <div class="container my_min_h_80">
      <router-view />
    </div>

    <FooterComponent/>
  </div>
</template>

<script>
import FooterComponent from "@/components/partial/FooterComponent";
import $ from 'jquery';
export default {
  components: {FooterComponent},
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }

      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_MODERATOR');
      }

      return false;
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  },
  mounted() {

    $(document).ready(function() {

      var btn = $('#back-to-top-btn');

      $(window).scroll(function () {
        if ($(window).scrollTop() > 300) {
          btn.addClass('show');
        } else {
          btn.removeClass('show');
        }
      });

      btn.on('click', function (e) {
        e.preventDefault();
        $('html, body').animate({ scrollTop: 0 }, 0);
      });
    });
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Courgette&display=swap');
.navbar-brand{
  font-family: 'Courgette', cursive;
  font-weight: bold;
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
Registered Users:
admin
moder
test
---------------Password-------------------
tester
-->