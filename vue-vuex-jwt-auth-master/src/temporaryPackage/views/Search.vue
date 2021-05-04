<template>

  <div class="row m-0">
    <div class="col-8 offset-1">
      <h3 class="m-0">Results of Search "Lorem Ipsum":</h3>
    </div>
  </div>
  <hr/>
  <div class="container">
    <SearchListComponent/>
    <SearchListComponent/>
    <SearchListComponent/>
    <SearchListComponent/>
  </div>
</template>

<script>
import SearchListComponent from "@/components/search/SearchListComponent";
export default {
  name: "Search",
  components: { SearchListComponent }
};
</script>

<style scoped>

h3{
  font-family: 'Courgette', cursive;
  font-weight: bold;
}
</style>