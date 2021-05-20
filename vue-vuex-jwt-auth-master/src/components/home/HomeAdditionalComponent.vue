<template>
  <div class="container">
    <div class="pb-2">
      <h3 class="m-0 text-black my_main_header">Platforms</h3>
      <hr/>
    </div>

    <nav class="nav justify-content-center">
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <button class="nav-link active" id="nav-platform-1-tab" data-bs-toggle="tab" data-bs-target="#nav-platform-1" type="button" role="tab" aria-controls="nav-home" aria-selected="true">PC</button>
        <button class="nav-link" id="nav-platform-2-tab" data-bs-toggle="tab" data-bs-target="#nav-platform-2" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">PS4</button>
        <button class="nav-link" id="nav-platform-3-tab" data-bs-toggle="tab" data-bs-target="#nav-platform-3" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Switch</button>
        <button class="nav-link" id="nav-platform-4-tab" data-bs-toggle="tab" data-bs-target="#nav-platform-4" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">X Box One</button>
      </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="nav-platform-1" role="tabpanel" aria-labelledby="nav-home-tab">

        <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
          <li @click="redirect(item.id)" class="mdc-list-item" tabindex="0" v-for="item in pc_items" :key="item.id">
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
      <div class="tab-pane fade" id="nav-platform-2" role="tabpanel" aria-labelledby="nav-profile-tab">

        <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
          <li @click="redirect(item.id)" class="mdc-list-item" tabindex="0" v-for="item in ps4_items" :key="item.id">
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

      <div class="tab-pane fade" id="nav-platform-3" role="tabpanel" aria-labelledby="nav-profile-tab">

        <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
          <li @click="redirect(item.id)" class="mdc-list-item" tabindex="0" v-for="item in switch_items" :key="item.id">
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

      <div class="tab-pane fade" id="nav-platform-4" role="tabpanel" aria-labelledby="nav-profile-tab">

        <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
          <li @click="redirect(item.id)" class="mdc-list-item" tabindex="0" v-for="item in xbox_items" :key="item.id">
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
name: "HomeAdditionalComponent",
  data() {
    return {
      pc_items: '',
      ps4_items: '',
      xbox_items: '',
      switch_items: '',
    };
  },
  methods: {
    redirect(id){
      this.$router.push("/item/" + id)
    },
  },
  mounted() {
    PublicDealsService.getTopDealsByPlatform("pc", "popularity", 8).then(
        response => {
          this.pc_items = response.data;
        },
        error => {
          this.pc_items =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );

    PublicDealsService.getTopDealsByPlatform("ps4", "popularity", 8).then(
        response => {
          this.ps4_items = response.data;
        },
        error => {
          this.ps4_items =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );

    PublicDealsService.getTopDealsByPlatform("xbox-one", "popularity", 8).then(
        response => {
          this.xbox_items = response.data;
        },
        error => {
          this.xbox_items =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );

    PublicDealsService.getTopDealsByPlatform("switch", "popularity", 8).then(
        response => {
          this.switch_items = response.data;
        },
        error => {
          this.switch_items =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );
  }
}
</script>

<style scoped>

</style>