<template>
  <ProfileBody/>
  <AdminBody/>
</template>

<script>
import AdminBody from "@/components/admin/AdminBody";
import ProfileBody from "@/components/profile/ProfileBody";
export default {
  name: "Admin",
  components: { ProfileBody, AdminBody }
};
</script>

<style scoped>

</style>