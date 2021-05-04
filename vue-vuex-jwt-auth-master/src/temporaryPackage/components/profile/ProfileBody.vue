<template>
  <div class="row m-0">
    <div class="col-8 offset-2">
      <h3 class="m-0">FaraWatt</h3>
    </div>
  </div>
  <hr/>

  <div class="container pb-5">
    <div class="row my_min_h h-100 d-flex align-items-center">
      <div class="col-6 offset-3">
        <form>
          <div class="form-group pt-3">
            <label>Login</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" value="FaraWatt" readonly>
          </div>
          <div class="form-group pt-3">
            <label>Email address</label>
            <input type="email" class="form-control" aria-describedby="emailHelp" value="real@mail.ru" readonly>
          </div>

          <div class="row m-0">
            <div class="col p-0 pt-5">
              <h3 class="m-0">Change Password</h3>
            </div>
          </div>
          <hr/>
          <div class="form-group pt-3">
            <label>Old Password</label>
            <input type="password" class="form-control" placeholder="Old Password">
          </div>
          <div class="form-group pt-3">
            <label>New Password</label>
            <input type="password" class="form-control" placeholder="New Password">
          </div>
          <div class="form-group pt-3">
            <label>Repeat Password</label>
            <input type="password" class="form-control" placeholder="Repeat Password">
          </div>
          <div class="d-flex justify-content-end pt-3">
            <button type="submit" class="btn btn-primary btn-bg-purple align-self-right">Submit</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProfileBody"
};
</script>

<style scoped>
</style>