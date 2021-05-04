<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        Profile of <strong>{{currentUser.username}}</strong>
      </h3>
    </header>
    <p>
      <strong>Email:</strong>
      {{currentUser.email}}
    </p>

<!--    <p>-->
<!--      <strong>Token:</strong>-->
<!--      {{currentUser.accessToken.substring(0, 20)}} ... {{currentUser.accessToken.substr(currentUser.accessToken.length - 20)}}-->
<!--    </p>-->
<!--    <p>-->
<!--      <strong>Id:</strong>-->
<!--      {{currentUser.id}}-->
<!--    </p>-->
<!--    <ul>-->
<!--      <li v-for="(role,index) in currentUser.roles" :key="index">{{role}}</li>-->
<!--    </ul>-->

    <strong>Roles:</strong>
    <p v-for="(role,index) in currentUser.roles" :key="index">{{role}}</p>


    <h3 v-if="deals.length != 0">
      Pinned Games:
    </h3>

    <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
      <li @click="redirect(item.id)" v-for="item in deals" :key="item.id" class="mdc-list-item" tabindex="0">

        <div class="mdc-list--icon-list m-1">
          <div class="my_search_list_image">
            <img v-bind:src="item.thumbnail" class="d-block w-100" alt="...">
          </div>
        </div>
        <span class="mdc-list-item__ripple"></span>
        <span class="mdc-list-item__text">
          <span class="mdc-list-item__primary-text">{{item.title}}</span>
          <span class="mdc-list-item__secondary-text">{{item.platform}}</span>
        </span>
      </li>
      <div class="mdc-list-divider mt-1 mb-1"></div>
    </ul>
  </div>
</template>

<script>
import PublicDealsService from "@/services/public.deals.service";

export default {
  name: 'Profile',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  data() {
    return {
      deals: '',
    };
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }

    PublicDealsService.getUserDeals().then(
        response => {
          this.deals = response.data;
        },
        error => {
          this.deals =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );
  },
  methods: {
    redirect(id){
      this.$router.push("/item/" + id)
    },
  }
};
</script>