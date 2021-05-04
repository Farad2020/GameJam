<template>
  <div>
    <div>
      <form class="form-inline w-100 my_searchbar">
        <input
            v-model="search_text"
            @input="searchItems(search_text)"
            class="form-control mr-sm-2 w-100 "
            type="search" placeholder="Type Something, To Find Something..." aria-label="Search">
      </form>
    </div>

    <div class="mt-5" v-if="content.length == 0 && search_text.length != 0">
      <div class="d-flex align-items-center justify-content-center">
        <h2>Everything Fades... Just like the content you're looking for...</h2>
      </div>
      <div class="d-flex align-items-center justify-content-center mt-2">
        <img class="w-75" src="../../assets/gifs/searchFail.gif">
      </div>
    </div>

    <div class="mt-5" v-if="search_text.length == 0">
      <div class="d-flex align-items-center justify-content-center">
        <h2>Type Something, To Find Something...</h2>
      </div>
      <div class="d-flex align-items-center justify-content-center mt-2">
        <img class="w-75" src="../../assets/gifs/searchInit.gif">
      </div>
    </div>

    <ul class="mdc-list mdc-list--two-line mdc-list--image-list">
      <li @click="redirect(item.id)" v-for="item in content" :key="item.id" class="mdc-list-item" tabindex="0">

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
  name: "SearchListComponent",
  data() {
    return {
      search_text: "",
      searching: false,
      search_failed: false,
      content: ''
    }
  },
  methods: {

    redirect(id){
      this.$router.push("/item/" + id)
    },

    searchItems(search_text){
      this.search_failed = true;
      this.searching = true;

      PublicDealsService.getDealBySearch(search_text).then(
          response => {
            this.content = response.data;
            this.searching = false;
            if( this.content.length > 0){
              this.search_failed = false;
            }
          },
          error => {
            this.search_failed = true;
            this.content =
                (error.response && error.response.data && error.response.data.message) ||
                error.message ||
                error.toString();
            this.searching = false;
          }
      )
    }
  }
};
</script>

<style scoped>
.my_searchbar{
  margin-top: 3vh;
}
</style>