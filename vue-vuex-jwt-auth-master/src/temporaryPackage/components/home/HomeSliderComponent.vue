<template>
  <div>
  <div class="row m-0">
    <div class="col-8 offset-2">
      <h3 class="m-0">Featured</h3>
    </div>
  </div>
  <hr/>
  <div class="row mb-5 m-0 ">
    <div class="col-8 offset-2">
      <div id="homeCarousel" class="carousel slide" data-bs-touch="false" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://blog.ru.playstation.com/tachyon/sites/11/2020/09/Devil-May-Cry-5-Special-Edition-featured-image.jpg?resize=1088,612&crop_strategy=smart" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://imagebee.org/games/tekken-7/tekken-7-1-1920x1080.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://imagebee.org/games/night-in-the-woods/night-in-the-woods-wallpaper-10-1280x720.jpg" class="d-block w-100" alt="...">
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
  </div>
</template>

<script>
export default {
  name: "HomeSliderComponent"
};
</script>

<style scoped>
</style>