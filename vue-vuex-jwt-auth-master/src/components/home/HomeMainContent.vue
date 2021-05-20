<template>

  <div class="container">
    <div class="pb-2">
      <h3 class="m-0 text-black my_main_header">Types</h3>
      <hr/>
    </div>

    <nav class="nav justify-content-center">
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Games</button>
        <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Loot</button>
      </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">

        <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
          <li @click="redirect(game.id)" class="mdc-list-item" tabindex="0" v-for="game in games" :key="game.id">
            <div class="mdc-list--icon-list m-1">
              <div class="my_search_list_image">
                <img v-bind:src="game.thumbnail" class="d-block w-100" alt="...">
              </div>
            </div>
            <span class="mdc-list-item__ripple"></span>
              <span class="mdc-list-item__text">
                <span class="mdc-list-item__primary-text">{{game.title}}</span>
                <span class="mdc-list-item__secondary-text">{{game.platforms}}</span>
              </span>
            <div class="w-100"></div>
          </li>
          <div class="mdc-list-divider mt-1 mb-1"></div>
        </ul>

      </div>
      <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">

        <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
          <li @click="redirect(item.id)" class="mdc-list-item" tabindex="0" v-for="item in loot" :key="item.id">
            <div class="mdc-list--icon-list m-1">
              <div class="my_search_list_image">
                <img v-bind:src="item.thumbnail" class="d-block w-100" alt="...">
              </div>
            </div>
            <span class="mdc-list-item__ripple"></span>
            <span class="mdc-list-item__text">
                <span class="mdc-list-item__primary-text">{{item.title}}</span>
                <span class="mdc-list-item__secondary-text">{{item.platforms}}</span>
              </span>
            <div class="w-100"></div>
          </li>
          <div class="mdc-list-divider mt-1 mb-1"></div>
        </ul>

      </div>
    </div>
  </div>

</template>

<script>
import PublicDealsService from "@/services/public.deals.service";

export default {
  name: "HomeMainContent",
  components: {},
  data() {
    return {
      games: '',
      loot: ''
    };
  },
  methods: {
    redirect(id){
      this.$router.push("/item/" + id)
    },
  },
  mounted() {
    PublicDealsService.getTopDealsByType("game", "popularity", 8).then(
        response => {
          this.games = response.data;
        },
        error => {
          this.games =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );

    PublicDealsService.getTopDealsByType("loot", "popularity", 8).then(
        response => {
          this.loot = response.data;
        },
        error => {
          this.loot =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );
  }
};
</script>

<style scoped>

</style>