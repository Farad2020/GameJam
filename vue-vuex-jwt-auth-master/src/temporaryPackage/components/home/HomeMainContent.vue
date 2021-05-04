<template>
  <div class="container">
    <nav class="nav justify-content-center">
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Games</button>
        <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Loot</button>
      </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
        <SearchListComponent/>
        <SearchListComponent/>
        <SearchListComponent/>
      </div>
      <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
        <SearchListComponent/>
        <SearchListComponent/>
      </div>
    </div>
  </div>

</template>

<script>
import SearchListComponent from "@/temporaryPackage/components/search/SearchListComponent";
export default {
  name: "HomeMainContent",
  components: {SearchListComponent}
};
</script>

<style scoped>

</style>