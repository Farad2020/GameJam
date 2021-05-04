<template>
<div>

  <div class="pb-2">
    <h3 class="m-0 text-black my_main_header">Popular</h3>
    <hr/>
  </div>

  <div class="container">
    <div class="row">
      <div @click="redirect(item.id)" class="col-3 pb-3" v-for="item in content" :key="item.id">
        <div class="mdc-card mdc-card--outlined">
          <div class="mdc-card__primary-action">
            <div class="mdc-card__media">
              <div  class="md-image">
                <img v-bind:src="item.thumbnail" class="d-block w-100 my_thumbnail" alt="...">
              </div>
            </div>
          </div>
          <div class="mdc-card__actions">
            <div class="mdc-card__action-buttons">
              <button class="mdc-button mdc-card__action mdc-card__action--button">
                <div class="mdc-button__ripple"></div>
                <span class="mdc-button__label" >{{getTitleSnippet(item.title)}}</span>
              </button>
            </div>
            <div class="mdc-card__action-icons">
              <button class="material-icons mdc-icon-button mdc-card__action mdc-card__action--icon" title="Favorite">favorite</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import PublicDealsService from "@/services/public.deals.service";

export default {
  name: "HomeMainGrid",
  data() {
    return {
      content: ''
    };
  },
  methods: {
    getTitleSnippet(title){
      if (title.length > 25){
        return title.substring(0, 22) + "..."
      }
      return title
    },
    redirect(id){
      this.$router.push("/item/" + id)
    },
  },
  mounted() {
    PublicDealsService.getTopDeals(16).then(
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

<style scoped>

</style>

<!--<div class="mdc-card mdc-card&#45;&#45;outlined">-->
<!--<div class="mdc-card__primary-action">-->
<!--  <div class="mdc-card__media">-->
<!--    <div class="md-image">-->
<!--      <img src="https://blog.ru.playstation.com/tachyon/sites/11/2020/09/Devil-May-Cry-5-Special-Edition-featured-image.jpg?resize=1088,612&crop_strategy=smart" class="d-block w-100" alt="...">-->
<!--    </div>-->
<!--  </div>-->
<!--</div>-->
<!--<div class="mdc-card__actions">-->
<!--  <div class="mdc-card__action-buttons">-->
<!--    <button class="mdc-button mdc-card__action mdc-card__action&#45;&#45;button">-->
<!--      <div class="mdc-button__ripple"></div>-->
<!--      <span class="mdc-button__label">Action 1</span>-->
<!--    </button>-->
<!--    <button class="mdc-button mdc-card__action mdc-card__action&#45;&#45;button">-->
<!--      <div class="mdc-button__ripple"></div>-->
<!--      <span class="mdc-button__label">Action 2</span>-->
<!--    </button>-->
<!--  </div>-->
<!--  <div class="mdc-card__action-icons">-->
<!--    <button class="material-icons mdc-icon-button mdc-card__action mdc-card__action&#45;&#45;icon" title="Share">share</button>-->
<!--    <button class="material-icons mdc-icon-button mdc-card__action mdc-card__action&#45;&#45;icon" title="More options">more_vert</button>-->
<!--  </div>-->
<!--</div>-->
<!--</div>-->