<template>

  <div class="row m-0">
    <div class="col-8 offset-2">
      <h3 class="m-0">Registration</h3>
    </div>
  </div>
  <hr/>

  <div class="container">
    <div class="row my_min_h h-100 d-flex align-items-center">
      <div class="col-6 offset-3">
        <form>
          <div class="form-group pt-3">
            <label>Login</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="Enter login">
          </div>
          <div class="form-group pt-3">
            <label>Email address</label>
            <input type="email" class="form-control" aria-describedby="emailHelp" placeholder="Enter email">
          </div>
          <div class="form-group pt-3">
            <label>Password</label>
            <input type="password" class="form-control" placeholder="Password">
          </div>
          <div class="form-group pt-3">
            <label>Repeat Password</label>
            <input type="password" class="form-control" placeholder="Repeat Password">
          </div>
          <div class="d-flex justify-content-end pt-3">
            <button type="submit" class="btn btn-primary btn-bg-purple align-self-right">Submit</button>
          </div>
        </form>
        <div class="text-center">
          <p>Already have an account? You can login <a class="my_dark_text_link" href="/#/login">here</a></p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RegistrationMainBody"
};
</script>

<style scoped>
.my_dark_text_link{
  color: #000;
}

.my_dark_text_link:hover{
  color: #2c3e50;
}
</style>