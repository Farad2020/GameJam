<template>
<!--  <header class="mdc-top-app-bar mdc-top-app-bar&#45;&#45;dense my_header">-->
<!--    <div class="mdc-top-app-bar__row">-->
<!--      <a href="/" class="mdc-top-app-bar__section mdc-top-app-bar__section&#45;&#45;align-start my_logo">-->
<!--        <span class="mdc-top-app-bar__title">GameJam</span>-->
<!--      </a>-->
<!--      <section class="mdc-top-app-bar__section mdc-top-app-bar__section&#45;&#45;align-end" role="toolbar">-->
<!--        <a href="#" class="material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Favorite">favorite</a>-->
<!--        <a href="/#/search" class="material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Search">search</a>-->
<!--        <a href="#" class="material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="account_circle">account_circle</a>-->
<!--      </section>-->
<!--    </div>-->
<!--  </header>-->
<!--  <div class="mdc-top-app-bar&#45;&#45;fixed-adjust">-->
<!--  </div>-->

  <nav class="navbar fixed-top navbar-expand-lg navbar-light my_header d-flex justify-content-between">
    <div>
      <a class="navbar-brand my_logo mdc-top-app-bar__title" href="#">GameJam</a>
    </div>
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a href="/#/login" class="my_link material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="account_circle">account_circle</a>
        </li>
        <li class="nav-item dropdown">
          <a href="#" class="my_link material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Favorite">favorite</a>
        </li>
        <li class="nav-item">
          <a href="/#/search" class="my_link material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Search">search</a>
        </li>
      </ul>
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
.mdc-top-app-bar__title{
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