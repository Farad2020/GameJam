<template>
<div class="container pt-5">

  <div class="row">
    <div class="col-7">
      <div class="">
        <img v-bind:src="deal.thumbnail" class="d-block w-100 h-100" alt="...">
      </div>
      <p v-if="deal.title" class="text-center text-black pt-2 font-weight-bold">
        <span class="item_det_title" >{{deal.title}}</span>
      </p>
      <div class="item_det_grid">


        <hr class="my-2"/>
        <!--      Row 1-->
        <div class="row" v-if="deal.worth">
          <div class="col-2">
            <!--          Part1-->
            <p class="item_det_text">
              <span>Worth: </span>
            </p>
          </div>
          <div class="col">
            <!--          Part1-->

            <div class="d-flex justify-content-between">
              <p class="item_det_text">
                <span>{{deal.worth}}</span>
              </p>
              <button v-if="already_saved" @click="saveGiveaway(deal.id)" class=" material-icons mdc-icon-button mdc-card__action mdc-card__action--icon" title="turned_in_not">turned_in_not</button>
              <button v-if="!already_saved" @click="saveGiveaway(deal.id)" class=" material-icons mdc-icon-button mdc-card__action mdc-card__action--icon" title="turned_in_not">turned_in</button>
            </div>
          </div>
        </div>


        <!--      Row 2-->
        <div class="row" v-if="deal.description">
          <div class="col-2">
            <!--          Part2-->
            <p class="item_det_text">
              <span>Description: </span>
            </p>
          </div>
          <div class="col">
            <!--          Part2-->
            <p class="item_det_text">
              <span>{{deal.description}}</span>
            </p>
          </div>
        </div>


        <!--      Row 3-->
        <div class="row" v-if="deal.open_giveaway_url">
          <div class="col-2">
            <!--          Part3-->
            <p class="item_det_text">
              <span>Instructions Source: </span>
            </p>
          </div>
          <div class="col">
            <p class="item_det_text">
              <span><a class="text_det_link" v-bind:href="deal.open_giveaway_url" target="_blank" >Click here to get the information source!</a> </span>
            </p>
          </div>
        </div>


        <!--      Row 5-->
        <div class="row"  v-if="deal.type">
          <div class="col-2">
            <!--          Part5-->
            <p class="item_det_text">
              <span>Type: </span>
            </p>
          </div>
          <div class="col">
            <!--          Part5-->
            <p class="item_det_text">
              <span>{{deal.type}}</span>
            </p>
          </div>
        </div>


        <!--      Row 6-->
        <div class="row"  v-if="deal.platforms">
          <div class="col-2">
            <!--          Part 6-->
            <p class="item_det_text">
              <span>Platforms: </span>
            </p>
          </div>
          <div class="col">
            <!--          Part6-->
            <p class="item_det_text">
              <span>{{deal.platforms}}</span>
            </p>
          </div>
        </div>


        <!--      Row 7-->
        <div class="row"  v-if="deal.end_date">
          <div class="col-2">
            <!--          Part 7-->
            <p class="item_det_text">
              <span>Ends: </span>
            </p>
          </div>
          <div class="col">
            <!--          Part7-->
            <p class="item_det_text">
              <span>{{deal.end_date}}</span>
            </p>
          </div>
        </div>


        <!--      Row 8-->
        <div class="row"  v-if="deal.status">
          <div class="col-2">
            <!--          Part 8-->
            <p class="item_det_text">
              <span>Giveaway Status: </span>
            </p>
          </div>
          <div class="col">
            <!--          Part8-->
            <p class="item_det_text item_det_highlight">
              <span>{{deal.status}}</span>
            </p>
          </div>
        </div>


        <!--      Row 9-->
        <div class="row"  v-if="deal.published_date">
          <div class="col-2">
            <!--          Part 9-->
            <p class="item_det_text">
              <span>Published: </span>
            </p>
          </div>
          <div class="col">
            <!--          Part9-->
            <p class="item_det_text item_det_highlight">
              <span>{{deal.published_date}}</span>
            </p>
          </div>
        </div>
      </div>

    </div>
    <div class="col">
      <img class="w-100 my_sidebar_gif" src="../assets/gifs/sidebarRainCity.gif">
<!--      Example Path:: ../assets/gifs/sidebarNightCity.gif-->
      <!--      Image source:: https://i.imgur.com/CgKDPlb.gif-->
<!--
1
https://i.pinimg.com/originals/5d/b9/dc/5db9dc7065e87d1c7075c365a17dbc2c.gif
2
https://cdn112.picsart.com/216053779002202.gif?to=min&r=640
3
https://66.media.tumblr.com/43ff1ae84968ffd84606207e9995a78e/tumblr_py4mvbGe6h1tgo74ho1_1280.gif
4
https://cdn.dribbble.com/users/1427228/screenshots/5497843/red.gif
5
https://i.imgur.com/CgKDPlb.gif
6
https://i.imgur.com/eTm7oez.gif
7
https://i.pinimg.com/originals/bd/1b/04/bd1b04ae480a107f6335219c6a561f6d.gif

8

https://i.pinimg.com/originals/23/8c/b9/238cb9462110a2657d3577c0de28f122.gif
-->
    </div>
  </div>
</div>
</template>

<script>
import PublicDealsService from "@/services/public.deals.service";

export default {
name: "ItemDetails",
  data() {
    return {
      deal: '',
      main_id: '',
      already_saved: ''
    };
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }

    PublicDealsService.getDealById(this.$route.params.id).then(
        response => {
          this.deal = response.data;
          this.loadGiveawayData(this.deal.id)
        },
        error => {
          this.deal =
              (error.response && error.response.data && error.response.data.message) ||
              error.message ||
              error.toString();
        }
    );


  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  methods: {
    /* Change button state */
    saveGiveaway(giveawayId){
      PublicDealsService.linkUserAndDeal(giveawayId).then(
          response => {
            this.already_saved = response.data;
          },
          error => {
            this.already_saved =
                (error.response && error.response.data && error.response.data.message) ||
                error.message ||
                error.toString();
          }
      )
    },

    loadGiveawayData(giveawayId){
      PublicDealsService.checkUserDeal(giveawayId).then(
          response => {
            this.already_saved = response.data;
          },
          error => {
            this.already_saved =
                (error.response && error.response.data && error.response.data.message) ||
                error.message ||
                error.toString();
          }
      )
    }

  }
}
</script>

<style scoped>
.my_sidebar_gif{

}
</style>