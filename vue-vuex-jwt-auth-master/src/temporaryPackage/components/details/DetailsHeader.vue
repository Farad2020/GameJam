<template>
  <div class="row m-0">
    <div class="col-8 offset-2">
      <h3 class="m-0">Lorem Ipsum</h3>
    </div>
  </div>
  <hr/>
  <div class="row mb-5 m-0 ">
    <div class="col-8 offset-2">
      <div id="homeCarousel" class="carousel slide" data-bs-touch="false" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://www.desktopbackground.org/download/o/2014/07/06/789117_uncharted-4-a-thiefs-end-wallpapers-hd_1920x1080_h.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://s1.1zoom.ru/big0/956/Men_Pistols_Uncharted_4_509990.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://games.mail.ru/hotbox/content_files/gallery/c7/ee/eb879c95.jpeg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#homeCarousel" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#homeCarousel" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DetailsHeader"
};
</script>

<style scoped>
</style>