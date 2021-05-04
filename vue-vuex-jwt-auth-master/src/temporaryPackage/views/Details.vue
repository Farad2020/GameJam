<template>
  <DetailsHeader/>
  <DetailsBody/>
</template>

<script>
import DetailsHeader from "@/components/details/DetailsHeader";
import DetailsBody from "@/components/details/DetailsBody";
export default {
  name: "Details",
  components: { DetailsBody, DetailsHeader }
};
</script>

<style scoped>

</style>